package vn.hungpham.app.strategydesignpattern

import vn.hungpham.app.strategydesignpattern.TextFormatterStrategy

/**
 * Created on 9/28/17.
 */
class TextEditor(var textFormatter: TextFormatterStrategy) {
    fun publishText(str: String): String{
        return textFormatter.format(str)
    }
}