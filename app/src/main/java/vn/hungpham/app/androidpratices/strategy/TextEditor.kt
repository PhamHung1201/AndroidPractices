package vn.hungpham.app.androidpratices.strategy

/**
 * Created on 9/28/17.
 */
class TextEditor(var textFormatter: TextFormatterStrategy) {
    fun publishText(str: String){
        textFormatter.format(str)
    }
}