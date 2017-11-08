package vn.hungpham.app.bluetoothexample.scan

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import vn.hungpham.app.bluetoothexample.R

class ScanActivity : AppCompatActivity() {

    val btnScan: AppCompatButton by lazy { findViewById<AppCompatButton>(R.id.btnScan) }
    val rcvBluetooth: RecyclerView by lazy { findViewById<RecyclerView>(R.id.rcvBluetooth) }
    private lateinit var adapter: AdapterScan
    val bluetoothAdapter: BluetoothAdapter by lazy { BluetoothAdapter.getDefaultAdapter() }
    private val pairedDevices: MutableSet<BluetoothDevice> by lazy { bluetoothAdapter.bondedDevices }
    private lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        if (pairedDevices.size > 0){
            for (device: BluetoothDevice in pairedDevices)
                println("BLUETOOTH_DEVICE:"+device.name+"~~"+device.address)
        }

        receiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {

                val action = intent?.action


                if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action))
                else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action))
                else if (BluetoothDevice.ACTION_FOUND.equals(action)){
                    val device = intent?.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
                    println("BLUETOOTH_DEVICE FOUND:"+device?.name+"~~"+device?.address)
                }
                else if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)){}
//                    println("BLUETOOTH_DEVICE STATE CHANGED:"+device?.name+"~~"+device?.address)
            }
        }





        btnScan.setOnClickListener {
            if (bluetoothAdapter.isDiscovering)
                bluetoothAdapter.cancelDiscovery()
            bluetoothAdapter.startDiscovery()
        }

        if (bluetoothAdapter.isEnabled.not()){
            val discoverableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300)
            startActivityForResult(discoverableIntent, 101)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == 300)
            bluetoothAdapter.enable()
    }

    private fun setupRecyclerView(){
        rcvBluetooth.apply {
            layoutManager = LinearLayoutManager(this@ScanActivity)
            this.adapter = adapter
            addItemDecoration(DividerItemDecoration(this@ScanActivity, DividerItemDecoration.HORIZONTAL))
        }
    }
}
