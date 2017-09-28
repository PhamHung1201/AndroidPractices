package vn.hungpham.app.androidpratices.strategy

/**
 * Created on 9/28/17.
 */
class TestStrategyPattern {
    fun main(){
        var formatter: TextFormatterStrategy = CapTextFormatterConcreteStrategy()
        var editor: TextEditor = TextEditor(formatter)
        editor.publishText("Testing text in caps formatter")

        formatter = LowerTextFormatterConcreteStrategy()
        editor = TextEditor(formatter)
        editor.publishText("Testing text in lower formatter")
    }
}