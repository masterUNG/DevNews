package dru.kotham.narinthon.devnews;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Administrator on 13/5/2560.
 */

public class GetAllData extends AsyncTask<String, Void, String>{

    private Context context;

    public GetAllData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        return null;
    }
}//main class
