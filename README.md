### RecyclerView 基本使用示例

#### 数据模型

```java
public class Fruit {

    /**
     * 水果名称
     */
    private String fruitName;

    /**
     * 图片资源id
     */
    private int imageId;

    public Fruit(String fruitName, int imageId) {
        this.fruitName = fruitName;
        this.imageId = imageId;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getImageId() {
        return imageId;
    }
}
```

#### item 布局

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    tools:ignore="UseCompoundDrawables">

    <ImageView
        android:id="@+id/iv_fruit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_launcher"
        android:contentDescription="@string/str_fruit_image" />

    <TextView
        android:id="@+id/tv_fruit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_vertical"
        android:hint="@string/app_name"
        android:layout_marginStart="@dimen/dp_10"/>

</LinearLayout>
```

#### Adapter 与 ViewHolder

```java
/**
 * @author wbkearly
 *
 * 水果RecyclerView适配器
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    /**
     * 数据集合
     */
    private final List<Fruit> mFruits;

    public FruitAdapter(List<Fruit> fruits) {
        mFruits = fruits;
    }

    /**
     * 创建ViewHolder
     * @param parent 父布局
     * @param viewType 每个item类型 多类型view会使用到
     */
    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_fruit_item, parent, false);
        return new FruitViewHolder(view);
    }

    /**
     * 绑定ViewHolder
     * @param holder 每个item对应的holder
     * @param position 每个item对应的位置
     */
    @Override
    public void onBindViewHolder(FruitAdapter.FruitViewHolder holder, int position) {
        Fruit fruit = mFruits.get(position);
        holder.fruitName.setText(fruit.getFruitName());
        holder.fruitImage.setImageResource(fruit.getImageId());
    }

    /**
     * item 条数
     */
    @Override
    public int getItemCount() {
        return mFruits.size();
    }

    /**
     * 每个item对应的viewHolder
     */
    static class FruitViewHolder extends RecyclerView.ViewHolder {

        private final ImageView fruitImage;
        private final TextView fruitName;

        public FruitViewHolder(View itemView) {
            super(itemView);
            this.fruitImage = itemView.findViewById(R.id.iv_fruit);
            this.fruitName = itemView.findViewById(R.id.tv_fruit);
        }
    }

}
```

#### 使用方法

```java
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
```
