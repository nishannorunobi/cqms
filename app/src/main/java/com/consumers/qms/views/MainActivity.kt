package com.consumers.qms.views

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.telephony.TelephonyManager
import com.consumers.qms.R
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()

        val tel = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        //imei = (TextView) findViewById(R.id.textView2);
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        if (ActivityCompat.checkSelfPermission(this@MainActivity,
                Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) return

        val s1 = tel.deviceId
    }
}
