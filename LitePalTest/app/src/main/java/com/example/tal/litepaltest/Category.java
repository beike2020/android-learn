package com.example.tal.litepaltest;

import android.provider.ContactsContract;

import org.litepal.crud.DataSupport;

/**
 * Created by tal on 2018/3/2.
 */

public class Category extends DataSupport {
    private int id;
    private String categoryName;
    private int categoryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
}
