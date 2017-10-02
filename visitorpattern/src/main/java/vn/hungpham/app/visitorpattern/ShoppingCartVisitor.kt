package vn.hungpham.app.visitorpattern

/**
 * Created on 10/2/17.
 */
interface ShoppingCartVisitor {
    fun visit(book: Book): Int
    fun visit(fruit: Fruit): Int
    fun message(book: Book): String
    fun message(fruit: Fruit): String
}