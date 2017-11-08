package vn.hungpham.app.layoutbehavior

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout

class CollapsingToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)
        val collapsingToolBar: CollapsingToolbarLayout =
                findViewById(R.id.collapsingToolBar)

        collapsingToolBar.title = "HungPham"
        collapsingToolBar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
    }
}
