package vn.hungpham.app.bluetoothexample.scan

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_scan.view.*
import vn.hungpham.app.bluetoothexample.R

class AdapterScan(val datas: MutableList<String>): RecyclerView.Adapter<AdapterScan.ScanHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScanHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scan, parent, false)
        return ScanHolder(view)
    }

    override fun onBindViewHolder(holder: ScanHolder, position: Int) {
        holder is ScanHolder
        holder.tvName.text = datas.get(position)
    }

    override fun getItemCount(): Int = datas.size


    inner class ScanHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName: AppCompatTextView by lazy { itemView.findViewById<AppCompatTextView>(R.id.tvName) }
    }
}