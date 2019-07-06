package ir.mohamadalirahimi.bookreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    Button Login;
    EditText email;
    EditText password;

    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        Login = findViewById(R.id.btn_log);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);

        Login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().trim().equals("")) {
                    Toast.makeText(context, "Please enter your email! ",
                            Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().trim().length() < 6){
                    Toast.makeText(context, "enter larger than password 6 character",
                            Toast.LENGTH_LONG).show();

                }
                else {

                    Intent intent = new Intent(context, HomeActivity.class);
                    startActivity(intent);

                }
            }
        }));
    }
}

