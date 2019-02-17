package com.example.rathana.mvp_demo.app;

import android.app.Application;

import com.example.rathana.mvp_demo.app.di.AppComponent;
import com.example.rathana.mvp_demo.app.di.ApplicationModule;
import com.example.rathana.mvp_demo.app.di.DaggerAppComponent;

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component=DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();

    }

    public AppComponent getComponent(){
        return this.component;
    }
}
