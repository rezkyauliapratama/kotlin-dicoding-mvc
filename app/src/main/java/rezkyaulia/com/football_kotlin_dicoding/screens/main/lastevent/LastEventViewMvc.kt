package rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent

import rezkyaulia.com.football_kotlin_dicoding.network.schema.event.Event
import rezkyaulia.com.football_kotlin_dicoding.network.schema.event.EventResponse
import rezkyaulia.com.football_kotlin_dicoding.screens.common.views.BaseViewMvc
import rezkyaulia.com.football_kotlin_dicoding.screens.common.views.ViewMvc

interface LastEventViewMvc: ViewMvc{


    fun bindEvent(events: List<Event>)

    fun showProgressIndication()

    fun hideProgressIndication()


}