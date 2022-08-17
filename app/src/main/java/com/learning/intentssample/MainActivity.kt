package com.learning.intentssample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val buttonCallLog = findViewById<Button>(R.id.btnCallLog)
        val btnContacts = findViewById<Button>(R.id.btnContacts)
        val btnBrowser = findViewById<Button>(R.id.btnBrowser)
        val btnCamera = findViewById<Button>(R.id.btnCamera)
        val btnGallery = findViewById<Button>(R.id.btnGallery)
        val btnAlarm = findViewById<Button>(R.id.btnAlarm)
        val btnGoogleMap = findViewById<Button>(R.id.btnGoogleMap)
        val btnNewActivity = findViewById<Button>(R.id.btnNewActivity)

        buttonCallLog.setOnClickListener { launchCallLog() }
        btnContacts.setOnClickListener { launchContact() }
        btnBrowser.setOnClickListener { launchBrowser() }
        btnCamera.setOnClickListener { openCamera() }
        btnGallery.setOnClickListener { openGallery() }
        btnAlarm.setOnClickListener { launchAlarmApp() }
        btnGoogleMap.setOnClickListener { openGoogleMap() }
        btnNewActivity.setOnClickListener { openNewActivity() }
    }

    private fun openNewActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }

    private fun openGoogleMap() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://maps.google.com/maps?")
        startActivity(intent)
    }

    private fun launchAlarmApp() {
        val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
        startActivity(intent)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("content://media/external/images/media/")
        startActivity(intent)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }

    private fun launchBrowser() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com")
        startActivity(intent)
    }

    private fun launchContact() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = ContactsContract.Contacts.CONTENT_TYPE
        startActivity(intent)
    }

    private fun launchCallLog() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.type = CallLog.Calls.CONTENT_TYPE
        startActivity(intent)
    }
}