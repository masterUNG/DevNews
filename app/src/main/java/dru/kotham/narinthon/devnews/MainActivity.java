package dru.kotham.narinthon.devnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
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

                checkUserAnPass();
            }


        }

        //For TextView
        if (v == textView) {

        }
    }

    private void checkUserAnPass() {

        try {
            //Create Objece
            GetAllData getAllData = new GetAllData(this);
            MyConstant myConstant = new MyConstant();
            MyAlert myAlert = new MyAlert(this);

            getAllData.execute(myConstant.getUrlGETUser());
            String strJSON = getAllData.get();
            Log.d("14MayV1", "JSON ==>" + strJSON);

            //checkUser
            boolean b = true; //For User false
            String[] columstring = new String[]{"login_id",
                    "login_username","login_password","login_status","login_Name"};
            String[] loginString = new String[columstring.length];

            JSONArray jsonArray = new JSONArray(strJSON);
            for (int i=0; i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString(columstring[1]))) {
                    b = false;
                    for (int i1=0;i1<columstring.length;i1++) {
                        loginString[i1] = jsonObject.getString(columstring[i1]);
                    }
                }
            }//for
            if (b) {
                //User False
                myAlert.myDialog("User false","No This User in my Database");
            } else if (passwordString.equals(loginString[2])) {
                //password true
                Toast.makeText(this, "welcome" + loginString[4], Toast.LENGTH_SHORT).show();
                //for User
                if (loginString[3].equals("111")) {
                    //Intent to Service User
                    Intent intent = new Intent(MainActivity.this, ServiceUser.class);
                    intent.putExtra("Login", loginString);
                    startActivity(intent);
                    finish();
                }
                //for Admin
                if (loginString[3].equals("500")) {
                    //Intent to Service Admin
                }


            } else {
                //Password false
                myAlert.myDialog("Password false", "Pleasa Try Again Password False");
            }



        } catch (Exception e) {
            Log.d("14MayV1", "e checkUser ==>" + e.toString());
        }
    }
} // Main Class นี่คือคลาสหลัก
