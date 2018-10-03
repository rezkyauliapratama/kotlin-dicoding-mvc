package rezkyaulia.com.football_kotlin_dicoding.di.controller

import dagger.Component
import rezkyaulia.com.football_kotlin_dicoding.di.application.ApplicationComponent
import rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent.LastEventFragment
import rezkyaulia.com.football_kotlin_dicoding.screens.main.MainActivity

/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */
@PerController
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class,MvcWrapperModule::class,ControllerModule::class])
interface ControllerComponent{
    fun inject(lastEventFragment: LastEventFragment)
    fun inject(lastEventFragment: MainActivity)
}