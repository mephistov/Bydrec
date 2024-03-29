package nicolas.bahamon.bydrec

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.View
import android.R.id.tabs
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import nicolas.bahamon.bydrec.adapter.MyListAdapter
import nicolas.bahamon.bydrec.intefaces.ProyectLiseners
import nicolas.bahamon.bydrec.models.Item


class MainActivity : AppCompatActivity(), ProyectLiseners.proyectView {


    var tabLayout: TabLayout? = null
    internal var presenterLisener: ProyectLiseners.Presenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById<TabLayout>(R.id.tabs)
        presenterLisener = Presenter(this)



        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.fixtures)))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.ressults)))



        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.e("test","1")
                progressBarLoading.visibility = View.VISIBLE
                if(tab.position == 0){
                    downloadData(getString(R.string.fixtures));
                }else{
                    downloadData(getString(R.string.ressults));
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


        downloadData("");


    }

    private fun downloadData(path:String){
        presenterLisener?.getData(path,this)
    }

    override fun showResult(listItems: List<Item>) {

        val myListAdapter = MyListAdapter(this,listItems)
        listView.adapter = myListAdapter
        progressBarLoading.visibility = View.GONE

    }
}
