package com.example.factorydesignpattern

abstract class Computer {
    abstract fun getRAM(): String
    abstract fun getHDD(): String
    abstract fun getCPU(): String

    override fun toString(): String {
        return "RAM = "+getRAM()+", HDD = "+ getHDD()+", CPU = "+ getCPU()
    }
}