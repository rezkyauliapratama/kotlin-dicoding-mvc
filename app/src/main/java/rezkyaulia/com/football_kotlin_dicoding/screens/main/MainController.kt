package rezkyaulia.com.football_kotlin_dicoding.screens.main

import android.content.Context
import android.widget.Toast
import rezkyaulia.com.football_kotlin_dicoding.screens.common.controller.BaseController
import rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent.LastEventFragment

class MainController(val context: Context) : BaseController(), MainViewMvc.Listener{


    override fun onSpinnerLeagueClicked(s: String) {
        /*val fragment = supportFragmentManager.findFragmentByTag("lastevent")
        (fragment as LastEventFragment).setData(s)*/
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show()
    }

    private lateinit var mViewMvc: MainViewMvc

    fun bindView(viewMvc: MainViewMvc) {
        mViewMvc = viewMvc
    }

    fun onStart(){
        mViewMvc.registerListener(this)
    }

    fun onStop(){
        mViewMvc.unregisterListener(this)
    }

}