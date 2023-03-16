package com.incava.notyourfault;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

import java.util.Arrays;
import java.util.Locale;

/**
 * 상세 페이지를 보여주면서 전화, 지도, 홈페이지등 여러가지 정보를 볼 수 있다.
 */
public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView tvTitle, tvLimitDay,tvNum, tvTarget, tvOper, tvSub, tvBus, tvTel, tvFax, tvHmpg, tvAddr;
    LatLng latLng = null; // 위도 경도 담은 객체.
    String title = null; //앱 제목

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        findView(); //findView
        setBundleOfData(); // bundle값
        attachListener(); //리스너 연결.
        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);

    }

    void settingMark(NaverMap naverMap){
        Marker marker = new Marker();
        marker.setPosition(latLng); //마커 위도 경도 넣기.
        marker.setCaptionText(getSupportActionBar().getTitle().toString()); // 앱바의 제목과 일치하므로 넣어줌.
        marker.setMap(naverMap); // 마커 생성.
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(latLng) //카메라 움직임.
                .animate(CameraAnimation.Fly); //애니메이션 추가.
        naverMap.moveCamera(cameraUpdate);
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
        setToolbar(item.fcltNm);
        latLng = new LatLng(Double.parseDouble(item.lat),Double.parseDouble(item.lot)); // 위도 경도 받아서 저장.
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

    void setToolbar(String titles){// 앱바 적용.
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setTitle(titles);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish(); //만약 back버튼을 눌렀을 때 , 이 액티비티를 끝내도록. 설계
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        settingMark(naverMap); // 준비되면 콜백으로 받음.
    }
}