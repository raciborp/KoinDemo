package com.roche.koindemo

import com.roche.koindemo.di.Scopes
import com.roche.koindemo.di.applicationModule
import com.roche.koindemo.di.networkModule
import com.roche.koindemo.di.viewModule
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest
import org.koin.test.declareMock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class MainActivityPresenterTest : AutoCloseKoinTest() {

    private val presenter by inject<MainActivityPresenter>()
    private val fakeApi by inject<FakeApi>()
    private val localRepository by inject<LocalRepository>()
    private val view = mock(MainActivityPresenter.View::class.java)

    @Before
    fun setUp() {
        startKoin(listOf(viewModule, networkModule, applicationModule))
        getKoin().createScope(Scopes.SCOPE_ACTIVITY)
        declareMock<LocalRepository>()
        declareMock<FakeApi>()
        initMocks()
    }

    private fun initMocks() {
        `when`(fakeApi.status).thenReturn("TEXT")
    }

    @Test
    fun onCreateView() {
        presenter.onCreateView(view)

        verify(view).showMessage("TEXT")
    }

    @Test
    fun onSomething() {
        val text = "Text2"
        `when`(localRepository.text).thenReturn(text)
        presenter.onCreateView(view)

        presenter.onSomething(text)

        verify(localRepository).saveText(text)
        verify(view).showMessage(text)
    }
}