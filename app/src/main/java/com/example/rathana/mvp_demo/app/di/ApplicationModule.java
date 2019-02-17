package com.example.rathana.mvp_demo.app.di;

import com.example.rathana.mvp_demo.data.service.ArticleService;
import com.example.rathana.mvp_demo.entity.Author;
import com.example.rathana.mvp_demo.ui.home.mvp.HomeInteractor;
import com.example.rathana.mvp_demo.ui.home.mvp.HomeMvp;
import com.example.rathana.mvp_demo.ui.home.mvp.HomePresenter;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginInteractor;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginMvp;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    public Author provideAuthor(){
        return new Author();
    }


    //provides Presenter

    @Provides
    public LoginPresenter provideLoginPresenter(LoginMvp.Interactor interactor){
        return new LoginPresenter(interactor);
    }


    @Provides
    public HomeMvp.Presenter provideHomePresenter(HomeMvp.Interactor interactor){
        return  new HomePresenter(interactor);
    }




    //provides Interactor
    @Provides
    public LoginMvp.Interactor provideLoginInteractor(){
        return new LoginInteractor();
    }

    @Provides
    public HomeMvp.Interactor provideHomeInteractor(ArticleService articleService){
        return new HomeInteractor(articleService);
    }

}
