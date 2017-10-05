package vn.hungpham.app.dependencyinjectionpattern.injector

import vn.hungpham.app.dependencyinjectionpattern.consumer.Consumer
import vn.hungpham.app.dependencyinjectionpattern.consumer.ConsumerImpl
import vn.hungpham.app.dependencyinjectionpattern.service_component.EmailServiceImpl

/**
 * Created on 10/4/17.
 */
class EmailServiceInjector: MessageServicceInjector {
    override fun getConsumer(): Consumer {
        return ConsumerImpl(EmailServiceImpl())
    }
}