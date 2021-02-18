package com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bruno_brasil_irisi_meko_comp304_sec003_lab04.R;

public class LoginActivity extends AppCompatActivity {

    EditText uname, pwd;
    Button loginBtn;
    SharedPreferences pref;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uname = (EditText)findViewById(R.id.editTextUsername);
        pwd = (EditText)findViewById(R.id.editTextPassword);
        loginBtn = (Button)findViewById(R.id.buttonLogin);
        // To get the values from Shared Preferences file,
        // we need to call a getSharedPreferences() method and pass a file name as a parameter.
        //MODE_PRIVATE - to make sure that the file can be accessed only within our application.
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(LoginActivity.this, NavigationActivity.class);
        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                if(username.equals("nurse123") && password.equals("123456")){
                    // To store data in a shared preference file,
                    // we need an editor to edit and save the changes in the SharedPreferences object.

                    SharedPreferences.Editor editor = pref.edit();
                    // Different values type apart from integer can be put.
                    //editor.putBoolean("keyname",true);
                    //editor.putString("keyname","string value");
                    //editor.putInt("keyname","int value");
                    //editor.putFloat("keyname","float value");
                    //editor.putLong("keyname","long value");
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Credentials are not valid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
