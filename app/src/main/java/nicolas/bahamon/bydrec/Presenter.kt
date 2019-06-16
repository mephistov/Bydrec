package nicolas.bahamon.bydrec

import android.content.Context
import nicolas.bahamon.bydrec.intefaces.ProyectLiseners
import nicolas.bahamon.bydrec.models.Item

class Presenter() : ProyectLiseners.Presenter {



    internal var viewLisener: ProyectLiseners.proyectView? = null
    internal var modelLisener: ProyectLiseners.Model? = null

    constructor(_viewLisener: ProyectLiseners.proyectView) : this() {
        viewLisener = _viewLisener
        modelLisener = Model(this)
    }

    // to ask
    override fun getData(path: String, context: Context) {
        modelLisener?.getListRecomendations(path, context)
    }

    // to return
    override fun returnResult(listItems: List<Item>) {
        viewLisener?.showResult(listItems)
    }

}