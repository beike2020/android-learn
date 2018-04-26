package com.example.tal.networkbestpractise;

/**
 * Created by tal on 2018/3/4.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
