package com.example.igyeonglyun.day02_project2;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class ShowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView tvTitle = (TextView) findViewById(R.id.pro_title);
        TextView tvWriter = (TextView) findViewById(R.id.pro_writer);
        TextView tvContent = (TextView) findViewById(R.id.pro_content);
        TextView tvWriteDate = (TextView) findViewById(R.id.pro_date);
        ImageView ivImage = (ImageView) findViewById(R.id.pro_img);

        String articleNumber = getIntent().getExtras().getString("ArticleNumber");

        //dao 초기화
        Dao dao = new Dao(getApplicationContext());
        Article article = dao.getArticleByArticleNumber(Integer.parseInt(articleNumber));
        tvTitle.setText(article.getTitle());
        tvWriter.setText(article.getWriter());
        tvContent.setText(article.getContent());
        tvWriteDate.setText(article.getWriteDate());

        try{
            InputStream ims = getApplicationContext().getAssets().open(article.getImgName());
            Drawable d = Drawable.createFromStream(ims, null);
            ivImage.setImageDrawable(d);
        } catch (IOException e) {
            Log.e("test", "error: img stream");
        }

    }
}
