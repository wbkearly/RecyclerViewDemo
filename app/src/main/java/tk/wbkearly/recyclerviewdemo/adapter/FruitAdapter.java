package tk.wbkearly.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tk.wbkearly.recyclerviewdemo.R;
import tk.wbkearly.recyclerviewdemo.model.Fruit;

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
