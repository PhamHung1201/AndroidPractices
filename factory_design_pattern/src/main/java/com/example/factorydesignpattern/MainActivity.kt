package com.example.factorydesignpattern

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pc = ComputerFactory.getComputer("PC", "16GB", "256GB", "Core i7")
        val server = ComputerFactory.getComputer("SERVER", "32GB", "1 TB", "Core i7")

        println("Factory PC Config::"+ pc.toString())
        println("Factory Server Config::"+ server.toString())
    }
}
