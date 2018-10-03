package rezkyaulia.com.football_kotlin_dicoding.screens.main

import rezkyaulia.com.football_kotlin_dicoding.screens.common.views.BaseObservableViewMvc
import rezkyaulia.com.football_kotlin_dicoding.screens.common.views.ObservableViewMvc

interface  MainViewMvc : ObservableViewMvc<MainViewMvc.Listener> {

    interface Listener {
        fun onSpinnerLeagueClicked(s: String)
    }


}