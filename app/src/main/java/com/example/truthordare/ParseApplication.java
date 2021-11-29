package com.example.truthordare;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("X1bzWChxRATJIS6FWrejajxGyoB3BjJB5oKQZ7UG")
                .clientKey("zAD6PH5XZImrAXZi6uOhtbz6xUQCHB9U5Wd2y5YQ")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
