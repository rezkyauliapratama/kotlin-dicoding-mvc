package rezkyaulia.com.football_kotlin_dicoding.di.application

import dagger.Component
import rezkyaulia.com.football_kotlin_dicoding.BaseApplication
import rezkyaulia.com.football_kotlin_dicoding.repository.api.FetchEventUseCase
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 6/8/18.
 */
@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent{

    fun inject(baseApplication: BaseApplication)

    fun getFetchEventUseCase() : FetchEventUseCase
}