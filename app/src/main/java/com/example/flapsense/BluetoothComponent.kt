package com.example.flapsense

import com.example.flapsense.comms.GattComponent
import com.example.flapsense.comms.ScanComponentI
import com.example.flapsense.database.DatabaseHandlerI
import com.example.flapsense.location.LocationHandlerI
import com.example.flapsense.messaging.MyFirebaseMessagingServiceI
import com.example.flapsense.notifications.NotificationHelperI
import com.example.flapsense.service.ServiceFactoryI
import com.example.flapsense.wearable.ClientHandlerI

class BluetoothComponent {
    var notificationHelper: NotificationHelperI? = null
    var clientHandler: ClientHandlerI? = null
    var scanComponent: ScanComponentI? = null
    var gattComponent: GattComponent? = null
    var databaseHandler: DatabaseHandlerI? = null
    var myFirebaseMessagingService: MyFirebaseMessagingServiceI? = null
    var viewModel: MainViewModel? = null
    var stateMachine: StateMachineI? = null
    var locationHandler: LocationHandlerI? = null
    var serviceFactory: ServiceFactoryI? = null
}