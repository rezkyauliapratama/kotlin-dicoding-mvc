package rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent

import org.jetbrains.anko.error
import rezkyaulia.com.football_kotlin_dicoding.network.schema.event.Event
import rezkyaulia.com.football_kotlin_dicoding.repository.api.FetchEventUseCase
import rezkyaulia.com.football_kotlin_dicoding.screens.common.controller.BaseController
import rezkyaulia.com.football_kotlin_dicoding.screens.common.screennavigator.ScreensNavigator

class LastEventController (val screensNavigator: ScreensNavigator,val fetchEventUseCase: FetchEventUseCase):
        BaseController(), FetchEventUseCase.Listener{

    private lateinit var mViewMvc: LastEventViewMvc

    fun bindView(viewMvc: LastEventViewMvc) {
        mViewMvc = viewMvc
    }

    override fun onEventFetchSuccess(events: List<Event>) {
        mViewMvc.bindEvent(events)
    }

    override fun onEventFetchFailure() {
        error { "onEventFetchFailure" }
    }

    fun fetchData(s : String){
        fetchEventUseCase.fetchLastEventAndNotify(s)
    }

    fun onStart(){
        fetchEventUseCase.registerListener(this)
    }

    fun onStop(){
        fetchEventUseCase.unregisterListener(this)
    }

}