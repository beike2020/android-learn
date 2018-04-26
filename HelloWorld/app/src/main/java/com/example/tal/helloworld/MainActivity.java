package com.example.tal.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.d(TAG, "onCreate Execute");
        Log.d(TAG, "Task id is " + getTaskId());

        Button mybutton = (Button) findViewById(R.id.mybutton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked button 0", Toast.LENGTH_SHORT).show();
            }
        });

        Button button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //direct intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                //indirect intent
                //Intent intent = new Intent("com.example.tal.helloworld.ACTION_START");
                //intent.addCategory("com.example.tal.helloworld.MY_CATEGORY");

                //put data to other activity
                String data1 = "Hello SecondActivity";
                //String data2 = "Hello World";
                intent.putExtra("extra_data", data1);

                //Person person = new Person();
                //person.setName("Tom");
                //person.setAge(20);
                //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //intent.putExtra("person_data", person);
                //startActivity(intent);

                //startActivity(intent);
                //SecondActivity.actionStart(MainActivity.this, data1, data2);
                startActivityForResult(intent, 1);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_view);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to browse service
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("https://www.baidu.com"));

                //intent to dial service
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    //Person person = (Person) getIntent().getSerializableExtra("person_data");
                    Log.d("MainActivity", returnedData);
                }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivitiy", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }
}
