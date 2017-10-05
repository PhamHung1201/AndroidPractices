package vn.hungpham.app.visitorpattern

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val tvMessage: TextView by lazy { findViewById<TextView>(R.id.tvMessage) as TextView}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items: MutableList<ItemElement> = mutableListOf()
        items.add(Book(20, "1234"))
        items.add(Book(100, "5678"))
        items.add(Fruit(10, 2,"Banana"))
        items.add(Fruit(5, 5,"Apple"))

        title = calculateTitle(items)+"\n"+"Total Cost= "+ calculatePrice(items)
        tvMessage.text = title
        Codiliti.solution(15)
        Codiliti.solution(1041)
        Codiliti.solution(100000)
        Codiliti.solution(1000000)
        Codiliti.solution(1000000000)
    }

    private fun calculatePrice(items: MutableList<ItemElement>): Int{
        val visitor: ShoppingCartVisitor = ShoppingCartVisitorImpl()
        var sum: Int = 0
        for (item: ItemElement in items){
            sum += item.accept(visitor)
        }
        return sum
    }

    private fun calculateTitle(items: MutableList<ItemElement>): String{
        val visitor: ShoppingCartVisitor = ShoppingCartVisitorImpl()
        var title: String = ""
        for (item: ItemElement in items){
            title +="\n" + item.title(visitor)
        }
        return title
    }
}
