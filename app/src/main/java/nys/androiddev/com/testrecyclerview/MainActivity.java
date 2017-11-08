package nys.androiddev.com.testrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nys.androiddev.com.testrecyclerview.views.FastScrollRecyclerView;

public class MainActivity extends AppCompatActivity {

    FastScrollRecyclerView recyclerView;
    LinearLayoutManager llm;
    OrderAdapter adapter;
    List<String> orderlist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < 1000; i++) {
            orderlist.add("List Item " + i);
        }

        adapter = new OrderAdapter(this,orderlist);
        recyclerView = (FastScrollRecyclerView) findViewById(R.id.recyclerview);
        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

    }
}
