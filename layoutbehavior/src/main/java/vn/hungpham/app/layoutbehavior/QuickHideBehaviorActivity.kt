package vn.hungpham.app.layoutbehavior

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar

class QuickHideBehaviorActivity : AppCompatActivity() {

    val datas: MutableList<String> = mutableListOf("Alpha", "Beta", "Cupcake", "Donut",
            "Eclair", "FroYo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean", "KitKat",
            "Lollipop", "Marshmallow", "Oreo", "Alpha", "Beta", "Cupcake", "Donut",
            "Eclair", "FroYo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean", "KitKat",
            "Lollipop", "Marshmallow", "Oreo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_hide_behavior)
        val toolBar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)

        val list: RecyclerView = findViewById(R.id.list)
        val adapterSimple = SimpleAdapter(this, datas, object : SimpleAdapter.SimpleListener{
            override fun onClick(view: String) {

            }
        })
        list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterSimple
        }
    }
}
