package vn.hungpham.app.androidpratices.notification

import android.os.Build
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import vn.hungpham.app.notifications.NotificationHelper

/**
 * Created on 9/29/17.
 */
class MyFirebaseMessagingService: FirebaseMessagingService() {
    private val TAG = "MyFirebaseMsgService"
    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)
        if (p0?.data?.size!! > 0){
            Log.d(TAG, "Message data payload: " + p0?.data)
        }

        Log.d(TAG, "Message Notification Body: " + p0?.notification)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationHelper(this).notify(
                    1,
                    p0.notification.title!!,
                    p0.notification.body!!,
                    NotificationHelper.ID_PRIMARY_CHANNEL)
        }
    }
}