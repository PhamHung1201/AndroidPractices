package vn.hungpham.app.bluetoothexample.manage_bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.*
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import vn.hungpham.app.bluetoothexample.R
import vn.hungpham.app.bluetoothexample.State
import vn.hungpham.app.bluetoothexample.StateViewContext

class ManageBluetoothActivity : AppCompatActivity() {

    val swBluetooth: SwitchCompat by lazy { findViewById<SwitchCompat>(R.id.swBluetooth) }
    val tvMessage: AppCompatTextView by lazy { findViewById<AppCompatTextView>(R.id.tvBluetoothFound) }
    val rcvBluetoothFound: RecyclerView by lazy { findViewById<RecyclerView>(R.id.rcvBluetoothFound) }
    val progress: ProgressBar by lazy { findViewById<ProgressBar>(R.id.progress) }
    val bluetoothAdapter: BluetoothAdapter by lazy { BluetoothAdapter.getDefaultAdapter() }

    private val viewContext: StateViewContext by lazy { StateViewContext() }
    private lateinit var receiver: BroadcastReceiver
    private lateinit var adapterFound: AdapterBluetoothFound
    private val bluetoothFounds: MutableList<BluetoothDevice?> = mutableListOf()

    private val bluetoothPaired: MutableList<BluetoothDevice?> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (bluetoothAdapter.isEnabled.not()){
            requestDiscoverable()
        }else{
            setupBluetooth()
        }

        setupRecyclerView()

        getDevicesPaired()
    }

    override fun onResume() {
        super.onResume()
        if (bluetoothAdapter.isDiscovering)
            bluetoothAdapter.cancelDiscovery()
        bluetoothAdapter.startDiscovery()
    }

    override fun onPause() {
        super.onPause()
        bluetoothFounds.clear()
        adapterFound.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101){
            if (resultCode == 300) setupBluetooth()
            else Toast.makeText(this, "Bluetooth non available", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupBluetooth(){

        swBluetooth.isChecked = true

        swBluetooth.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                bluetoothAdapter.enable()
                requestDiscoverable()
            }else{
                bluetoothAdapter.disable()
            }
        }

        receiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {

                val action = intent?.action

                if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action))
                    progress.visibility = View.VISIBLE
                else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                    adapterFound.notifyDataSetChanged()
                    progress.visibility = View.GONE
                }
                else if (BluetoothDevice.ACTION_FOUND.equals(action)){
                    val device = intent?.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
                    println("BLUETOOTH_DEVICE FOUND:"+device?.name+"~~"+device?.address)
                    bluetoothFounds.add(intent?.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE))
                }
                else if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)){}
            }
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND)
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED)
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)

        registerReceiver(receiver,intentFilter)
    }

    private fun setupRecyclerView(){

        adapterFound = AdapterBluetoothFound(bluetoothPaired)

        rcvBluetoothFound.apply {
            layoutManager = LinearLayoutManager(this@ManageBluetoothActivity)
            this.adapter = adapterFound
            addItemDecoration(DividerItemDecoration(this@ManageBluetoothActivity, DividerItemDecoration.HORIZONTAL))
        }
    }

    private fun getDevicesPaired(){
        val pairedDevices = bluetoothAdapter.bondedDevices
        if (pairedDevices.size > 0){
            for (device: BluetoothDevice in pairedDevices){
                bluetoothPaired.add(device)
                println("BLUETOOTH_EXAMPLE"+device.name+"~~~"+device.address)
            }
        }
        adapterFound.notifyDataSetChanged()
    }

    private fun requestDiscoverable(){
        val discoverableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 3600)
        startActivityForResult(discoverableIntent, 101)
    }
}

