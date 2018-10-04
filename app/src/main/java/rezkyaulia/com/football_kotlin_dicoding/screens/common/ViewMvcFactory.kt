package rezkyaulia.com.football_kotlin_dicoding.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import rezkyaulia.com.football_kotlin_dicoding.screens.main.MainViewMvc
import rezkyaulia.com.football_kotlin_dicoding.screens.main.MainViewMvcImpl
import rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent.LastEventViewMvc
import rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent.LastEventViewMvcImpl


class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) {

    fun getMainViewMvc(parent: ViewGroup?): MainViewMvc {
        return MainViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getLastEventViewMvc(parent: ViewGroup?): LastEventViewMvc {
        return LastEventViewMvcImpl(mLayoutInflater, parent, this)
    }


}
