package com.example.igyeonglyun.day02_project1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.igyeonglyun.day02_project1.ListData;
import com.example.igyeonglyun.day02_project1.R;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by igyeonglyun on 2015. 6. 21..
 */
public class CustomAdapter extends ArrayAdapter<ListData> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<ListData> listDatas;

    public CustomAdapter(Context context, int layoutResourceId, ArrayList<ListData> listDatas) {
        super(context, layoutResourceId, listDatas);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.listDatas = listDatas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
        }
        TextView textView1 = (TextView) row.findViewById(R.id.title1);
        TextView textView2 = (TextView) row.findViewById(R.id.content1);

        textView1.setText(listDatas.get(position).getText1());
        textView2.setText(listDatas.get(position).getText2());

        ImageView imageView = (ImageView) row.findViewById(R.id.image1);
//        이미지를 읽어와 리스트에 표시하기 위해, assets폴더에 사진을 넣어두고 불러옴
        try {
            InputStream is = context.getAssets().open(listDatas.get(position).getImgName());
            Drawable d = Drawable.createFromStream(is, null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            Log.e("ERROR", "ERROR: "+e);
        }
        return row;
    }

}
