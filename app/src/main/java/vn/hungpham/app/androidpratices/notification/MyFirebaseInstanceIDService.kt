package vn.hungpham.app.androidpratices.notification

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created SeesaaVN on 9/29/17.
 */
class MyFirebaseInstanceIDService: FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
//        super.onTokenRefresh()
        val refreshedToken = FirebaseInstanceId.getInstance().token
//        sendRe
    }
}