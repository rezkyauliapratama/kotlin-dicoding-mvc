package rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import rezkyaulia.com.football_kotlin_dicoding.BaseApplication
import rezkyaulia.com.football_kotlin_dicoding.R
import rezkyaulia.com.football_kotlin_dicoding.databinding.FragmentPrevEventBinding
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ActivityModule
import rezkyaulia.com.football_kotlin_dicoding.di.controller.ControllerComponent
import rezkyaulia.com.football_kotlin_dicoding.di.controller.DaggerControllerComponent
import rezkyaulia.com.football_kotlin_dicoding.network.schema.event.Event
import rezkyaulia.com.football_kotlin_dicoding.repository.api.FetchEventUseCase
import javax.inject.Inject

class LastEventFragment : Fragment(), AnkoLogger , FetchEventUseCase.Listener{


    companion object {
        fun newInstance (): LastEventFragment {
            val lastEventFragment = LastEventFragment()
            return lastEventFragment
        }
    }

    private lateinit var adapter: EventRvAdapter
    val eventList : MutableList<Event> = mutableListOf()
    var leagueId : String = ""

    lateinit var controllerComponent: ControllerComponent

    @Inject
    lateinit var fetchEventUseCase: FetchEventUseCase

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Activity){
            controllerComponent = DaggerControllerComponent.builder()
                    .activityModule(ActivityModule(requireActivity()))
                    .applicationComponent(BaseApplication.component)
                    .build()

            controllerComponent.inject(this)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            error { "oncraete" }

        adapter = EventRvAdapter(eventList) { event: Event -> eventClicked(event) }
    }

    private fun eventClicked(event: Event) {

    }

    lateinit var viewDataBinding: FragmentPrevEventBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = inflate(inflater, R.layout.fragment_prev_event,container,false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
    }


    private fun initRv() {
        viewDataBinding.rvPrevEvent.layoutManager = LinearLayoutManager(context)

        viewDataBinding.rvPrevEvent.adapter = adapter

    }

    override fun onStart() {
        super.onStart()
        fetchEventUseCase.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        fetchEventUseCase.unregisterListener(this)
    }

    override fun onEventFetchSuccess(events: List<Event>) {
        error { "eventFetchSuccess : ${Gson().toJson(events)}" }
        eventList.clear()
        eventList.addAll(events)
        adapter.notifyDataSetChanged()
    }

    override fun onEventFetchFailure() {
        error { "oneventFetchFailure" }
    }

    public fun setData(s: String){
        fetchEventUseCase.fetchLastEventAndNotify(s)
    }

}