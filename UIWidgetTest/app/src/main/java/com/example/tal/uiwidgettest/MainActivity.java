package com.example.tal.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                imageView.setImageResource(R.drawable.img_2);

                //circle progress
                //if (progressBar.getVisibility() == View.GONE) {
                //    progressBar.setVisibility(View.VISIBLE);
                //} else {
                //    progressBar.setVisibility(View.GONE);
                //}
                //bar progress
                //int progress = progressBar.getProgress();
                //progress = progress + 10;
                //progressBar.setProgress(progress);

                //String inputText = editText.getText().toString();
                //Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();

                /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something is important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "OK");
                    }
                });
                dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "Cancle");
                    }
                });
                dialog.show();*/

                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Load...");
                progressDialog.setCancelable(true);
                progressDialog.show();

                break;
            default:
                break;
        }
    }
}
