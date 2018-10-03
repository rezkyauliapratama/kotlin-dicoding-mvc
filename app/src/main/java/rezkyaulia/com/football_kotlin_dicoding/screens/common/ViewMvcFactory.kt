package rezkyaulia.com.football_kotlin_dicoding.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import rezkyaulia.com.football_kotlin_dicoding.screens.main.MainViewMvc
import rezkyaulia.com.football_kotlin_dicoding.screens.main.MainViewMvcImpl


class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) {

    fun getMainViewMvc(parent: ViewGroup?): MainViewMvc {
        return MainViewMvcImpl(mLayoutInflater, parent, this)
    }


}
