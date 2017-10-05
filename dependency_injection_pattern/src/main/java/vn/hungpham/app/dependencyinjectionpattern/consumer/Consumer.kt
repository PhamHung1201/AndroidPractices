package vn.hungpham.app.dependencyinjectionpattern.consumer

/**
 * Created on 10/4/17.
 */
interface Consumer {
    fun processMessage(msg: String, rec: String)
}