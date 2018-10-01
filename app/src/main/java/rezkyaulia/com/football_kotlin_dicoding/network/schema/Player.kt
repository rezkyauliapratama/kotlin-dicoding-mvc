package rezkyaulia.com.football_kotlin_dicoding.network.schema

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
        val idPlayer : String,
        val strPlayer : String,
        val strPosition : String,
        val strHeight : String,
        val strWeight : String,
        val strCutout : String,
        val strFanart1 : String,
        val strDescriptionEN : String
): Parcelable