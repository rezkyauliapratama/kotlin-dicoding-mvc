package rezkyaulia.com.football_kotlin_dicoding.di.controller

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ActivityContext

/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */
@Module
class ActivityModule(val activity: Activity){

    @Provides
    @ActivityContext
    fun providesContext(): Context = activity

    @Provides
    fun provideActivity(): Activity = activity
}