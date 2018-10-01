package rezkyaulia.com.football_kotlin_dicoding.network.schema

import com.google.gson.annotations.SerializedName
import rezkyaulia.com.football_kotlin_dicoding.network.schema.Player

data class PlayerResponse(
    @SerializedName(value="player", alternate= arrayOf("players"))
    val player : List<Player>
)