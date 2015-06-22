package com.example.igyeonglyun.day02_project1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SimpleList2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list2);

        ListView listView = (ListView) findViewById(R.id.simple_List2_listView);
        List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>(2);
        for(int i=0; i<10; i++){
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("line1", "첫번째줄"+i+"!");
            hashMap.put("line2", "두번째줄"+i+"...");
            dataList.add(hashMap);
        }
        String[] from = {"line1", "line2"};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(this,dataList, android.R.layout.simple_list_item_2, from, to);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_list2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
