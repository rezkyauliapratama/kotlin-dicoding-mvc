package rezkyaulia.com.football_kotlin_dicoding.di.controller

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import rezkyaulia.com.football_kotlin_dicoding.screens.common.FragmentFrameHelper.FragmentFrameHelper
import rezkyaulia.com.football_kotlin_dicoding.screens.common.FragmentFrameHelper.FragmentFrameWrapper
import rezkyaulia.com.football_kotlin_dicoding.screens.common.ViewMvcFactory
import rezkyaulia.com.football_kotlin_dicoding.screens.common.screennavigator.ScreensNavigator
import rezkyaulia.com.football_kotlin_dicoding.screens.main.MainController

@Module
class ControllerModule {

    @Provides
    fun getMainController(@ActivityContext context: Context) : MainController{
        return MainController(context)
    }
}