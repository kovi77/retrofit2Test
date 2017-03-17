package com.example.ak.jersey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    TextView label;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = (TextView) findViewById(R.id.label);
        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {

        final Call<List<User>> call = WebServices.webServices.users();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>>  call, Response<List<User>> response) {
                List<User> u = response.body();
                label.setText(u.toString());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                label.setText(t.getMessage());
            }
        });
    }
}
