package vn.hungpham.app.dependencyinjectionpattern.injector

import vn.hungpham.app.dependencyinjectionpattern.consumer.Consumer

/**
 * Created on 10/4/17.
 */
interface MessageServicceInjector{
    fun getConsumer(): Consumer
}