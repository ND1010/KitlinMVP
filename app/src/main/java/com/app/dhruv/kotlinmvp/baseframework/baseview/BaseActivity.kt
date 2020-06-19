package com.pa.baseframework.baseview

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.bhaskar.easypaisa.utils.Utils
import com.app.bhaskar.easypaisa.utils.Utils.Companion.isNetworkConnected
import com.google.android.material.snackbar.Snackbar


open abstract class BaseActivity :AppCompatActivity(), BaseView {
    var receiver: BroadcastReceiver? = null
    private var intentFilter: IntentFilter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                onNetworkStateChange(isNetworkConnected(this@BaseActivity))
                Log.e("status", isNetworkConnected(this@BaseActivity).toString())
            }
        }
        intentFilter = IntentFilter()
        intentFilter!!.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
    }

    override fun onPause() {
        this.unregisterReceiver(receiver)
        super.onPause()
    }

    override fun onResume() {
        this.registerReceiver(receiver, intentFilter)
        super.onResume()
    }

    override fun showError(message: String) {
        Utils.showSnackBar(
                getViewActivity().findViewById(android.R.id.content),
                message,
                Snackbar.LENGTH_LONG,
                true,
                getViewActivity()
        )
    }

    override fun showProgress() {
        Utils.showProgressDialog(getViewActivity(), "")
    }

    override fun showSnackBar(message: String) {
        Utils.showSnackBar(
                getViewActivity().findViewById(android.R.id.content),
                message,
                Snackbar.LENGTH_LONG,
                false,
                getViewActivity()
        )
    }

    override fun showToast(message: String) {
        Utils.showToast(message,getViewActivity())
    }

    override fun hideProgress() {
        Utils.hideProgressDialog()
    }

    /*fun getNavigationController() : NavController {
        return  NavHostFragment.findNavController(
            supportFragmentManager.findFragmentById(
                R.id.nav_host_fragment
            )!!
        )
    }*/
}
