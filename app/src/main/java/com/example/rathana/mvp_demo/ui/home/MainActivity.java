package com.example.rathana.mvp_demo.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rathana.mvp_demo.R;
import com.example.rathana.mvp_demo.app.App;
import com.example.rathana.mvp_demo.entity.Article;
import com.example.rathana.mvp_demo.ui.home.mvp.HomeMvp;
import com.example.rathana.mvp_demo.ui.home.mvp.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
implements HomeMvp.View ,ArticleAdapter.ArticleCallback {

    RecyclerView rvArticle;
    ArticleAdapter articleAdapter;
    List<Article> articles=new ArrayList<>();
    ProgressBar progressBar;

    @Inject
    HomeMvp.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplicationContext()).getComponent().inject(this);

        initial();

        rvArticle=findViewById(R.id.rvArticle);
        progressBar=findViewById(R.id.progressBar);

        articleAdapter=new ArticleAdapter(articles,this);
        rvArticle.setLayoutManager(new LinearLayoutManager(this));
        rvArticle.setAdapter(articleAdapter);

        presenter.getArticles();
    }

    private void initial() {
        //presenter=new HomePresenter();
        presenter.setView(this);
    }

    @Override
    public void onSuccess(List<Article> articles) {
        articleAdapter.updateArticles(articles);
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, "no Data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }


    @Override
    public void onDelete(Article article, int pos) {

    }

    @Override
    public void onArticleItemClicked(Article article) {

    }
}
