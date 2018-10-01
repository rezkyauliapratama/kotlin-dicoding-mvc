package rezkyaulia.com.football_kotlin_dicoding.network.common.schema

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName(value="player", alternate= arrayOf("players"))
    val player : List<Player>
)