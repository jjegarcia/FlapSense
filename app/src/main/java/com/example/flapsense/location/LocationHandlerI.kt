package com.example.flapsense.location

import com.example.flapsense.database.Coordinates
import com.google.android.gms.location.LocationCallback

interface LocationHandlerI {
    fun setLocation()
    fun fetchCoordinates(): Coordinates?
    fun startLocationUpdate()
    fun getLocationCallback(): LocationCallback
}