package com.example.igyeonglyun.day02_project2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class FormActivity extends Activity implements View.OnClickListener{

    private Button b_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        b_create = (Button)findViewById(R.id.button_create);
    }

    @Override
    public void onClick(View v) {

    }
}
