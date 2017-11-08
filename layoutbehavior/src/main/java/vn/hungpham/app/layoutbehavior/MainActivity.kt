package vn.hungpham.app.layoutbehavior

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class MainActivity : AppCompatActivity() {
    val datas: MutableList<String> = mutableListOf("Simple Behavior", "Custom Behavior on Layout",
            "Footer Bar Behavior", "Quick Hide Behavior", "Collapsing Toolbar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list: RecyclerView = findViewById(R.id.recycleView)
        val adapterSimple = SimpleAdapter(this, datas, object : SimpleAdapter.SimpleListener{
            override fun onClick(view: String) {
                when(view){
                    datas.get(0) -> startActivity(Intent(this@MainActivity, SimpleBehaviorActivity::class.java))
                    datas.get(1) -> startActivity(Intent(this@MainActivity, CustomLayoutBehaviorActivity::class.java))
                    datas.get(2) -> startActivity(Intent(this@MainActivity, FooterBarBehaviorActivity::class.java))
                    datas.get(3) -> startActivity(Intent(this@MainActivity, QuickHideBehaviorActivity::class.java))
                    datas.get(4) -> startActivity(Intent(this@MainActivity, CollapsingToolbarActivity::class.java))
                }
            }
        })
        list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterSimple
        }
    }
}
