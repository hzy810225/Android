package com.example.user

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if( Permission().askCameraPermission(this@MainActivity) ){
            Log.i(tag,"要求Camera權限")
            Permission().requestCameraPermission(this)
        }else{
            Log.i(tag,"OK Do something!!!!!!!!!!!!")
            //  從這裡開始設定按鈕......
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        Permission().onRequestPermissionsResult(grantResults, this@MainActivity)
    }
}
