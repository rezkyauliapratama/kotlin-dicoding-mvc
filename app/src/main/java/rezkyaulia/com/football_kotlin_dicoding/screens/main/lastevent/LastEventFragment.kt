package rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent

import android.view.ViewGroup
import rezkyaulia.com.football_kotlin_dicoding.databinding.FragmentPrevEventBinding
import rezkyaulia.com.football_kotlin_dicoding.screens.common.controller.BaseFragment

class LastEventFragment : BaseFragment<LastEventController,LastEventViewMvc,FragmentPrevEventBinding>(){


    companion object {
        fun newInstance (): LastEventFragment {
            val lastEventFragment = LastEventFragment()
            return lastEventFragment
        }
    }


    override fun inject() {
        controllerComponent.inject(this)
    }

    override fun initView(container: ViewGroup?) {
        mViewMvc = viewMvcFactory.getLastEventViewMvc(container)
        mController.bindView(mViewMvc)
    }

    override fun initDataBinding() {
        mDataBinding = mViewMvc.dataBinding as FragmentPrevEventBinding
    }


    override fun onStart() {
        super.onStart()
        mController.onStart()
    }

    override fun onStop() {
        super.onStop()
        mController.onStop()
    }


    fun setData(s: String){
        mController.fetchData(s)
    }

}