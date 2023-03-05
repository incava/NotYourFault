package com.incava.notyourfault;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ShelterAdapter adapter;
    ArrayList<ShelterItem> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.rcv_shelter);
        adapter = new ShelterAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
        new Thread() {
            @Override
            public void run() {
                try {
                    /*URL*/
                    String baseUrl = "http://apis.data.go.kr/1383000/gmis/teenRAreaService/getTeenRAreaList";
                    String serviceKey = "hSF2%2B%2BmMiQXwGI5XfZmbSDPqorgTy%2BjVDuSMNwWmA1gY2h2HASedPbnFIz%2FeEBlxG8O2nv2vIsz7WSGLeIjWzw%3D%3D";
                    //String serviceKey2 = "hSF2++mMiQXwGI5XfZmbSDPqorgTy+jVDuSMNwWmA1gY2h2HASedPbnFIz/eEBlxG8O2nv2vIsz7WSGLeIjWzw==";
                    String pageNo = "1";
                    String numOfRows = "100";
                    String type = "xml";
                    StringBuilder urlBuilder = new StringBuilder(baseUrl); /*URL*/
                    urlBuilder.append("?").append(URLEncoder.encode("serviceKey", "UTF-8")).append("=").append(serviceKey); /*Service Key*/
                    urlBuilder.append("&").append(URLEncoder.encode("pageNo", "UTF-8")).append("=").append(pageNo); /*페이지 번호*/
                    urlBuilder.append("&").append(URLEncoder.encode("numOfRows", "UTF-8")).append("=").append(numOfRows); /*한 페이지 결과 수*/
                    urlBuilder.append("&").append(URLEncoder.encode("type", "UTF-8")).append("=").append(type); /*XML/JSON 여부*/
                    URL url= new URL(urlBuilder.toString());//문자열로 된 요청 url을 URL 객체로 생성.
                    runOnUiThread(()-> Toast.makeText(MainActivity.this, urlBuilder, Toast.LENGTH_SHORT).show());
                    Log.i("url",url.toString());
                    InputStream is= url.openStream(); //url위치로 입력스트림 연결
                    XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
                    XmlPullParser xpp= factory.newPullParser();
                    int eventType = xpp.getEventType();
                    xpp.setInput( new InputStreamReader(is, StandardCharsets.UTF_8) );
                    String tag;
                    ShelterItem item = null;
                    while( eventType != XmlPullParser.END_DOCUMENT ){

                        switch( eventType ){
                            case XmlPullParser.START_DOCUMENT:
                                break;
                            case XmlPullParser.START_TAG:
                                tag= xpp.getName();//태그 이름 얻어오기
                                if(tag.equals("item")){
                                    item = new ShelterItem();
                                }
                                else if(tag.equals("rprsTelno")){//대표전화번호
                                    xpp.next();
                                    item.setRprsTelno((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("fxno")){// 팩스번호
                                    xpp.next();
                                    item.setFxno((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("emlAddr")){// 이메일
                                    xpp.next();
                                    item.setEmlAddr((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("cpctCnt")){// 정원수
                                    xpp.next();
                                    item.setCpctCnt((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("etrTrgtCn")){// 가능 성별
                                    xpp.next();
                                    item.setEtrTrgtCn((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("etrPrdCn")){// 입소기간내용
                                    xpp.next();
                                    item.setEtrPrdCn((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("nrbSbwNm")){// 인근지하철명
                                    xpp.next();
                                    item.setNrbSbwNm((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("nrbBusStnNm")){ // 인근버스정류장명
                                    xpp.next();
                                    item.setNrbBusStnNm((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("crtrYmd")){// 기준 일자
                                    xpp.next();
                                    item.setCrtrYmd((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("expsrYn")){// 노출여부
                                    xpp.next();
                                    item.setExpsrYn((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("rmrkCn")){// 비고
                                    xpp.next();
                                    item.setRmrkCn((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("fcltNm")){// 시설명
                                    xpp.next();
                                    item.setFcltNm((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("operModeCn")){// 운영형태
                                    xpp.next();
                                    item.setOperModeCn((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("fcltTypeNm")){// 시설유형내용
                                    xpp.next();
                                    item.setFcltTypeNm((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("ctpvNm")){// 시도명
                                    xpp.next();
                                    item.setCtpvNm((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("sggNm")){// 시군구명
                                    xpp.next();
                                    item.setSggNm((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("roadNmAddr")){// 도로명주소:
                                    xpp.next();
                                    item.setRoadNmAddr((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("lotnoAddr")){// 지번 주소
                                    xpp.next();
                                    item.setLotnoAddr((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("lat")){// 위도
                                    xpp.next();
                                    item.setLat((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("lot")){// 경도
                                    xpp.next();
                                    item.setLot((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                else if(tag.equals("hmpgAddr")){// 홈페이지 주소
                                    xpp.next();
                                    item.setHmpgAddr((xpp.getText() == null) ?"없음":xpp.getText());
                                }
                                break;
                            case XmlPullParser.END_TAG:
                                tag = xpp.getName(); //태그 이름 얻어오기
                                if(tag.equals("item")) {
                                    arrayList.add(item);// 첫번째 검색결과종료..줄바꿈
                                }
                                break;
                        }
                        eventType = xpp.next();
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch blocke.printStackTrace();
                }
                runOnUiThread(()->adapter.notifyDataSetChanged());
            }
        }.start();
    }




}