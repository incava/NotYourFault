package com.incava.notyourfault;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 상세 페이지를 보여주면서 전화, 지도, 홈페이지등 여러가지 정보를 볼 수 있다.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ShelterItem item = (ShelterItem) bundle.getSerializable("dataClass");
        String name = item.fcltNm;
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}