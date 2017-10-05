package vn.hungpham.app.strategydesignpattern

/**
 * Created on 9/28/17.
 */
class LowerTextFormatterConcreteStrategy: TextFormatterStrategy {
    override fun format(str: String): String {
        return str.toUpperCase()
    }
}