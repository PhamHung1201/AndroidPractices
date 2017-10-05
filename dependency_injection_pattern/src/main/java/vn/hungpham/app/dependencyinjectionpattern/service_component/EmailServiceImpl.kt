package vn.hungpham.app.dependencyinjectionpattern.service_component

/**
 * Created on 10/4/17.
 */
class EmailServiceImpl: MessageService {
    override fun sendMessage(msg: String, rec: String) {
        println("Email sent to "+ rec+" with Message="+msg)
    }
}