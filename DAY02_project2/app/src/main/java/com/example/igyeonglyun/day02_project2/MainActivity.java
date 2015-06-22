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

public class MainActivity extends Activity implements View.OnClickListener , AdapterView.OnItemClickListener{

    private Button b_write;
    private Button b_refresh;
    private ArrayList<ListData> listDataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_write = (Button)findViewById(R.id.button1);
        b_refresh = (Button)findViewById(R.id.button2);

        b_write.setOnClickListener(this);
        b_refresh.setOnClickListener(this);

        ListData data1 = new ListData("타조", "얼굴작고 목길고 완전 예쁨", "icon01.jpg");
        ListData data2 = new ListData("카멜레온", "피부색이 마음대로 변해", "icon02.png");
        ListData data3 = new ListData("타조", "얼굴작고 목길고 완전 예쁨", "icon01.jpg");
        ListData data4 = new ListData("카멜레온", "피부색이 마음대로 변해", "icon02.png");
        ListData data5 = new ListData("타조", "얼굴작고 목길고 완전 예쁨", "icon01.jpg");
        ListData data6 = new ListData("카멜레온", "피부색이 마음대로 변해", "icon02.png");
        ListData data7 = new ListData("타조", "얼굴작고 목길고 완전 예쁨", "icon01.jpg");
        ListData data8 = new ListData("카멜레온", "피부색이 마음대로 변해", "icon02.png");

        listDataArrayList.add(data1);
        listDataArrayList.add(data2);
        listDataArrayList.add(data3);
        listDataArrayList.add(data4);
        listDataArrayList.add(data5);
        listDataArrayList.add(data6);
        listDataArrayList.add(data7);
        listDataArrayList.add(data8);

        ListView listView = (ListView)findViewById(R.id.listView);
        ProductAdapter adapter = new ProductAdapter(this,R.layout.view_product_list,listDataArrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1 :
                Intent intent1 = new Intent(this, FormActivity.class);
                startActivity(intent1);
                break;
            case R.id.button2 :
                Intent intent2 = new Intent(this, FormActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent3 = new Intent(this, ShowActivity.class);
        startActivity(intent3);
//        Log.i("TEXT", position + "번 리스트 선택됨");
//        Log.i("TEST", "리스트 내용 "+listDataArray.get(position).getText1());
    }
}
