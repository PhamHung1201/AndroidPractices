package vn.hungpham.app.layoutbehavior.behaviors

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View

/**
 * Created on 10/8/17.
 * Simple layout behavior that will track the state of the AppBarLayout
 * and match its offset for a corresponding footer.
 */
class FooterBarBehavior: CoordinatorLayout.Behavior<View> {

    constructor()

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        val offset = - dependency!!.top.toFloat()
        child?.translationY= offset
        return true
    }
}