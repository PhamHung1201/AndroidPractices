package vn.hungpham.app.layoutbehavior

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created on 10/8/17.
 */
class SimpleAdapter(var context: Context, var datas: MutableList<String>, var listener: SimpleListener): RecyclerView.Adapter<SimpleAdapter.SimpleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SimpleHolder {
        val holder: View = LayoutInflater.from(context)
                .inflate(R.layout.item_simple_list, parent!!, false)
        return SimpleHolder(holder)
    }

    override fun onBindViewHolder(holder: SimpleHolder?, position: Int) {
        holder?.text?.text = datas.get(position)
        holder?.itemView?.setOnClickListener { listener.onClick(datas.get(position)) }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class SimpleHolder(view: View): RecyclerView.ViewHolder(view){
        val text: TextView by lazy { view.findViewById<TextView>(R.id.text) }
    }

    interface SimpleListener{
        fun onClick(view: String)
    }
}