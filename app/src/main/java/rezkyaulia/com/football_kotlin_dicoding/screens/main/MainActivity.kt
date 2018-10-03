package rezkyaulia.com.football_kotlin_dicoding.screens.main

import android.os.Bundle
import rezkyaulia.com.football_kotlin_dicoding.screens.common.controller.BaseActivity

class MainActivity : BaseActivity<MainController,MainViewMvc>(){

    override fun initView() {
        mViewMvc = viewMvcFactory.getMainViewMvc(null)
        mController.bindView(mViewMvc)
    }

    override fun inject() {
        activityComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mController.onStart()
    }

    override fun onStop() {
        super.onStop()
        mController.onStop()
    }



/*

        setContentView(mViewMvc.dataBinding?.root)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, LastEventFragment.newInstance(), "lastevent")
                .commit()
*/


//    }
}
