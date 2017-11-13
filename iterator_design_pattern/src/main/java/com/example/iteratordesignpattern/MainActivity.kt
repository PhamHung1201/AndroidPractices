package com.example.iteratordesignpattern

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val channels = populateChannels()
        var baseIterator = channels.iterator(ChannelTypeEnum.ALL)
        while (baseIterator.hasNext()){
            println(baseIterator.next().toString())
        }

        println("***********")
        baseIterator = channels.iterator(ChannelTypeEnum.ENGLISH)
        while (baseIterator.hasNext()){
            println(baseIterator.next().toString())
        }

    }

    fun populateChannels(): ChannelCollection{
        val channelCollection = ChannelCollectionImpl()
        channelCollection.addChannel(Channel(98.5, ChannelTypeEnum.ENGLISH))
        channelCollection.addChannel(Channel(99.5, ChannelTypeEnum.HINDI))
        channelCollection.addChannel(Channel(100.5, ChannelTypeEnum.FRENCH))
        channelCollection.addChannel(Channel(101.5, ChannelTypeEnum.ENGLISH))
        channelCollection.addChannel(Channel(102.5, ChannelTypeEnum.HINDI))
        channelCollection.addChannel(Channel(103.5, ChannelTypeEnum.FRENCH))
        channelCollection.addChannel(Channel(104.5, ChannelTypeEnum.ENGLISH))
        channelCollection.addChannel(Channel(105.5, ChannelTypeEnum.HINDI))
        channelCollection.addChannel(Channel(106.5, ChannelTypeEnum.FRENCH))

        return channelCollection
    }
}
