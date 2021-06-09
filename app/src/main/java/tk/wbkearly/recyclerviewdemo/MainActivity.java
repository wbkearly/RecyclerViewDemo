package tk.wbkearly.recyclerviewdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tk.wbkearly.recyclerviewdemo.adapter.FruitAdapter;
import tk.wbkearly.recyclerviewdemo.model.Fruit;

/**
 * @author wbkearly
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private final List<Fruit> mFruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        // add data to mFruits
        mFruits.add(new Fruit("苹果", R.drawable.apple));
        mFruits.add(new Fruit("梨子", R.drawable.pear));
        mFruits.add(new Fruit("梨子2", R.drawable.pear2));
        mFruits.add(new Fruit("其他", R.drawable.other));
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        // 使用RecyclerView 必须设置LayoutManager、Adapter
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 垂直方向分割，设置水平分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new FruitAdapter(mFruits));
    }
}