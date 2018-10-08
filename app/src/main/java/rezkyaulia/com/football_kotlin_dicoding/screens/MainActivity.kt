package rezkyaulia.com.football_kotlin_dicoding.screens

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.gson.Gson
import org.jetbrains.anko.ctx
import rezkyaulia.com.football_kotlin_dicoding.R
import rezkyaulia.com.football_kotlin_dicoding.R.array.league
import rezkyaulia.com.football_kotlin_dicoding.R.array.league_id
import rezkyaulia.com.football_kotlin_dicoding.databinding.ActivityMainBinding

class  MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init view from res
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val spinnerItems = resources.getStringArray(league)
        val arrLeagueId = resources.getStringArray(league_id)
        val spinnerAdapter = ArrayAdapter(ctx, R.layout.support_simple_spinner_dropdown_item, spinnerItems)
        binding.spinner.adapter = spinnerAdapter

        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, LastEventFragment.newInstance(), "lastevent")
                .commit()

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val fragment = supportFragmentManager.findFragmentByTag("lastevent")
                (fragment as LastEventFragment).setData(arrLeagueId[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


    }
}
