package com.example.rathana.mvp_demo.ui.login.mvp;

public class LoginPresenter implements LoginMvp.Presenter {

    private LoginMvp.Interactor interactor;
    private LoginMvp.View view;


    public LoginPresenter(LoginMvp.Interactor interactor){

        //interactor=new LoginInteractor();
        this.interactor=interactor;
    }

    @Override
    public void setView(LoginMvp.View view) {
        this.view=view;
    }

    @Override
    public void onLogin(String name, String pass) {
        if(view!=null)
            view.onShowLoading();

        interactor.attemptLogin(name, pass, new LoginMvp.Interactor.InteractorListener() {
            @Override
            public void onSuccess(String msg) {
                if(view!=null) {
                    view.onHideLoading();
                    view.onLoginSuccess(msg);
                }
            }

            @Override
            public void onFailure(String msg) {
                if(view!=null){
                    view.onHideLoading();
                    view.onLoginFail(msg);
                }

            }
        });
    }
}
