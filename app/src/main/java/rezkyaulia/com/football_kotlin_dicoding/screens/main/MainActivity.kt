package rezkyaulia.com.football_kotlin_dicoding.screens.main

import android.os.Bundle
import android.widget.FrameLayout
import rezkyaulia.com.football_kotlin_dicoding.databinding.ActivityMainBinding
import rezkyaulia.com.football_kotlin_dicoding.screens.common.FragmentFrameHelper.FragmentFrameWrapper
import rezkyaulia.com.football_kotlin_dicoding.screens.common.controller.BaseActivity

class MainActivity : BaseActivity<MainController,MainViewMvc, ActivityMainBinding>(), FragmentFrameWrapper {


    override fun initDataBinding() {
        mDataBinding = mViewMvc.dataBinding as ActivityMainBinding
    }

    override val fragmentFrame: FrameLayout
        get() = mDataBinding.container

    override fun initView() {
        mViewMvc = viewMvcFactory.getMainViewMvc(null)
        mController.bindView(mViewMvc)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mController.screensNavigator.toLastEvent()
    }
    override fun inject() {
        controllerComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mController.onStart()
    }

    override fun onStop() {
        super.onStop()
        mController.onStop()
    }

}
