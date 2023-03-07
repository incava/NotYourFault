package com.incava.notyourfault;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * 상세 페이지를 보여주면서 전화, 지도, 홈페이지등 여러가지 정보를 볼 수 있다.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}