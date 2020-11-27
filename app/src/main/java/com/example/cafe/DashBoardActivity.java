package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private  StaticRvAdapter staticRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.egg, "Egg"));
        item.add(new StaticRvModel(R.drawable.burito, "Burito"));
        item.add(new StaticRvModel(R.drawable.sand_witch, "Sand witch"));
        item.add(new StaticRvModel(R.drawable.donut, "donut"));
        recyclerView = (findViewById(R.id.rv_1));
        staticRvAdapter = new StaticRvAdapter((item));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);
    }
}