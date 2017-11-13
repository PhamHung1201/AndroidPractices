package com.example.iteratordesignpattern

/**
 * Created on 11/13/17.
 */
interface ChannelCollection {
    fun addChannel(c: Channel)
    fun removeChannel(c: Channel)
    fun iterator(type: ChannelTypeEnum):ChannelIterator
}