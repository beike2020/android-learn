package com.example.tal.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
            }
        });

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("The Da vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknown");
                book.save();

                Book bok2 = new Book();
                bok2.setName("The Lost Symbol");
                bok2.setAuthor("Dan Brown");
                bok2.setPages(510);
                bok2.setPrice(19.95);
                bok2.setPress("Unknown");
                bok2.save();
                bok2.setPrice(10.99);
                bok2.save();
            }
        });

        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setPrice(19.95);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");

            }
        });

        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(Book.class, "price < ?", "18");
            }
        });

        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //List<Book> books = DataSupport.select("name", "author", "pages").where("page > ?", "400").order("pages").limit(10).offset(1).find(Book.class);
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book : books) {
                    Log.d("MainActivity", "book name is " + book.getName());
                    Log.d("MainActivity", "book author is " + book.getAuthor());
                    Log.d("MainActivity", "book pages is " + book.getPages());
                    Log.d("MainActivity", "book price is " + book.getPrice());
                    Log.d("MainActivity", "book press is " + book.getPress());
                }
            }
        });
    }
}
