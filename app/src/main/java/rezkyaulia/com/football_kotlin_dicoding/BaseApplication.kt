package rezkyaulia.com.football_kotlin_dicoding

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import rezkyaulia.com.football_kotlin_dicoding.di.application.ApplicationComponent
import rezkyaulia.com.football_kotlin_dicoding.di.application.ApplicationModule
import rezkyaulia.com.football_kotlin_dicoding.di.application.DaggerApplicationComponent
import rezkyaulia.com.football_kotlin_dicoding.di.application.NetworkModule

class BaseApplication : Application(){

    companion object {
        lateinit var component : ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = initDagger(this)
        component.inject(this)
        /*if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }*/
        LeakCanary.install(this)


    }

    private fun initDagger(app: BaseApplication): ApplicationComponent =
            DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(app))
                    .networkModule(NetworkModule())
                    .build()



}