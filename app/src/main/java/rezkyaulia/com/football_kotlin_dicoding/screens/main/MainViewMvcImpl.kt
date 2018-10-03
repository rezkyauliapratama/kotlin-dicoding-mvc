package rezkyaulia.com.football_kotlin_dicoding.screens.main

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import org.jetbrains.anko.error
import rezkyaulia.com.football_kotlin_dicoding.R
import rezkyaulia.com.football_kotlin_dicoding.databinding.ActivityMainBinding
import rezkyaulia.com.football_kotlin_dicoding.screens.common.FragmentFrameHelper.FragmentFrameWrapper
import rezkyaulia.com.football_kotlin_dicoding.screens.common.ViewMvcFactory

import rezkyaulia.com.football_kotlin_dicoding.screens.common.views.BaseObservableViewMvc

class MainViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, viewMvcFactory: ViewMvcFactory) :
        BaseObservableViewMvc<MainViewMvc.Listener>(), MainViewMvc, FragmentFrameWrapper{

    override val fragmentFrame: FrameLayout
        get() = binding.container

    var binding : ActivityMainBinding = DataBindingUtil.inflate(inflater,R.layout.activity_main,parent,false)

    
    init{
        dataBinding = binding
        val spinnerItems = getContext()?.resources?.getStringArray(R.array.league)
        val arrLeagueId = getContext()?.resources?.getStringArray(R.array.league_id)
        val spinnerAdapter = ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, spinnerItems)
        binding.spinner.adapter = spinnerAdapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                error { "onitemselected" }
                for (listener in listeners) {
                    arrLeagueId?.get(position)?.let { listener.onSpinnerLeagueClicked(it) }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }


}