package nicolas.bahamon.bydrec.intefaces

import android.content.Context
import nicolas.bahamon.bydrec.models.Item

interface ProyectLiseners {

    interface proyectView{

        fun showResult(listItems: List<Item>)


    }
    interface Presenter{

        fun getData(path:String, context: Context)
        fun returnResult(listItems: List<Item>)
    }
    interface Model{
        fun getListRecomendations(page:String, context: Context)
    }

    //-----
    interface adaptesLiseners{
        fun changeToGrid()
        fun changeToList()
    }
}