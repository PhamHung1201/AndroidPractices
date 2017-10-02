package vn.hungpham.app.visitorpattern

/**
 * Created on 10/2/17.
 */
class ShoppingCartVisitorImpl: ShoppingCartVisitor {
    override fun visit(book: Book): Int {
        var cost = 0
        //apply 5$ discount if book price is greater than 50
        if (book.price > 50)
            cost = book.price - 5
        else
            cost = book.price
        return cost

    }

    override fun visit(fruit: Fruit): Int {
        val cost = fruit.pricePerKg.times(fruit.weight)
        return cost
    }

    override fun message(book: Book): String {
        return "Book ISBN::"+book.isbnNumber + " cost ="+visit(book)
    }

    override fun message(fruit: Fruit): String {
        return fruit.name+" cost = "+visit(fruit)
    }
}