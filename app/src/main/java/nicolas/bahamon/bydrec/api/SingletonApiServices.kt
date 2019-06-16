package nicolas.bahamon.bydrec.api

import android.app.Application
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import rx.Observable
import rx.Observer

class SingletonApiServices: Application() {

    var URL = "https://storage.googleapis.com/cdn-og-test-api/test-task/fixtures.json"
    var URL2 = "https://storage.googleapis.com/cdn-og-test-api/test-task/results.json"

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue?.add(request)
    }

    fun makeGteCall(contect: Context, pathUrl: String, mySubscriber: Observer<String>){//debe llegar un lisener

        val queue = Volley.newRequestQueue(contect)
        val finalUrl = URL+pathUrl

        // Request a string response from the provided URL.
        val stringReq = StringRequest(Request.Method.GET, finalUrl,
            Response.Listener<String> { response ->

                var strResp = response.toString()
                /* val jsonObj: JSONObject = JSONObject(strResp)
                 val jsonArray: JSONArray = jsonObj.getJSONArray("items")
                 var str_user: String = ""
                 for (i in 0 until jsonArray.length()) {
                     var jsonInner: JSONObject = jsonArray.getJSONObject(i)
                     str_user = str_user + "\n" + jsonInner.get("login")
                 }*/
                // enviar por lisener a la vista superior
                //RXJAVA
                var obs = Observable.create<String> { emitter ->
                    emitter.onNext(strResp)
                    emitter.onCompleted()
                }
                obs.subscribe(mySubscriber)

                Log.e("serverResponse",strResp)
            },
            Response.ErrorListener {
                // textView!!.text = "That didn't work!"
            })
        queue.add(stringReq)
    }

    companion object {
        private val TAG = SingletonApiServices::class.java.simpleName
        @get:Synchronized var instance: SingletonApiServices? = null
            private set
    }



    /*   fun getUsers(ctx:Context) {
           // Instantiate the RequestQueue.

       }*/





}