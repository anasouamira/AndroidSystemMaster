package com.anasouamira.androidsystemmaster.modules.permissions

import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationServices


class LocationManager(private val context: Context) {
    private val fusedClient =
        LocationServices.getFusedLocationProviderClient(context)

    fun getLastLocation(onResult: (Location?) -> Unit) {
        fusedClient.lastLocation.addOnSuccessListener { location ->
            onResult(location)
        }
    }
}

