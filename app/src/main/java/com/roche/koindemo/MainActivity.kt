package com.roche.koindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private val presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btn_click.setOnClickListener {
            presenter?.onSomething("It's ${Random.nextInt(10)}")
        }

        presenter?.onCreateView(this)
    }

    override fun onDestroy() {
        presenter?.onDestroyView()
        super.onDestroy()
    }

    override fun showMessage(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
