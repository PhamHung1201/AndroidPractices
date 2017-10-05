package vn.hungpham.app.strategydesignpattern

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TestStrategyPattern : AppCompatActivity() {
    val tvMessage: TextView by lazy { findViewById<TextView>(R.id.tvMessage) as TextView }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_strategy_pattern)
        var formatter: TextFormatterStrategy = CapTextFormatterConcreteStrategy()
        var editor: TextEditor = TextEditor(formatter)
        tvMessage.text = editor.publishText("Testing text in caps formatter")

        formatter = LowerTextFormatterConcreteStrategy()
        editor = TextEditor(formatter)

        tvMessage.append(editor.publishText("Testing text in lower formatter"))
    }
}
