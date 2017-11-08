package vn.hungpham.app.bluetoothexample.manage_bluetooth

import android.bluetooth.BluetoothDevice
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.hungpham.app.bluetoothexample.R

class AdapterBluetoothFound(val datas: MutableList<BluetoothDevice?>): RecyclerView.Adapter<AdapterBluetoothFound.BluetoothFoundHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BluetoothFoundHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scan, parent, false)
        return BluetoothFoundHolder(view)
    }

    override fun onBindViewHolder(holder: BluetoothFoundHolder, position: Int) {
        holder is BluetoothFoundHolder
        holder.tvName.text = datas.get(position)?.name
        holder.tvAddress.text = datas.get(position)?.address
    }

    override fun getItemCount(): Int = datas.size


    inner class BluetoothFoundHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName: AppCompatTextView by lazy { itemView.findViewById<AppCompatTextView>(R.id.tvName) }
        val tvAddress: AppCompatTextView by lazy { itemView.findViewById<AppCompatTextView>(R.id.tvAddress) }
    }
}