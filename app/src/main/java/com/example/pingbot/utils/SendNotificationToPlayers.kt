
package com.example.pingbot.utils
import android.content.Context
import android.util.Log
import com.example.pingbot.data.datasource.Game
fun sendNotificationToPlayers(context: Context, oldGame: Game?, newGame: Game) {
    Log.d("NotificationTest", "Chamando sendNotificationToPlayers")
    val channelId = "game_updates_channel"
    if (oldGame?.player1 != newGame.player1) {
        sendNotification(
            context = context,
            channelId = channelId,
            player = newGame.player1,
            message = "Olá ${newGame.player1.name}, sua partida já vai começar!"
        )
    }
    if (oldGame?.player2 != newGame.player2) {
        sendNotification(
            context = context,
            channelId = channelId,
            player = newGame.player2,
            message = "Olá ${newGame.player2.name}, sua partida já vai começar!"
        )
    }
}