package rezkyaulia.com.football_kotlin_dicoding.di.controller

import dagger.Component
import rezkyaulia.com.football_kotlin_dicoding.di.application.ApplicationComponent
import rezkyaulia.com.football_kotlin_dicoding.screens.main.LastEventFragment

/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */
@PerController
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ControllerComponent{
    fun inject(lastEventFragment: LastEventFragment)
}