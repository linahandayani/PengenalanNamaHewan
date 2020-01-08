package com.lina.pengenalannamahewan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var  a: Button
    lateinit var b: Button
    lateinit var c: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a = findViewById(R.id.bt_play)
        b = findViewById(R.id.bt_about)
        c = findViewById(R.id.bt_close)

        a.setOnClickListener(this)
        b.setOnClickListener(this)
        c.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.bt_play -> {
                val pindah = Intent(this@MainActivity, Play::class.java)
                startActivity(pindah)
            }
            R.id.bt_about -> {
            }
            R.id.bt_close -> finish()
        }
    }
}
