package com.example.iteratordesignpattern

/**
 * Created on 11/13/17.
 */
class ChannelCollectionImpl: ChannelCollection {

    private val channels: MutableList<Channel> by lazy { mutableListOf<Channel>() }

    override fun addChannel(c: Channel){
        channels.add(c)
    }

    override fun removeChannel(c: Channel) {
        channels.remove(c)
    }

    override fun iterator(type: ChannelTypeEnum): ChannelIterator = ChannelIteratorImpl(type, channels)
}