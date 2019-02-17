package com.example.rathana.mvp_demo.ui.login.mvp;

public interface LoginMvp {

    interface View{
        void onLoginSuccess(String msg);
        void onLoginFail(String msg);
        void onShowLoading();
        void onHideLoading();
    }
    interface Presenter{
        void setView(View view);
        void onLogin(String name,String pass);

    }
    interface Interactor{
        void attemptLogin(String name,String pass,InteractorListener listener);


        interface InteractorListener{
            void onSuccess(String msg);
            void onFailure(String msg);
        }
    }

}
