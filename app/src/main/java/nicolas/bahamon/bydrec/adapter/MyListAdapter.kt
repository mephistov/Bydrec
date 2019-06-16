package nicolas.bahamon.bydrec.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import nicolas.bahamon.bydrec.R
import nicolas.bahamon.bydrec.models.Item

class MyListAdapter(private val context: Activity, private val listItem: List<Item>): ArrayAdapter<Item>(context, R.layout.row_list, listItem) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.row_list, null, true)

        /*val titleText = rowView.findViewById(R.id.title) as TextView
        val imageView = rowView.findViewById(R.id.icon) as ImageView
        val subtitleText = rowView.findViewById(R.id.description) as TextView

        titleText.text = title[position]
        imageView.setImageResource(imgid[position])
        subtitleText.text = description[position]*/

        return rowView
    }
}