package com.example.iteratordesignpattern

/**
 * Created on 11/13/17.
 */
data class Channel(val frequency: Double, val type: ChannelTypeEnum){
    override fun toString(): String {
        return "Frequency = $frequency; channel = $type"
    }
}