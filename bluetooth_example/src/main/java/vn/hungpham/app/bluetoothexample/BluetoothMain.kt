package vn.hungpham.app.bluetoothexample

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_bluetooth_main.*
import kotlinx.android.synthetic.main.app_bar_bluetooth_main.*
import vn.hungpham.app.bluetoothexample.manage_bluetooth.ManageBluetoothActivity
import vn.hungpham.app.bluetoothexample.scan.ScanActivity

class BluetoothMain : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val viewContext: StateViewContext by lazy { StateViewContext() }
    val bluetoothAdapter: BluetoothAdapter by lazy { BluetoothAdapter.getDefaultAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.bluetooth_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_basic -> {
                if (bluetoothAdapter.isEnabled){
                    if (bluetoothAdapter.disable()) viewContext.changeView(BluetoothOffState(item))
                }else{
                    if (bluetoothAdapter.enable()) viewContext.changeView(BluetoothOnState(item))
                }
            }
            R.id.nav_scan -> {
                startActivity(Intent(this, ScanActivity::class.java))
            }
            R.id.nav_connect -> {

            }
            R.id.nav_transfer -> {

            }
            R.id.nav_source -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    inner class BluetoothOnState(val item: MenuItem?): State {
        override fun changeView() {
            item?.setIcon(R.drawable.ic_bluetooth_connected)
            item?.setTitle("Bluetooth is ON")
        }
    }

    inner class BluetoothOffState(val item: MenuItem?): State {
        override fun changeView() {
            item?.setIcon(R.drawable.ic_bluetooth)
            item?.setTitle("Bluetooth is OFF")
        }
    }
}
