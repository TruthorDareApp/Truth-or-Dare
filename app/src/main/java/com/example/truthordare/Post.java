package com.example.truthordare;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends Request {
    public static final String KEY_USER = "user";
    public static final String KEY_REQUEST = "request";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_LIKE_COUNT = "likeCount";

    //getters
    //get user
    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    //get request object
    public ParseObject getRequest() {
        return getParseObject(KEY_REQUEST);
    }

    //get video file
    public ParseFile getVideo() {
        return getParseFile(KEY_VIDEO);
    }

    //get like count
    public int getLikeCount() {
        return getInt(KEY_LIKE_COUNT);
    }

    //setters
    //set user
    public void setUser(ParseUser parseUser) {
        put(KEY_USER, parseUser);
    }

    //set request object
    public void setRequest(ParseObject parseObject) {
        put(KEY_REQUEST, parseObject);
    }

    //set video file
    public void setVideo(ParseFile parseFile) {
        put(KEY_VIDEO, parseFile);
    }

    //set like count
    public void setLikeCount(int count) {
        put(KEY_LIKE_COUNT, count);
    }
}
