package dru.kotham.narinthon.devnews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Administrator on 13/5/2560.
 */

public class MyAlert {

    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }
    public void myDialog(String strTitle, String strMassage) {
        AlertDialog.Builder builde = new AlertDialog.Builder(context);
        builde.setCancelable(false);//คือหยุดการทำงานพักหนึ่ง
        builde.setIcon(R.mipmap.ic_alert);
        builde.setTitle(strTitle);
        builde.setMessage(strMassage);
        builde.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builde.show();
    }

} //main class
