package vn.hungpham.app.layoutbehavior.behaviors

import android.animation.ObjectAnimator
import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import vn.hungpham.app.layoutbehavior.R

/**
 * Created on 10/8/17.
 * * Simple scrolling behavior that monitors nested events in the scrolling
 * container to implement a quick hide/show for the attached view.
 */
class QuickHideBehavior: CoordinatorLayout.Behavior<View> {

    private val DIRECTION_UP = 1
    private val DIRECTION_DOWN = -1

    /* Tracking direction of user motion */
    private var mScrollingDirection: Int = 0
    /* Tracking last threshold crossed */
    private var mScrollTrigger: Int?= null
    /* Accumulated scroll distance */
    private var mScrollDistance: Int = 0
    /* Distance threshold to trigger animation */
    private var mScrollThreshold: Int = 0
    private var mAnimator: ObjectAnimator? = null

    //Required to instantiate as a default behavior
    constructor()
    //Required to attach behavior via XML
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
        val a = context.theme.obtainStyledAttributes(mutableListOf<Int>(R.attr.actionBarSize).toIntArray())
        mScrollThreshold = a.getDimensionPixelSize(0,0)/2
        a.recycle()
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View,
                                     directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return axes.and(ViewCompat.SCROLL_AXIS_VERTICAL) != 0
    }
    //Called before the scrolling child consumes the event
    // We can steal all/part of the event by filling in the consumed array
    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout,
                                   child: View,
                                   target: View,
                                   dx: Int, dy: Int,
                                   consumed: IntArray, type: Int) {
        //Determine direction changes here
        if (dy>0 && mScrollingDirection != DIRECTION_UP){
            mScrollingDirection = DIRECTION_UP
            mScrollDistance = 0
        }else if (dy<0 && mScrollingDirection != DIRECTION_DOWN){
            mScrollingDirection = DIRECTION_DOWN
            mScrollDistance = 0
        }
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout,
                                child: View, target: View,
                                dxConsumed: Int, dyConsumed: Int,
                                dxUnconsumed: Int, dyUnconsumed: Int,
                                type: Int) {
        //Consumed distance is the actual distance traveled by the scrolling view
        mScrollDistance += dyConsumed
        if (mScrollDistance > mScrollThreshold && mScrollTrigger != DIRECTION_UP){
            //Hide the target view
            mScrollTrigger = DIRECTION_UP
            restartAnimator(child, getTargetHideValue(coordinatorLayout, child))
        }else if (mScrollDistance < -mScrollThreshold && mScrollTrigger != DIRECTION_DOWN){
            //Return the target view
            mScrollTrigger = DIRECTION_DOWN
            restartAnimator(child , 0f)
        }
    }

    override fun onNestedFling(coordinatorLayout: CoordinatorLayout,
                               child: View,
                               target: View,
                               velocityX: Float, velocityY: Float,
                               consumed: Boolean): Boolean {
        //We only care when the target view is already handling the fling
        if (consumed){
            if (velocityY > 0 && mScrollTrigger != DIRECTION_UP){
                mScrollTrigger = DIRECTION_UP
                restartAnimator(child, getTargetHideValue(coordinatorLayout, child))
            }else if (velocityY < 0 && mScrollTrigger != DIRECTION_DOWN){
                mScrollTrigger = DIRECTION_DOWN
                restartAnimator(child , 0f)
            }
        }
        return false
    }

    //Helper to trigger hide/show animation
    private fun restartAnimator(target: View, value: Float){
        if (mAnimator != null){
            mAnimator?.cancel()
            mAnimator = null
        }

        mAnimator = ObjectAnimator.ofFloat(target, View.TRANSLATION_Y, value).setDuration(250)
        mAnimator?.start()
    }

    private fun getTargetHideValue(parent: ViewGroup, target: View): Float{
        if (target is AppBarLayout){
            return -target.height.toFloat()
        }else if (target is FloatingActionButton){
            return (parent.height - target.top).toFloat()
        }
        return 0f
    }
}