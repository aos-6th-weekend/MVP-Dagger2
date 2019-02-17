package com.example.rathana.mvp_demo.ui.home.mvp;

import com.example.rathana.mvp_demo.entity.Article;

import java.util.List;

public interface HomeMvp {

    interface View{
        void onSuccess(List<Article> articles);
        void onFail(String msg);
        void onShowLoading();
        void onHideLoading();
    }

    interface Presenter{
        void setView(View view);
        void getArticles();
        void onDestroy();

    }
    interface Interactor{
        void getArticles(InteractorListener listener);
        void onDestroy();

        interface InteractorListener{
            void onSuccess(List<Article> articles);
            void onFailure(String msg);
        }
    }

}
