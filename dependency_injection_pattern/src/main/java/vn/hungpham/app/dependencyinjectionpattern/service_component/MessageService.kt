package vn.hungpham.app.dependencyinjectionpattern.service_component

/**
 * Created on 10/4/17.
 */
interface MessageService {
    fun sendMessage(msg: String, rec: String)
}