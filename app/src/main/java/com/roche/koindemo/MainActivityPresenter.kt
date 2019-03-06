package com.roche.koindemo

interface MainActivityPresenter {
    fun onCreateView(view: View)
    fun onDestroyView()
    fun onSomething(text: String)

    interface View {
        fun showMessage(text: String)
    }
}

class MainActivityPresenterImpl(
    private val repository: LocalRepository,
    private val fakeApi: FakeApi
) : MainActivityPresenter {
    private var view: MainActivityPresenter.View? = null

    override fun onCreateView(view: MainActivityPresenter.View) {
        this.view = view
        view.showMessage(fakeApi.status)
    }

    override fun onDestroyView() {
        view = null
    }

    override fun onSomething(text: String) {
        repository.saveText(text)
        view?.showMessage(repository.text)
    }
}