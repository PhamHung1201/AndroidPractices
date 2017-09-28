package vn.hungpham.app.strategydesignpattern

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class TestStrategyPattern : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_strategy_pattern)
        var formatter: TextFormatterStrategy = CapTextFormatterConcreteStrategy()
        var editor: TextEditor = TextEditor(formatter)
        editor.publishText("Testing text in caps formatter")

        formatter = LowerTextFormatterConcreteStrategy()
        editor = TextEditor(formatter)
        editor.publishText("Testing text in lower formatter")
    }
}
