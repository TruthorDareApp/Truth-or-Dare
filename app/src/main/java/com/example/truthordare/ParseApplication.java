package com.example.truthordare;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        ParseObject.registerSubclass(Request.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("X1bzWChxRATJIS6FWrejajxGyoB3BjJB5oKQZ7UG")
                .clientKey("zAD6PH5XZImrAXZi6uOhtbz6xUQCHB9U5Wd2y5YQ")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
