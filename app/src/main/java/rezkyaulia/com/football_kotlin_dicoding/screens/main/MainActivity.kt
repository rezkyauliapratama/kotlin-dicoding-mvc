package rezkyaulia.com.football_kotlin_dicoding.screens.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import org.jetbrains.anko.error
import rezkyaulia.com.football_kotlin_dicoding.R
import rezkyaulia.com.football_kotlin_dicoding.screens.common.ViewMvcFactory
import rezkyaulia.com.football_kotlin_dicoding.screens.common.controller.BaseActivity
import rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent.LastEventFragment

class MainActivity : BaseActivity(), MainViewMvc.Listener{

    override fun onSpinnerLeagueClicked(s: String) {
        val fragment = supportFragmentManager.findFragmentByTag("lastevent")
        (fragment as LastEventFragment).setData(s)
    }

    override fun inject() {
        activityComponent.inject(this)
    }

    private lateinit var mViewMvc: MainViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        error { "oncreate" }
        val viewMvcFactory = ViewMvcFactory(LayoutInflater.from(this))
        mViewMvc = viewMvcFactory.getMainViewMvc(null)

        setContentView(mViewMvc.dataBinding?.root)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, LastEventFragment.newInstance(), "lastevent")
                .commit()


    }

    override fun onStart() {
        super.onStart()
        error { "onstart" }
        mViewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        error { "onstop" }

        mViewMvc.unregisterListener(this)

    }
}
