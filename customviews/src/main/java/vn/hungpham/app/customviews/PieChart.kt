package vn.hungpham.app.customviews

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View

/**
 * Created on 10/9/17.
 */
class PieChart: View {

    var mShowText: Boolean
        set(value) {
            invalidate()
            requestLayout()
        }
    var mTextPos: Int = 0
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
        val attr: TypedArray = context.theme.obtainStyledAttributes(
                attributeSet,
                R.styleable.PieChart,
                0,0)
        try {
            mShowText = attr.getBoolean(R.styleable.PieChart_showText, false)
            mTextPos = attr.getInteger(R.styleable.PieChart_labelPosition, 0)
        }finally {
            attr.recycle()
        }
    }


}