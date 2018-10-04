package rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import rezkyaulia.com.football_kotlin_dicoding.R
import rezkyaulia.com.football_kotlin_dicoding.databinding.FragmentPrevEventBinding
import rezkyaulia.com.football_kotlin_dicoding.network.schema.event.Event
import rezkyaulia.com.football_kotlin_dicoding.screens.common.ViewMvcFactory
import rezkyaulia.com.football_kotlin_dicoding.screens.common.views.BaseViewMvc

class LastEventViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, viewMvcFactory: ViewMvcFactory) : BaseViewMvc(), LastEventViewMvc{

    var binding : FragmentPrevEventBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_prev_event,parent,false)

    private var adapter: EventRvAdapter

    init{
        dataBinding = binding

        adapter = EventRvAdapter { event: Event -> eventClicked(event) }
        binding.rvPrevEvent.layoutManager = LinearLayoutManager(getContext())
        binding.rvPrevEvent.adapter = adapter
    }



    private fun eventClicked(event: Event) {
        Toast.makeText(getContext(),"event : ${Gson().toJson(event)}",Toast.LENGTH_SHORT).show()
    }

    override fun bindEvent(events: List<Event>) {
        adapter.bindQuestions(events)
    }

    override fun showProgressIndication() {

    }

    override fun hideProgressIndication() {

    }


}