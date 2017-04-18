package com.example.ak.jersey;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView label;
    Button get;
    Button post;
    EditText name;
    EditText pass;
    private static AppCompatActivity appCompatActivity;

    public static AppCompatActivity getAppCompatActivity(){
        return appCompatActivity;
    }
    public static Context getContext() {
        return getAppCompatActivity().getApplicationContext();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appCompatActivity = this;
        setContentView(R.layout.activity_main);
        label = (TextView) findViewById(R.id.label);
        get = (Button) findViewById(R.id.button2);
        post = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get();
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post();
            }
        });
    }


    private void get() {

        final Call<List<User>> call = WebServices.webServices.users();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>>  call, Response<List<User>> response) {
                List<User> u = response.body();
                //System.out.println(response.toString());
                label.setText(u.toString());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                label.setText(t.getMessage());
            }
        });
    }
    private void post() {
        User u;
        u = new User();
        u.setEmail(name.getText().toString());
        u.setPassword(pass.getText().toString());
        final  Call<Void> call = WebServices.webServices.postUsers(u.getEmail(),u.getPassword());

        call.enqueue(new Callback<Void>(){
            @Override
            public void onResponse(Call<Void>  call, Response<Void> response) {
               if(response.code() == 200){
                    label.setText("Sikeres");
                    //System.out.println(response.code()+ " " +response.body()+ " " +response.headers()+ " " +response.raw());
                }else{
                    label.setText("Sikertelen");
                    System.out.println(response.toString());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                label.setText("Sikertelen");
                System.out.println(t.getMessage());
            }
        });
    }

}
