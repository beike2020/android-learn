package com.example.tal.servicebestpractice;

/**
 * Created by tal on 2018/3/5.
 */

public interface DownloadListener {
    void onProgress(int progress);
    void onSuccess();
    void onFailed();
    void onPaused();
    void onCanceled();
}
