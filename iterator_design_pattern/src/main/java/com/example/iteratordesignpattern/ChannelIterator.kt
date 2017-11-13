package com.example.iteratordesignpattern

/**
 * Created on 11/13/17.
 */
interface ChannelIterator {
    fun hasNext(): Boolean
    fun next(): Channel
}