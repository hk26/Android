package recycleview.developer.aero;

@SuppressWarnings("unused")
public class Item {
    private int id;
    private String name;
    private String description;
    private double price;
    private String thumbnail;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
