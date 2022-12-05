package com.example.tpnote

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
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

        var set_actuel = 0

        var scoreSetJ1 = 0
        var scoreSetJ2 = 0

        val bundle: Bundle? = intent.extras

        binding.joueur1.text = bundle?.get("joueur1").toString()
        binding.joueur2.text = bundle?.get("joueur2").toString()
        binding.nbSet.text = "$set_actuel / ${bundle?.get("nbSet").toString()}"

        binding.buttonJ1.setOnClickListener() {
            var score_actuel = binding.scoreJ1.text.toString().toInt()
            if (score_actuel<10) {
                binding.scoreJ1.text = (score_actuel+1).toString()
            }
            else {
                binding.scoreJ1.text = (0).toString()
                binding.scoreJ2.text = (0).toString()
                set_actuel += 1
                scoreSetJ1 += 1
                binding.nbSet.text = "$set_actuel / ${bundle?.get("nbSet").toString()}"
                if (set_actuel >= bundle?.get("nbSet").toString().toInt()) {
                    binding.buttonJ1.isEnabled = false
                    binding.buttonJ2.isEnabled = false
                    if (scoreSetJ1 > scoreSetJ2) {
                        binding.gagnant.text = 1.toString()
                    }
                    else {
                        binding.gagnant.text = 2.toString()
                    }
                }
            }
        }

        binding.buttonJ2.setOnClickListener() {
            var score_actuel = binding.scoreJ2.text.toString().toInt()
            if (score_actuel<10) {
                binding.scoreJ2.text = (score_actuel+1).toString()
            }
            else {
                binding.scoreJ1.text = (0).toString()
                binding.scoreJ2.text = (0).toString()
                set_actuel += 1
                scoreSetJ2 += 1
                binding.nbSet.text = "$set_actuel / ${bundle?.get("nbSet").toString()}"
                if (set_actuel >= bundle?.get("nbSet").toString().toInt()) {
                    binding.buttonJ1.isEnabled = false
                    binding.buttonJ2.isEnabled = false
                    if (scoreSetJ1 > scoreSetJ2) {
                        binding.gagnant.text = 1.toString()
                    }
                    else {
                        binding.gagnant.text = 2.toString()
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.buttonNotif.setOnClickListener { v ->
            val calendar = Calendar.getInstance()
            val textNotif = ("Le joueur "+ binding.gagnant.text +" a gagné !")
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
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}