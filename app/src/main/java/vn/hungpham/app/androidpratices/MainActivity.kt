package vn.hungpham.app.androidpratices

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import vn.hungpham.app.notifications.NotificationHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    class Behavior<V: View> : CoordinatorLayout.Behavior<V> {

        constructor()

        constructor(ctx: Context, attr: AttributeSet):super(ctx, attr)

        override fun onInterceptTouchEvent(parent: CoordinatorLayout?, child: V, ev: MotionEvent?): Boolean {
            return super.onInterceptTouchEvent(parent, child, ev)
        }

        override fun blocksInteractionBelow(parent: CoordinatorLayout?, child: V): Boolean {
            return super.blocksInteractionBelow(parent, child)
        }
    }

}
