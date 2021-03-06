package com.example.igyeonglyun.day02_project2;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by igyeonglyun on 2015. 6. 22..
 */
public class ProductAdapter extends ArrayAdapter<ListData> {

    private Context context;
    private int layoutResourceId;
    private ArrayList<ListData> listDataArrayList;

    public ProductAdapter(Context context, int layoutResourceId, ArrayList<ListData> listDataArrayList) {
        super(context, layoutResourceId, listDataArrayList);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.listDataArrayList = listDataArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
        }
        TextView textView1 = (TextView) row.findViewById(R.id.pro_title);
        TextView textView2 = (TextView) row.findViewById(R.id.pro_content);

        textView1.setText(listDataArrayList.get(position).getText1());
        textView2.setText(listDataArrayList.get(position).getText2());

        ImageView imageView = (ImageView) row.findViewById(R.id.pro_img);
//        이미지를 읽어와 리스트에 표시하기 위해, assets폴더에 사진을 넣어두고 불러옴
        try {
            InputStream is = context.getAssets().open(listDataArrayList.get(position).getImgName());
            Drawable d = Drawable.createFromStream(is, null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            Log.e("ERROR", "ERROR: " + e);
        }
        return row;
    }
}
