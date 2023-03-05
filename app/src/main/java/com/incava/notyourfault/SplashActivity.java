package com.incava.notyourfault;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;


import java.util.Random;

/**
 * 2초간 스플래쉬 화면으로, 쉼터를 찾기 잘했다는 생각을 코멘트로 보여줄 화면
 */
public class SplashActivity extends AppCompatActivity {

    String[] commentAry; // comment 배열
    TextView tvComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        commentAry = getResources().getStringArray(R.array.commentAry);
        int idx = new Random().nextInt(commentAry.length); //코멘트 배열 개수만큼 랜덤으로 뽑아 코멘트로 보여줌.
        tvComment = findViewById(R.id.tv_comment);
        tvComment.setText(commentAry[idx]);
        moveMain(2);
    }
    //2초간 보여준 후, MainActivity로 이동.
    //추후 , api호출이 끝나면 넘어가는 것으로 하려함.
    private void moveMain(int sec) {
        new Handler().postDelayed(() -> {
            //new Intent(현재 context, 이동할 activity)
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);	//intent 에 명시된 액티비티로 이동
            finish();	//현재 액티비티 종료
        }, 1000L * sec); // sec초 정도 딜레이를 준 후 시작
    }
}