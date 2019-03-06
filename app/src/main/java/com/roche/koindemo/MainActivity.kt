package com.roche.koindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.roche.koindemo.di.Scopes
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import kotlin.random.Random

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private val presenter by inject<MainActivityPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindScope(getOrCreateScope(Scopes.SCOPE_ACTIVITY))

        btn_click.setOnClickListener {
            presenter.onSomething("It's ${Random.nextInt(10)}")
        }

        presenter.onCreateView(this)
    }

    override fun onDestroy() {
        presenter.onDestroyView()
        super.onDestroy()
    }

    override fun showMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
