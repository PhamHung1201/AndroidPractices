package vn.hungpham.app.dependencyinjectionpattern.consumer

import vn.hungpham.app.dependencyinjectionpattern.service_component.MessageService

/**
 * Created on 10/4/17.
 */
class ConsumerImpl(var service: MessageService): Consumer {

    override fun processMessage(msg: String, rec: String) {
        service.sendMessage(msg, rec)
    }
}