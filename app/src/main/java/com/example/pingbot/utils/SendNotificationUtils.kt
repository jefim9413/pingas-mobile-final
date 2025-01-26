
package com.example.pingbot.utils
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.pingbot.R
import com.example.pingbot.data.datasource.User
fun sendNotification(context: Context, channelId: String, player: User?, message: String) {
    if (player == null) return
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
        ActivityCompat.checkSelfPermission(
            context,
            android.Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        Log.d("NotificationTest", "Permissão de notificação não concedida.")
        return
    }
    val notification = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("Atualização no Jogo")
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)
        .build()
    with(NotificationManagerCompat.from(context)) {
        notify(player.id.hashCode(), notification)
    }
}