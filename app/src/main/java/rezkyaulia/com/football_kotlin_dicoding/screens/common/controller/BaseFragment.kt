package rezkyaulia.com.football_kotlin_dicoding.screens.common.controller

import android.app.Activity
import android.content.Context
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoLogger
import rezkyaulia.com.football_kotlin_dicoding.BaseApplication
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ActivityModule
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ControllerComponent
import rezkyaulia.com.football_kotlin_dicoding.di.controller.DaggerControllerComponent
import rezkyaulia.com.football_kotlin_dicoding.screens.common.ViewMvcFactory
import rezkyaulia.com.football_kotlin_dicoding.screens.common.views.ViewMvc
import javax.inject.Inject

abstract class BaseFragment<CONTROLLER : BaseController, VIEW_MVC : ViewMvc, DATA_BINDING : ViewDataBinding>  : Fragment(), AnkoLogger{


    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    @Inject
    lateinit var mController: CONTROLLER

    lateinit var mViewMvc: VIEW_MVC

    lateinit var mDataBinding: DATA_BINDING

    abstract fun inject()
    abstract fun initView(container: ViewGroup?)
    abstract fun initDataBinding()

    val controllerComponent: ControllerComponent by lazy {
        DaggerControllerComponent.builder()
                .applicationComponent(BaseApplication.component)
                .activityModule(ActivityModule(requireActivity()))
                .build()
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Activity){
            inject()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        initView(container)
        initDataBinding()
        return mViewMvc.dataBinding?.root
    }
}