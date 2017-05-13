package dru.kotham.narinthon.devnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //Initial View
        initialView();

        //Controller
        Controller();

    }// Main Method

    private void Controller() {
        button.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void initialView() {
        userEditText = (EditText) findViewById(R. id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtNewRegister);
        button = (Button) findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View v) {

        //For Button
        if (v == button) {

            //Get Value from EditText

            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();


            //Check Space
            if (userString.length()== 0 || passwordString.length() == 0) {
                //Have Space
                Log.d("13MayV1","Have Space");
                MyAlert myAlert = new MyAlert(this);
                myAlert.myDialog("Have Space","Please fill all Erery Black");



            } else {
                //No Space
                Log.d("13MayV1","No Space");
            }


        }

        //For TextView
        if (v == textView) {

        }
    }
} // Main Class นี่คือคลาสหลัก
