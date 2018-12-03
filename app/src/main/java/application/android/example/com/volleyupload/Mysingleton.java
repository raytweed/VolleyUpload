package application.android.example.com.volleyupload;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

class Mysingleton {
    private static  Mysingleton ourInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private Mysingleton(Context ctx) {
        context=ctx;
        requestQueue=getRequestQueue();
    }
    public  static synchronized Mysingleton getOurInstance(Context context){
        if(ourInstance==null) {
            ourInstance = new Mysingleton(context);

        }
        return ourInstance;
    }
    public RequestQueue getRequestQueue() {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public  void addreq(Request request){
        requestQueue.add(request);
    }
}
