package com.kmmx.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar.title = "titulo"

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val valor = 1.suma(2)
        val valorsuma = 1.resta(2)

    }

    infix fun Int.suma(add: Int): Int {
        return this + add
    }

    fun Int.resta(rest: Int) = this - rest

}
