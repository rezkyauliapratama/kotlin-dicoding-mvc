package rezkyaulia.com.football_kotlin_dicoding.di.controller

import android.app.Activity
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

@Module
class ControllerModule {

    @Provides
    fun getFragmentManager(activity: FragmentActivity): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    fun getViewMvcFactory(@ActivityContext context: Context): ViewMvcFactory {
        return ViewMvcFactory(LayoutInflater.from(context))
    }

    @Provides
    fun getScreensNavigator(activity: FragmentActivity): ScreensNavigator {
        return ScreensNavigator(getFragmentFrameHelper(activity))
    }

    @Provides
    fun getFragmentFrameHelper(activity: FragmentActivity): FragmentFrameHelper {
        return FragmentFrameHelper(activity, getFragmentFrameWrapper(activity), getFragmentManager(activity))
    }

    @Provides
    fun getFragmentFrameWrapper(activity: FragmentActivity): FragmentFrameWrapper {
        return activity as FragmentFrameWrapper
    }


}