package com.example.tal.networkbestpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendRequest = (Button) findViewById(R.id.send_request);
        responseText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.send_request) {
            HttpUtil.sendOkHttpRequest("https://www.baidu.com", new okhttp3.Callback() {
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseData = response.body().string();
                    showResponse(responseData);
                }

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }
            });

            HttpUtil.sendUrlHttpRequest("https://www.baidu.com", new HttpCallbackListener() {
                @Override
                public void onFinish(String responseData) {
                    showResponse(responseData);
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }
}
