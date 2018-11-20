package com.pmcc.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.pmcc.customview.widget.WidgetActivity;

public class MainActivity extends AppCompatActivity {

    private ListView mainlv;
    private String[] itemNames = {"自定义宽高比view","输入金钱editext","带删除的editext","添加html样式"};
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainlv = findViewById(R.id.main_lv);
        mainlv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames));
        mainlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startNext(i);
            }
        });

    }

    private void startNext(int i) {
        intent = new Intent(this, WidgetActivity.class);
        intent.putExtra("type", i);
        startActivity(intent);
//        switch (i) {
//            case 0:
//                intent.putExtra("type", i);
//                startActivity(intent);
//                break;
//            case 1:
//                intent.putExtra("type", i);
//                startActivity(intent);
//                break;
//        }
    }
}
