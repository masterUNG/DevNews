package dru.kotham.narinthon.devnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceUser extends AppCompatActivity implements View.OnClickListener {

    private Button videoButton, imageButton, textButton;
    private String[] loginStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_user);

        //Initial View
        initialView();

        //Receive Value From Intent
        receiveValue();
        
        //Controller
        controller();

    }   // Main Method

    private void receiveValue() {
        loginStrings = getIntent().getStringArrayExtra("Login");
    }

    private void controller() {
        videoButton.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        textButton.setOnClickListener(this);
    }

    private void initialView() {
        videoButton = (Button) findViewById(R.id.btnVideo);
        imageButton = (Button) findViewById(R.id.btnImage);
        textButton = (Button) findViewById(R.id.btnText);
    }

    @Override
    public void onClick(View view) {

        int i = 0;

        switch (view.getId()) {
            case R.id.btnVideo:
                i = 0;
                break;
            case R.id.btnImage:
                i = 1;
                break;
            case R.id.btnText:
                i = 2;
                break;
            default:
                i = 0;
                break;
        }

        Log.d("14MayV2", "i(SENT) ==> " + i);

        Intent intent = new Intent(ServiceUser.this, ShowService.class);
        intent.putExtra("KeyMode", i);
        intent.putExtra("Login", loginStrings);
        startActivity(intent);


    }

}   // Main Class
