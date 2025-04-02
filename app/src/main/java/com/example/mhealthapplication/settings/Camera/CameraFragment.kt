package com.example.mhealthapplication.settings.Camera

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mhealthapplication.R
import com.google.android.gms.common.wrappers.Wrappers.packageManager

class CameraFragment : Fragment() {
    private lateinit var button : Button
    private var PERMISSION_REQUEST_CODE = 200;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_camera, container, false)

        button = view.findViewById(R.id.btnOpenCamera)
        button.setOnClickListener {
            if (checkPermission()) {
                println("checkPermission == true")
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
                Toast.makeText(requireContext(), "True", Toast.LENGTH_SHORT).show()
            } else {
                println("checkPermission == false")

                Toast.makeText(requireContext(), "False", Toast.LENGTH_SHORT).show()
                requestPermission();
            }
        }
        return view
    }

    private fun checkPermission(): Boolean {
        println("checkPermission()")
        return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        println("requestPermission()")
        ActivityCompat.requestPermissions(requireContext() as Activity, arrayOf(Manifest.permission.CAMERA), PERMISSION_REQUEST_CODE)
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    println("grantResults.isNotEmpty() = " + grantResults.isNotEmpty())
                    println("grantResults[0] = " + grantResults[0])
                    Toast.makeText(requireContext(), "Permission Granted", Toast.LENGTH_SHORT).show()
                } else {
                    println("grantResults.isNotEmpty() = " + grantResults.isNotEmpty())
                    println("grantResults[0] = " + grantResults[0])
                    Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show()
//                        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                            requestPermission()
//                        }
                }
            }
        }
    }
}