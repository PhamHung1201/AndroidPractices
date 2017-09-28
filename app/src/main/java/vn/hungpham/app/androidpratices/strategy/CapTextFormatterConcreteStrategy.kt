package vn.hungpham.app.androidpratices.strategy

/**
 * Created on 9/28/17.
 */
class CapTextFormatterConcreteStrategy: TextFormatterStrategy {
    override fun format(str: String) {
        println("[CapTextFormatter]: "+ str.toUpperCase())
    }
}