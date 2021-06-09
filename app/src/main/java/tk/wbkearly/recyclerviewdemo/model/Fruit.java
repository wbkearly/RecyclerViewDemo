package tk.wbkearly.recyclerviewdemo.model;

/**
 * @author wbkearly
 */
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
