package vn.hungpham.app.visitorpattern

/**
 * Created on 10/2/17.
 */
//Create different type of items to be used in shopping cart
interface ItemElement {
    fun accept(visitor: ShoppingCartVisitor):Int
    fun title(visitor: ShoppingCartVisitor):String
}