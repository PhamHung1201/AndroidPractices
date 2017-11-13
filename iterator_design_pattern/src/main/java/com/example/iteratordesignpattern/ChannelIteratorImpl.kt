package com.example.iteratordesignpattern

/**
 * Created on 11/13/17.
 */
class ChannelIteratorImpl(val type: ChannelTypeEnum, val channels: MutableList<Channel>): ChannelIterator {

    private var position = 0

    override fun hasNext(): Boolean {
        while (position < channels.size){
            val c = channels.get(position)
            if (c.type == type || type == ChannelTypeEnum.ALL)
                return true
            else position++
        }
        return false
    }

    override fun next(): Channel {
        val c = channels.get(position)
        position++
        return c
    }
}