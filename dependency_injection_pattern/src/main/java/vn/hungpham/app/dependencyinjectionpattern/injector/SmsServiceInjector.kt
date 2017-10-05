package vn.hungpham.app.dependencyinjectionpattern.injector

import vn.hungpham.app.dependencyinjectionpattern.consumer.Consumer
import vn.hungpham.app.dependencyinjectionpattern.consumer.ConsumerImpl
import vn.hungpham.app.dependencyinjectionpattern.service_component.SmsServiceImpl

/**
 * Created SeesaaVN on 10/4/17.
 */
class SmsServiceInjector: MessageServicceInjector {
    override fun getConsumer(): Consumer {
        return ConsumerImpl(SmsServiceImpl())
    }
}