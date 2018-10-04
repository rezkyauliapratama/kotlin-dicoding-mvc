package rezkyaulia.com.football_kotlin_dicoding.screens.main.lastevent

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.sdk25.coroutines.onClick
import rezkyaulia.com.football_kotlin_dicoding.R
import rezkyaulia.com.football_kotlin_dicoding.databinding.ListItemEventBinding
import rezkyaulia.com.football_kotlin_dicoding.network.schema.event.Event


/**
 * Created by Rezky Aulia Pratama on 20/8/18.
 */
class EventRvAdapter( private val clickListener : (Event) -> Unit) : RecyclerView.Adapter<EventRvAdapter.ViewHolder>() {


    private val mItems: MutableList<Event> = mutableListOf()

    fun bindQuestions(listItem: List<Event>) {
        mItems.clear()
        if (!listItem.isEmpty()){
            mItems.addAll(listItem)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_event, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mItems.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(mItems[position], clickListener)
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

                listItemEventBinding.root.onClick {
                    clickListener(event)
                }
            }

        }
    }


}