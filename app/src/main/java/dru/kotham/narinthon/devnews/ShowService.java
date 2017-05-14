package dru.kotham.narinthon.devnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ShowService extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private String[] loginStrings, titleStrings;
    private int keyModeAnInt;
    private MyConstant myConstant;
    private ImageView imageView;
    private TextView showNameTextView, byNameTextView;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service);

        //Get Value From Intent
        getValueAnSetup();

        //Initial View
        initialView();

        //Show View
        showView();

        //Controller
        controller();

        //Create ListView
        createListView();

    }   // Main Method

    private void createListView() {



    }

    private void controller() {
        imageView.setOnClickListener(this);
    }

    private void showView() {
        showNameTextView.setText(titleStrings[keyModeAnInt]);
        byNameTextView.setText(loginStrings[4]);
    }

    private void initialView() {
        imageView = (ImageView) findViewById(R.id.imvBack);
        showNameTextView = (TextView) findViewById(R.id.txtShowTitle);
        byNameTextView = (TextView) findViewById(R.id.txtByName);
        listView = (ListView) findViewById(R.id.livShow);
    }

    private void getValueAnSetup() {
        loginStrings = getIntent().getStringArrayExtra("Login");
        keyModeAnInt = getIntent().getIntExtra("KeyMode", 0);
        Log.d("14MayV2", "KeyMode ==> " + keyModeAnInt);
        myConstant = new MyConstant();
        titleStrings = myConstant.getTitleStrings();
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}   // Main Class
