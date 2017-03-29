package com.example.ak.jersey;

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
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = (TextView) findViewById(R.id.label);
        get = (Button) findViewById(R.id.button2);
        post = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.editText);

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
                label.setText(u.toString());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                label.setText(t.getMessage());
            }
        });
    }
    private void post() {
        User u;/* = new User("new@new.new","new",3,"new","new");
        List<User> l = new ArrayList<>();
        u.setFirstName(name.getText().toString());
        l.add(u);*/
        u =  new User("new@new.new","new",3,"new","new");
        u.setEmail(name.getText().toString());
        final  Call<LoginResult> call = WebServices.webServices.postUsers(u);

        call.enqueue(new Callback<LoginResult>(){
            @Override
            public void onResponse(Call<LoginResult>  call, Response<LoginResult> response) {
                label.setText(response.toString());
                System.out.println(response.toString());
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                label.setText(t.getMessage());
                System.out.println(t.getMessage());
            }
        });
    }

}
