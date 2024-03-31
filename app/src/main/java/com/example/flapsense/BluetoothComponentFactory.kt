package com.example.flapsense

import android.bluetooth.BluetoothAdapter
import android.content.Context
import com.example.flapsense.comms.*
import com.example.flapsense.database.DatabaseHandler
import com.example.flapsense.database.FirebaseDatabaseWrapper
import com.example.flapsense.database.ValueEventListenerWrapper
import com.example.flapsense.location.LocationHandler
import com.example.flapsense.location.LocationServicesWrapper
import com.example.flapsense.location.OnSuccessListenerWrapper
import com.example.flapsense.messaging.FirebaseMessagingWrapper
import com.example.flapsense.messaging.MyFirebaseMessagingService
import com.example.flapsense.messaging.OnCompleteListenerWrapper
import com.example.flapsense.messaging.ToastWrapper
import com.example.flapsense.notifications.*
import com.example.flapsense.service.ServiceFactory
import com.example.flapsense.wearable.ClientHandler

class BluetoothComponentFactory constructor(
    val bluetoothComponent: BluetoothComponent,
    val context: Context,
    val bluetoothAdapter: BluetoothAdapter
) {
    val loggerWrapper = LoggerWrapper()
    private val onSuccessListenerWrapper = OnSuccessListenerWrapper()
    private val notificationChannelWrapper = NotificationChannelWrapper()
    private val notificationManagerWrapper = NotificationManagerWrapper()
    private val intentWrapper = IntentWrapper()
    private val pendingIntentWrapper = PendingIntentWrapper()
    private val builderWrapper = BuilderWrapper()
    private val resultWrapper = ScanResultWrapper()
    private val scanSettingsWrapper = ScanSettingsWrapper()
    private val activityCompatWrapper = ActivityCompactWrapper()
    private val bluetoothGattDescriptor = BluetoothGattDescriptorWrapper()
    private val looperWrapper = LooperWrapper()
    private val handlerWrapper = HandlerWrapper(looperWrapper)
    private val serviceWrapper = ServiceWrapper()
    private val characteristicWrapper = CharacteristicWrapper()
    private val firebaseDatabaseWrapper = FirebaseDatabaseWrapper()
    private val onCompleteListenerWrapper = OnCompleteListenerWrapper()
    private val toastWrapper = ToastWrapper(context)

    val clientHandler = ClientHandler(bluetoothComponent = bluetoothComponent)

    private val locationServicesWrapper = LocationServicesWrapper(
        onSuccessListenerWrapper = onSuccessListenerWrapper,
        bluetoothComponent = bluetoothComponent
    )

    private val valueEventListenerWrapper = ValueEventListenerWrapper(
        loggerWrapper = loggerWrapper,
        bluetoothComponent = bluetoothComponent
    )

    private val firebaseMessagingWrapper = FirebaseMessagingWrapper(
        onCompleteListenerWrapper = onCompleteListenerWrapper
    )

    val notificationHelper = NotificationHelper(
        buildWrapper = BuildWrapper(),
        notificationChannelWrapper = notificationChannelWrapper,
        notificationManagerWrapper = notificationManagerWrapper,
        intentWrapper = intentWrapper,
        pendingIntentWrapper = pendingIntentWrapper,
        builderWrapper = builderWrapper,
        notificationManagerCompatWrapper = NotificationManagerCompatWrapper(context)
    )

    val locationHandler = LocationHandler(
        context = context,
        locationServicesWrapper = locationServicesWrapper,
        loggerWrapper = loggerWrapper,
        bluetoothComponent = bluetoothComponent
    )

    val scanComponent = ScanComponent(
        context = context,
        bluetoothAdapter = bluetoothAdapter,
        bluetoothComponent = bluetoothComponent,
        resultWrapper = resultWrapper,
        scanSettingsWrapper = scanSettingsWrapper,
        activityCompatWrapper = activityCompatWrapper,
        loggerWrapper = loggerWrapper,
        toastWrapper = toastWrapper
    )

    val gattComponent = GattComponent(
        bluetoothComponent = bluetoothComponent,
        bluetoothGattDescriptor = bluetoothGattDescriptor,
        handlerWrapper = handlerWrapper,
        loggerWrapper = loggerWrapper,
        serviceWrapper = serviceWrapper,
        characteristicWrapper = characteristicWrapper,
        toastWrapper = toastWrapper
    )

    val databaseHandler = DatabaseHandler(
        bluetoothComponent = bluetoothComponent,
        firebaseDatabaseWrapper = firebaseDatabaseWrapper,
        valueEventListenerWrapper = valueEventListenerWrapper,
        loggerWrapper = loggerWrapper
    )

    val myFirebaseMessagingService = MyFirebaseMessagingService(
        loggerWrapper = loggerWrapper,
        firebaseMessagingWrapper = firebaseMessagingWrapper,
        toastWrapper = toastWrapper,
        context = context
    )

    val serviceFactory = ServiceFactory(context, locationHandler, bluetoothComponent, loggerWrapper)
}