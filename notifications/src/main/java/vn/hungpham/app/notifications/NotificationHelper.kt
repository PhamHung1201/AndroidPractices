package vn.hungpham.app.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.provider.Settings
import android.support.annotation.RequiresApi

/**
 * Created on 9/29/17.
 */
class NotificationHelper(ctx: Context) : ContextWrapper(ctx){

    private val mNotificationManager: NotificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    companion object {
        val ID_PRIMARY_CHANNEL = "default"
        val ID_SECONDARY_CHANNEL = "second"

        val ID_LOGIC_GROUP = "logic"
        val ID_BUSINESS_GROUP = "business"
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            mNotificationManager.createNotificationChannelGroup(NotificationChannelGroup(ID_LOGIC_GROUP, getString(R.string.noti_group_logic)))

            mNotificationManager.createNotificationChannelGroup(NotificationChannelGroup(ID_BUSINESS_GROUP, getString(R.string.noti_group_business)))

            val channel_1 = NotificationChannel(
                    ID_PRIMARY_CHANNEL,
                    getString(R.string.noti_channel_default),
                    NotificationManager.IMPORTANCE_DEFAULT)
            channel_1.apply {
                lightColor = Color.GREEN
                lockscreenVisibility = Notification.VISIBILITY_PRIVATE
                group = ID_LOGIC_GROUP
            }
            mNotificationManager.createNotificationChannel(channel_1)

            val channel_2 = NotificationChannel(
                    ID_SECONDARY_CHANNEL,
                    getString(R.string.noti_channel_second),
                    NotificationManager.IMPORTANCE_HIGH)

            channel_2.apply {
                lightColor = Color.BLUE
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
                group = ID_BUSINESS_GROUP
            }
            mNotificationManager.createNotificationChannel(channel_2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun notify(id: Int, title: String, body: String, channel: String){
        mNotificationManager.notify(id, createNotification(title, body, channel).build())
    }
    //Tao Notification.Builder cho channel 1
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotification(title: String, body: String, idChannel: String): Notification.Builder{
        return Notification.Builder(applicationContext, idChannel)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setAutoCancel(true)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun deleteChannel(idChannel: String){
        mNotificationManager.deleteNotificationChannel(idChannel)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun deleteGroup(idGroup: String){
        mNotificationManager.deleteNotificationChannelGroup(idGroup)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateChannel(idChannel: String){
        val intent = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS)
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, idChannel)
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
        startActivity(intent)
    }
}