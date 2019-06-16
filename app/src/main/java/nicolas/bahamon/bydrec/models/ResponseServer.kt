package nicolas.bahamon.bydrec.models

import org.json.JSONArray
import org.json.JSONObject

class ResponseServer() {

    var listItems:List<Item> = emptyList()


    constructor(response: String) : this() {
        val jsonObj: JSONArray = JSONArray(response)

        listItems = generateList(jsonObj)

    }

    fun generateList(jsonArray: JSONArray):List<Item> {
        var listM: ArrayList<Item> = ArrayList()
        for (i in 0 until jsonArray.length()) {
            listM.add(Item(jsonArray.getJSONObject(i)))

        }

        return listM
    }

}