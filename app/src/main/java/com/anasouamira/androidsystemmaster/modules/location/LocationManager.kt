package com.anasouamira.androidsystemmaster.modules.location

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import android.Manifest


class LocationManager(private val context: Context) {

    private val fusedClient =
        LocationServices.getFusedLocationProviderClient(context)

    fun getLastLocation(onResult: (Location?) -> Unit) {

        if (
            ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onResult(null)
            return
        }

        fusedClient.lastLocation.addOnSuccessListener { location ->
            onResult(location)
        }
    }
}

