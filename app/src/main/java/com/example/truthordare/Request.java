package com.example.truthordare;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Request")
public class Request extends ParseObject {
    public static final String KEY_USER = "user";
    public static final String KEY_DESCRIPTION = "reqDescription";
    public static final String KEY_DOLLAR = "dollarAmt";
    public static final String KEY_TYPE = "reqType";
    public static final String KEY_STATUS = "status";

    //getters
    //get user
    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    //get challenge description
    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    //get dollar amount
    public double getDollarAmt() {
        return getDouble(KEY_DOLLAR);
    }

    //get post type
    public boolean getReqType() {
        //false = truth
        //true = dare
        return getBoolean(KEY_TYPE);
    }

    //get status
    public boolean getStatus() {
        //true = complete
        //false = incomplete
        return getBoolean(KEY_STATUS);
    }


    //setters
    //set user
    public void setUser(ParseUser parseUser) {
        put(KEY_USER, parseUser);
    }

    //set challenge description
    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    //set dollar amt
    public void setDollarAmt(double amt) {
        put(KEY_DOLLAR, amt);
    }

    //set post type
    public void setReqType(boolean type) {
        //true = truth
        //false = dare
        put(KEY_TYPE, type);
    }

    //set status
    public void setStatus(boolean status) {
        put(KEY_STATUS, status);
    }
}

