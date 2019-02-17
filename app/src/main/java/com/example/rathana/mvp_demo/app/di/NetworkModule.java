package com.example.rathana.mvp_demo.app.di;

import com.example.rathana.mvp_demo.data.service.ArticleService;

import javax.inject.Named;
import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {


    @Provides
    public Retrofit provideRetrofit(@Named("baseUrl") String baseUrl){
        return  new Retrofit.Builder().baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Named("baseUrl")
    public String provideBaseUrl(){
        return "http://api-ams.me";
    }


    @Provides
    public ArticleService provideArticleService(Retrofit retrofit){
        return retrofit.create(ArticleService.class);
    }


}
