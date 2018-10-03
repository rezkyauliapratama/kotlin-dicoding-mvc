package rezkyaulia.com.football_kotlin_dicoding.screens.common.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import org.jetbrains.anko.AnkoLogger
import rezkyaulia.com.football_kotlin_dicoding.BaseApplication
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ActivityModule
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ControllerComponent
import rezkyaulia.com.football_kotlin_dicoding.di.controller.DaggerControllerComponent
import rezkyaulia.com.football_kotlin_dicoding.screens.common.ViewMvcFactory
import rezkyaulia.com.football_kotlin_dicoding.screens.common.views.ViewMvc
import javax.inject.Inject


abstract class BaseActivity<T : BaseController, U : ViewMvc>  : AppCompatActivity(), AnkoLogger{

    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    @Inject
    lateinit var mController: T

    lateinit var mViewMvc: U

    abstract fun inject()
    abstract fun initView()

    val activityComponent: ControllerComponent by lazy {
         DaggerControllerComponent.builder()
                .applicationComponent(BaseApplication.component)
                .activityModule(ActivityModule(this))
                .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        initView()
        setContentView(mViewMvc.dataBinding?.root)
    }



}