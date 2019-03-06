package com.roche.koindemo

import com.roche.koindemo.di.networkModule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest

class FakeApiTest : AutoCloseKoinTest() {

    private val fakeApi by inject<FakeApi>()

    @Before
    fun setUp() {
        startKoin(listOf(networkModule))
    }

    @Test
    fun getStatus() {
        assertEquals(fakeApi.status, "Fake status")
    }
}