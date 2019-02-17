package com.example.rathana.mvp_demo.ui.home.mvp;

import com.example.rathana.mvp_demo.data.ServiceGenerator;
import com.example.rathana.mvp_demo.data.service.ArticleService;
import com.example.rathana.mvp_demo.entity.Article;
import com.example.rathana.mvp_demo.entity.response.ArticleResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeInteractor implements HomeMvp.Interactor {

    //@Inject
    ArticleService articleService;
    CompositeDisposable disposable=new CompositeDisposable();

    public HomeInteractor(ArticleService articleService){
        this.articleService=articleService;
    }
    
    @Override
    public void getArticles(InteractorListener listener) {
        List<Article> articles=new ArrayList<>();
        disposable.add(
            articleService.getArticles(1,100)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<ArticleResponse>() {
                        @Override
                        public void onNext(ArticleResponse articleResponse) {
                            articles.addAll(articleResponse.getArticle());
                        }

                        @Override
                        public void onError(Throwable e) {
                            listener.onFailure(e.toString());
                        }

                        @Override
                        public void onComplete() {
                            listener.onSuccess(articles);
                        }
                    })
        );
    }

    @Override
    public void onDestroy() {
        disposable.clear();
    }
}
