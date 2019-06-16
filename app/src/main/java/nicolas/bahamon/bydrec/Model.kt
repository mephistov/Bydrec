package nicolas.bahamon.bydrec
import android.content.Context
import nicolas.bahamon.bydrec.api.SingletonApiServices
import rx.Observer
import rx.Subscriber
import nicolas.bahamon.bydrec.intefaces.ProyectLiseners
import nicolas.bahamon.bydrec.models.Item
import nicolas.bahamon.bydrec.models.ResponseServer

class Model() : ProyectLiseners.Model {

    internal var presenterLisener: ProyectLiseners.Presenter? = null
    var resp:String = ""
    var listItem:List< Item> = emptyList()

    constructor(_presenterLisener: ProyectLiseners.Presenter) : this() {
        presenterLisener = _presenterLisener


    }




    //  ------ Liseneres ------
    override fun getListRecomendations(page: String, context: Context) {

        val mySubscriber = object: Observer<String> {

            override fun onCompleted() {
                println("carajooo siii")

                presenterLisener?.returnResult(listItem)
            }

            override fun onNext(s: String) {
                println(s)
                var resp = ResponseServer(s)
                listItem = resp.listItems
            }


            override fun onError(e: Throwable) {

            }



        }

        SingletonApiServices.instance?.makeGteCall(context,page,mySubscriber)


    }
}