package nicolas.bahamon.bydrec.adapter

import android.app.Activity
import android.graphics.Color
import android.support.design.widget.TabLayout
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import nicolas.bahamon.bydrec.R
import nicolas.bahamon.bydrec.models.Item
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class MyListAdapter(private val context: Activity, private val listItem: List<Item>): ArrayAdapter<Item>(context, R.layout.row_list, listItem) {

    var lastMonth = 0

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.row_list, null, true)

        val sdf = SimpleDateFormat("yyyy-MM-dd", context.getResources().getConfiguration().locale)
        val date = sdf.parse(listItem.get(position).date)


        val monthZone = rowView.findViewById(R.id.monthZone) as RelativeLayout
        val titleMonth = rowView.findViewById(R.id.textViewMonth) as TextView

        val title = rowView.findViewById(R.id.textViewTittle) as TextView

        val titleVenue = rowView.findViewById(R.id.textViewVenue) as TextView
        val titleDate = rowView.findViewById(R.id.textViewData) as TextView
        val titleHome = rowView.findViewById(R.id.textViewHome) as TextView
        val titleAway = rowView.findViewById(R.id.textViewAway) as TextView

        val dayTitel = rowView.findViewById(R.id.textViewDay) as TextView
        val dayWeek = rowView.findViewById(R.id.textViewweek) as TextView
        val textViewPosponed = rowView.findViewById(R.id.textViewPosponed) as TextView


        if(lastMonth != date.month) {
            monthZone.visibility = View.VISIBLE
            lastMonth = date.month
        }else{
            monthZone.visibility = View.GONE
        }
        titleMonth.setText(date.toGMTString())

        title.setText(listItem.get(position).competition_stage?.competition?.name)
        titleVenue.setText(listItem.get(position).venue?.name)
        titleDate.setText(date.toLocaleString())

        titleHome.setText(listItem.get(position).homeTeam?.name)
        titleAway.setText(listItem.get(position).awwayTeam?.name)

        if(listItem.get(position).state != null && listItem.get(position).state.equals("postponed"))
            textViewPosponed.visibility = View.VISIBLE
        else
            textViewPosponed.visibility = View.GONE


        if(listItem.get(position).score == null) {

            val calendar = Calendar.getInstance()
            calendar.time = date

            val dayName = getDayName(calendar.get(Calendar.DAY_OF_WEEK))

            val dayString = calendar.get(Calendar.DAY_OF_MONTH).toString();
            dayTitel.setText(dayString)

            dayWeek.setText(dayName)
        }else{
            dayTitel.setText(listItem.get(position).score.home.toString())
            dayWeek.setText(listItem.get(position).score.away.toString())

            if(listItem.get(position).score.home > listItem.get(position).score.away) {
                dayTitel.setTextColor(Color.RED)
                dayWeek.setTextColor(Color.BLUE)
            }
            else if(listItem.get(position).score.home == listItem.get(position).score.away){
                dayTitel.setTextColor(Color.BLUE)
                dayWeek.setTextColor(Color.BLUE)
            }
            else{
                dayTitel.setTextColor(Color.BLUE)
                dayWeek.setTextColor(Color.RED)
            }

        }

        return rowView
    }

    fun getDayName(day:Int): String{

        when (day) {
            Calendar.SUNDAY -> {
                return "SUN"
            }
            Calendar.MONDAY -> {
                return "MON"
            }
            Calendar.TUESDAY -> {
                return "TUE"
            }
            Calendar.WEDNESDAY -> {
                return "WEN"
            }
            Calendar.THURSDAY -> {
                return "THU"
            }
            Calendar.FRIDAY -> {
                return "FRI"
            }
            Calendar.SATURDAY -> {
                return "SAT"
            }
        }// Current day is Sunday
        // Current day is Monday
        return ""
    }
}