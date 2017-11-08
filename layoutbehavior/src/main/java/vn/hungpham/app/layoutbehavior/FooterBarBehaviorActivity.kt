package vn.hungpham.app.layoutbehavior

import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import vn.hungpham.app.layoutbehavior.behaviors.FooterBarBehavior

/**
 * Created on 10/8/17.
 */
class FooterBarBehaviorActivity: AppCompatActivity() {
    val datas: MutableList<String> = mutableListOf("Alpha", "Beta", "Cupcake", "Donut",
            "Eclair", "FroYo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean", "KitKat",
            "Lollipop", "Marshmallow", "Oreo", "Alpha", "Beta", "Cupcake", "Donut",
            "Eclair", "FroYo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean", "KitKat",
            "Lollipop", "Marshmallow", "Oreo")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_footer_bar)

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

        val footerBar = findViewById<View>(R.id.footerBar)
        val layoutParam: CoordinatorLayout.LayoutParams = footerBar.layoutParams as CoordinatorLayout.LayoutParams
        layoutParam.behavior = FooterBarBehavior()
    }
}