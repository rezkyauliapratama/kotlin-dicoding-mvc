package rezkyaulia.com.football_kotlin_dicoding.screens

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rezkyaulia.com.football_kotlin_dicoding.R
import rezkyaulia.com.football_kotlin_dicoding.databinding.ListItemEventBinding
import rezkyaulia.com.football_kotlin_dicoding.network.schema.event.Event


/**
 * Created by Rezky Aulia Pratama on 20/8/18.
 */
class EventRvAdapter(private val clickListener : (Event) -> Unit) : RecyclerView.Adapter<EventRvAdapter.ViewHolder>() {

    val listItem : MutableList<Event> = mutableListOf()

    fun bindEvents(events: List<Event>){
        listItem.clear()

        if (!events.isEmpty())
            listItem.addAll(events)

        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_event, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount() = listItem.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listItem[position], clickListener)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var listItemEventBinding :ListItemEventBinding

        init {
            listItemEventBinding =  ListItemEventBinding.bind(itemView)

        }
        fun bindItem(event: Event, clickListener: (Event) -> Unit){
            listItemEventBinding.apply{
                tvAwayScore.text = event.intAwayScore.toString()
                tvHomeScore.text = event.intHomeScore.toString()
                tvHomeTeamName.text = event.strHomeTeam
                tvAwayTeamName.text = event.strAwayTeam
                tvDate.text = event.dateEvent
            }

        }
    }


}