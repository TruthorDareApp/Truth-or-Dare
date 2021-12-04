package com.example.truthordare;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject
{

    public static final String KEY_LIKES = "likeCount";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_USER = "user";
    public static final String KEY_REQUEST = "request";

    public String getRequest()
    {
        return getString(KEY_REQUEST);
    }

    public void setRequest(String request)
    {
        put (KEY_REQUEST, request);
    }

    public ParseFile getVideo()
    {
        return getParseFile(KEY_VIDEO);
    }

    public void setVideo(ParseFile parseFile)
    {
        put(KEY_VIDEO, parseFile);
    }

    public ParseUser getUser()
    {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user)
    {
        put(KEY_USER, user);
    }

}
