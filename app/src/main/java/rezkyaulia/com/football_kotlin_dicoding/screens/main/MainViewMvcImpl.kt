package rezkyaulia.com.football_kotlin_dicoding.screens.main

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rezkyaulia.com.football_kotlin_dicoding.R
import rezkyaulia.com.football_kotlin_dicoding.databinding.ActivityMainBinding
import rezkyaulia.com.football_kotlin_dicoding.screens.common.base.views.BaseObservableViewMvc

abstract class MainViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup) : BaseObservableViewMvc<MainViewMvc.Listener>(), MainViewMvc{

    var binding : ActivityMainBinding = DataBindingUtil.inflate(inflater,R.layout.activity_main,parent,false)

    

}