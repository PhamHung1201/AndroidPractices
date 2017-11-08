package vn.hungpham.app.layoutbehavior.behaviors

import android.content.Context
import android.graphics.Rect
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewCompat
import android.support.v4.view.WindowInsetsCompat
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created on 10/5/17.
 */
class ShrinkBehavior: CoordinatorLayout.Behavior<FloatingActionButton>{

    constructor()

    constructor(context: Context, attributeSet: AttributeSet):super(context, attributeSet)

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: FloatingActionButton?, dependency: View?): Boolean {
        if (dependency != null)
            return dependency is Snackbar.SnackbarLayout
        else return false
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: FloatingActionButton?, dependency: View?): Boolean {
        val translationY = getFabTranslationYForSnackbar(parent!!, child!!)
        val percentComplete = translationY.unaryMinus().div(dependency!!.height)
        val scaleFactor = 1 - percentComplete

        child.scaleX = scaleFactor
        child.scaleY = scaleFactor

        return false
    }

    override fun onLayoutChild(parent: CoordinatorLayout?, child: FloatingActionButton?, layoutDirection: Int): Boolean {
        return super.onLayoutChild(parent, child, layoutDirection)
    }
    private fun getFabTranslationYForSnackbar(parent: CoordinatorLayout, fab: FloatingActionButton): Float{
        var minOffset = 0f
        val dependencies: MutableList<View> = parent.getDependencies(fab)

        for (view: View in dependencies){
            if (view is Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)){
                minOffset = Math.min(minOffset, ViewCompat.getTranslationY(view) - view.height)
            }
        }

        return minOffset
    }


}