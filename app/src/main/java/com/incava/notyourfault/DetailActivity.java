package com.incava.notyourfault;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.util.Linkify;
import android.widget.TextView;

import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;

import java.util.Arrays;
import java.util.Locale;

/**
 * 상세 페이지를 보여주면서 전화, 지도, 홈페이지등 여러가지 정보를 볼 수 있다.
 */
public class DetailActivity extends AppCompatActivity {

    TextView tvTitle, tvLimitDay,tvNum, tvTarget, tvOper, tvSub, tvBus, tvTel, tvFax, tvHmpg, tvAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        findView(); //findView
        setBundleOfData(); // bundle값
        attachListener(); //리스너 연결.
        NaverMapSdk.getInstance(this).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("m2hiqhfynl"));
    }

    void findView(){//findView 정리.
        tvTitle = findViewById(R.id.tv_title);
        tvLimitDay = findViewById(R.id.tv_limitDay);
        tvNum = findViewById(R.id.tv_num);
        tvTarget = findViewById(R.id.tv_target);
        tvOper = findViewById(R.id.tv_oper);
        tvSub = findViewById(R.id.tv_sub);
        tvBus = findViewById(R.id.tv_bus);
        tvTel = findViewById(R.id.tv_tel);
        tvFax = findViewById(R.id.tv_fax);
        tvHmpg = findViewById(R.id.tv_hmpg);
        tvAddr = findViewById(R.id.tv_addr);
    }

    void setBundleOfData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ShelterItem item = (ShelterItem) bundle.getSerializable("dataClass");//MainActivity에서 받은 번들 풀기.
        tvTitle.setText(item.fcltNm);
        tvLimitDay.setText(item.etrPrdCn);
        tvNum.setText(item.cpctCnt);
        tvTarget.setText(item.etrTrgtCn);
        tvOper.setText(item.operModeCn);
        tvSub.setText(item.nrbSbwNm);
        tvBus.setText(item.nrbBusStnNm);
        tvTel.setText(PhoneNumberUtils.formatNumber(item.rprsTelno, Locale.getDefault().getCountry()));//지역에 맞게 하이픈 설정.
        tvFax.setText(PhoneNumberUtils.formatNumber(item.fxno, Locale.getDefault().getCountry()));
        tvHmpg.setText(item.hmpgAddr);
        tvAddr.setText(item.hmpgAddr);
    }

    void attachListener(){
        tvHmpg.setOnClickListener(v -> hmpgClick());
        tvTel.setOnClickListener(v -> telClick());
    }

    void hmpgClick(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvAddr.getText().toString()));
        startActivity(intent);
    }

    void telClick(){
        //전화번호 클릭시 전화할 수 있도록
        Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tvTel.getText().toString()));
        startActivity(tt);
    }

}