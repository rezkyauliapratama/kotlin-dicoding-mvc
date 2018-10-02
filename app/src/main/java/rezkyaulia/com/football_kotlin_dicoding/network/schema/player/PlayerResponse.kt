package rezkyaulia.com.football_kotlin_dicoding.network.schema.player

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName(value="player", alternate= arrayOf("players"))
    val player : List<Player>
)