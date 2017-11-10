package com.example.factorydesignpattern

/**
* Created on 11/10/17.
*/
object ComputerFactory {

    fun getComputer(type: String, ram: String, hdd: String, cpu: String): Computer?{
        if (type.equals("PC", true))
            return PC(ram, hdd, cpu)
        else if (type.equals("SERVER", true))
            return Server(ram, hdd, cpu)
        return null
    }
}