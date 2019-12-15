package com.webkeyz.batchtwotraining.recyclerview_animation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mlsdev.animatedrv.AnimatedRecyclerView;
import com.webkeyz.batchtwotraining.R;

import java.util.ArrayList;
import java.util.List;

public class StaggeredRecyclerViewActivity extends AppCompatActivity {

    List<String> names = new ArrayList<>();
    List<Integer> images = new ArrayList<>();
    MyAdapter adapter;
    AnimatedRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_recycler_view);

        recyclerView = findViewById(R.id.recyclerView_animation_staggered);

        images.add(R.drawable.cat);
        images.add(R.drawable.hippo);
        images.add(R.drawable.koala);
        images.add(R.drawable.monkey);
        images.add(R.drawable.zepra);
        images.add(R.drawable.cat);
        images.add(R.drawable.hippo);
        images.add(R.drawable.koala);
        images.add(R.drawable.monkey);
        images.add(R.drawable.zepra);
        images.add(R.drawable.cat);
        images.add(R.drawable.hippo);
        images.add(R.drawable.koala);
        images.add(R.drawable.monkey);
        images.add(R.drawable.zepra);
        images.add(R.drawable.cat);
        images.add(R.drawable.hippo);
        images.add(R.drawable.koala);
        images.add(R.drawable.monkey);
        images.add(R.drawable.zepra);

        names.add("cat");
        names.add("hippo");
        names.add("koala");
        names.add("monkey");
        names.add("zebra");
        names.add("cat");
        names.add("hippo");
        names.add("koala");
        names.add("monkey");
        names.add("zebra");
        names.add("cat");
        names.add("hippo");
        names.add("koala");
        names.add("monkey");
        names.add("zebra");
        names.add("cat");
        names.add("hippo");
        names.add("koala");
        names.add("monkey");
        names.add("zebra");

        adapter = new MyAdapter(this,names,images);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();

    }
}
