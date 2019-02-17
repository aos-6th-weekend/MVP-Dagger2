package com.example.rathana.mvp_demo.ui.home.mvp;

import com.example.rathana.mvp_demo.entity.Article;

import java.util.List;

import javax.inject.Inject;

public class HomePresenter implements HomeMvp.Presenter {

    private HomeMvp.Interactor interactor;
    private HomeMvp.View view;


    public HomePresenter(HomeMvp.Interactor interactor){
        this.interactor=interactor;
    }

    @Override
    public void setView(HomeMvp.View view) {
        this.view=view;
    }

    @Override
    public void getArticles() {
        if(view!=null)
            view.onShowLoading();

        interactor.getArticles(new HomeMvp.Interactor.InteractorListener() {
            @Override
            public void onSuccess(List<Article> articles) {
                if(view!=null){
                   view.onHideLoading();
                   view.onSuccess(articles);
                }

            }

            @Override
            public void onFailure(String msg) {
                if(view!=null){
                    view.onHideLoading();
                    view.onFail(msg);
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        interactor.onDestroy();
    }
}
