package vn.hungpham.app.visitorpattern

/**
 * Created on 10/2/17.
 */
class Fruit(var pricePerKg: Int,var weight: Int,var name: String): ItemElement {
    override fun accept(visitor: ShoppingCartVisitor): Int {
        return visitor.visit(this)
    }

    override fun title(visitor: ShoppingCartVisitor): String {
        return visitor.message(this)
    }
}