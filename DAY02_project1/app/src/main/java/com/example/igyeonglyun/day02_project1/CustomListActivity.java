package com.example.igyeonglyun.day02_project1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class CustomListActivity extends Activity implements AdapterView.OnItemClickListener{

    private ArrayList<ListData> listDataArray = new ArrayList<ListData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        ListData data1 = new ListData("김쩡 교수님", "ios 모바일 전공", "01.jpg");
        ListData data2 = new ListData("9sm 교수님", "까꿍 전공", "02.jpg");
        ListData data3 = new ListData("오동우 교수님", "미술 전공", "03.jpg");
        ListData data4 = new ListData("크롱 교수님", "UI 전공", "05.jpg");

        listDataArray.add(data1);
        listDataArray.add(data2);
        listDataArray.add(data3);
        listDataArray.add(data4);

        ListView listView = (ListView)findViewById(R.id.listViewForCustom);
        CustomAdapter adapter = new CustomAdapter(this,R.layout.view_custom_list,listDataArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("TEXT", position+ "번 리스트 선택됨");
        Log.i("TEST", "리스트 내용 "+listDataArray.get(position).getText1());
    }
}
