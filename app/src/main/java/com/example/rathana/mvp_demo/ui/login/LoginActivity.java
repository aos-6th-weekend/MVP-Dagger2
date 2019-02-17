package com.example.rathana.mvp_demo.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rathana.mvp_demo.R;
import com.example.rathana.mvp_demo.app.App;
import com.example.rathana.mvp_demo.entity.Author;
import com.example.rathana.mvp_demo.ui.home.MainActivity;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginMvp;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginPresenter;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity
implements LoginMvp.View {

    Button btnLogin;
    EditText name,password;
    ProgressBar progressBar;

    @Inject
    LoginPresenter presenter;

    @Inject
    Author author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplicationContext()).getComponent().inject(this);

        setupUI();
        //presenter=new LoginPresenter();
        presenter.setView(this);

        btnLogin.setOnClickListener(v->{
            presenter.onLogin(name.getText().toString(),
                    password.getText().toString());

        });


        author.setEmail("admin@gmail.com");
        author.setGender("male");
        author.setId(123);
        author.setName("admin");
        Log.e("ooooo", "onCreate: "+author.toString() );

    }

    private void setupUI() {
        btnLogin=findViewById(R.id.btnLogin);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);
    }


    @Override
    public void onLoginSuccess(String msg) {
        startActivity(new Intent(this,MainActivity.class));
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail(String msg) {
        Toast.makeText(this, "lgoin fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoading() {
        progressBar.setVisibility(View.GONE);

    }
}
