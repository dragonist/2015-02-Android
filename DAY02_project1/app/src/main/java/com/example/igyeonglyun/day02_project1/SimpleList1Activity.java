package com.example.igyeonglyun.day02_project1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class SimpleList1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list1);
        ListView listView = (ListView) findViewById(R.id.simple_List1_listView);
        List<String> dataList = Arrays.asList(
                "data1",
                "data2",
                "data3",
                "data4",
                "data5",
                "data6",
                "data7"
        );
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
//        Bundle bundle = getIntent().getExtras();
//        int key = bundle.getInt("key");
//        String id = bundle.getString("id");
//        String pw = bundle.getString("pw");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_list1, menu);
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
