package rezkyaulia.com.football_kotlin_dicoding.screens.common.base

import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import rezkyaulia.com.football_kotlin_dicoding.BaseApplication
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ActivityModule
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ControllerComponent
import rezkyaulia.com.football_kotlin_dicoding.di.controller.DaggerControllerComponent


abstract class BaseActivity : AppCompatActivity(), AnkoLogger{

    abstract fun inject()

    val activityComponent: ControllerComponent by lazy {
         DaggerControllerComponent.builder()
                .applicationComponent(BaseApplication.component)
                .activityModule(ActivityModule(this))
                .build()
    }




}