package com.example.user

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.widget.Toast

class Permission{

    //private val tag = "Permission message"
    private val cameraAgreeCode = 1

    fun askCameraPermission(context: Context): Boolean{
        val currentCameraPermission = ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA)
        return currentCameraPermission != PackageManager.PERMISSION_GRANTED
    }

    fun requestCameraPermission(activity: MainActivity){
        ActivityCompat.requestPermissions(activity, arrayOf(android.Manifest.permission.CAMERA), cameraAgreeCode)
    }

    fun onRequestPermissionsResult(grantResults: IntArray, context: Context){
        for( i in grantResults ){
            if( i != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(context,"你必須開啟Camera的權限!!!!!",Toast.LENGTH_SHORT).show()
                (context as Activity).recreate()
                return
            }
        }
        Toast.makeText(context,"已經開啟Camera的權限!!!!!",Toast.LENGTH_SHORT).show()
        (context as Activity).recreate()
        return
    }

}