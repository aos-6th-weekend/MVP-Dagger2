package com.example.rathana.mvp_demo.ui.login.mvp;

import android.os.Handler;

public class LoginInteractor implements LoginMvp.Interactor {

    private String name="admin";
    private String password="admin";

    @Override
    public void attemptLogin(String name, String pass, InteractorListener listener) {

        new Handler().postDelayed(()->{
            if(name.equals(this.name) && pass.equals(this.password)){
                listener.onSuccess("Login success");
            }else{
                listener.onFailure("login fail");
            }

        },500);


    }


}
