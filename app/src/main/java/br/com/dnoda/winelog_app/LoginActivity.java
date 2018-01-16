package br.com.dnoda.winelog_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = findViewById(R.id.etLogin);
        etPasswd = findViewById(R.id.etPasswd);
    }

    public void login(View view){
        String login = etLogin.getText().toString();
        String passwd = etPasswd.getText().toString();

        if(login.equals("admin") && passwd.equals("admin")){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("user", login);

            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "User or password error", Toast.LENGTH_SHORT).show();
        }
    }
}
