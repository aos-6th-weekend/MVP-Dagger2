package com.example.rathana.mvp_demo.app.di;

import com.example.rathana.mvp_demo.data.service.ArticleService;
import com.example.rathana.mvp_demo.ui.home.MainActivity;
import com.example.rathana.mvp_demo.ui.home.mvp.HomeMvp;
import com.example.rathana.mvp_demo.ui.login.LoginActivity;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginMvp;

import dagger.Component;


@Component(modules = {ApplicationModule.class,NetworkModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
    void inject(LoginActivity activity);


    LoginMvp.Interactor getLoginInteractor();
    HomeMvp.Interactor getHomeInteractor();
    HomeMvp.Presenter getHomePresenter();

    //network service
    ArticleService getArticleService();
}
