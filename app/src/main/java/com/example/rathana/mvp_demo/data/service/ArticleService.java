package com.example.rathana.mvp_demo.data.service;

import com.example.rathana.mvp_demo.entity.response.ArticleResponse;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ArticleService {


    @DELETE("/v1/api/articles/{articleId}")
    Call<Response<JsonObject>> deleteArticle(@Path("articleId") int id);

    //Rx
    @GET("/v1/api/articles")
    Observable<ArticleResponse> getArticles(@Query("page") int page,
                                              @Query("limit") int limit);

}
