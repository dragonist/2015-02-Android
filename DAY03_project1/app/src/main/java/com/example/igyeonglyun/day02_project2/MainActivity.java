package com.example.igyeonglyun.day02_project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button b_write;
    private Button b_refresh;
    private ArrayList<Article> articleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_write = (Button) findViewById(R.id.button1);
        b_refresh = (Button) findViewById(R.id.button2);

        b_write.setOnClickListener(this);
        b_refresh.setOnClickListener(this);

        Dao dao = new Dao(getApplicationContext());
        String testJsonData = dao.getJsonTestData();
        dao.insertJsonData(testJsonData);

        //db로부터 게시글 리스트를 받아옴
        articleList = dao.getArticleList();

        // adapter 적용
        ListView listView = (ListView) findViewById(R.id.listView);
        ArticleAdapter adapter = new ArticleAdapter(this, R.layout.view_product_list, articleList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent1 = new Intent(this, FormActivity.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, FormActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent3 = new Intent(this, ShowActivity.class);
        intent3.putExtra("ArticleNumber", articleList.get(position).getArticleNumber()+"");
        startActivity(intent3);
//        Log.i("TEXT", position + "번 리스트 선택됨");
//        Log.i("TEST", "리스트 내용 "+listDataArray.get(position).getText1());
    }
}
