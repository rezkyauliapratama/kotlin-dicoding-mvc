package rezkyaulia.com.football_kotlin_dicoding.repository.api

import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rezkyaulia.com.football_kotlin_dicoding.network.ApiObservable
import rezkyaulia.com.football_kotlin_dicoding.network.api.NetworkApi
import rezkyaulia.com.football_kotlin_dicoding.network.schema.event.Event
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 1/10/18.
 */
class FetchEventUseCase @Inject constructor(val networkApi: NetworkApi) : ApiObservable<FetchEventUseCase.Listener>() {

    interface Listener {
        fun onEventFetchSuccess(events: List<Event>)
        fun onEventFetchFailure()
    }


    fun fetchLastEventAndNotify(s : String){
            networkApi
                .getEventPastLeague(s).subscribeOn(Schedulers.io())
                .flatMap{t ->
                    Single.just(t.events)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (response.isNotEmpty()){
                        notifySuccess(response)
                    }else{
                        notifyFailure()
                    }

                }, { throwable ->
                    error { "error : "+ Gson().toJson(throwable) }
                    notifyFailure()
                })

    }

    private fun notifyFailure() {
        for (listener in listeners) {
            listener.onEventFetchFailure()
        }
    }

    private fun notifySuccess(events: List<Event>) {

        for (listener in listeners) {
            listener.onEventFetchSuccess(events)
        }
    }


}