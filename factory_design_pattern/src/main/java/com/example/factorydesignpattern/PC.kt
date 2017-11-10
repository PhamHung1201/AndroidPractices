package com.example.factorydesignpattern

class PC(val ram: String, val hdd: String, val cpu: String): Computer() {
    override fun getRAM(): String = ram

    override fun getHDD(): String  = hdd

    override fun getCPU(): String = cpu

}