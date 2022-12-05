package com.example.tpnote

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.tpnote.databinding.ActivityThirdBinding
import java.util.*

class ThirdActivity : AppCompatActivity() {
    private val NOTIFICATION_CHANNEL_ID = "1"
    var notifID = 0
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        notifID = 0
        setContentView(view)

        binding.buttonJ1.setOnClickListener() {
            var score_actuel = binding.buttonJ1.text.toString().toInt()
            if (score_actuel<10) {
                binding.buttonJ1.text = (score_actuel+1).toString()
            }
            else {
                binding.buttonJ1.text = (0).toString()
                binding.buttonJ2.text = (0).toString()
            }
        }

        binding.buttonJ2.setOnClickListener() {
            var score_actuel = binding.buttonJ2.text.toString().toInt()
            if (score_actuel<10) {
                binding.buttonJ2.text = (score_actuel+1).toString()
            }
            else {
                binding.buttonJ1.text = (0).toString()
                binding.buttonJ2.text = (0).toString()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.buttonNotif.setOnClickListener { v ->
            val calendar = Calendar.getInstance()
            val textNotif = ("Le joueur x a gagné !")
            val builder = NotificationCompat.Builder(
                this@ThirdActivity,
                Integer.toString(notifID)
            )
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Fin du Match")
                .setContentText(textNotif)
            val notificationManager = NotificationManagerCompat.from(this)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val notificationChannel = NotificationChannel(
                    this.NOTIFICATION_CHANNEL_ID,
                    "NOTIFICATION_CHANNEL_NAME",
                    importance
                )
                notificationChannel.enableLights(true)
                notificationChannel.enableVibration(true)
                builder.setChannelId(this.NOTIFICATION_CHANNEL_ID)
                assert(notificationManager != null)
                notificationManager.createNotificationChannel(notificationChannel)
                notificationManager.notify(notifID, builder.build())
            }
        }
    }
}