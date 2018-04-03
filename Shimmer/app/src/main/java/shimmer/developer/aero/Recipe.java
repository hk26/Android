package shimmer.developer.aero;

@SuppressWarnings("unused")
public class Recipe {
    private int id;
    private String name;
    private String description;
    private double price;
    private String thumbnail;
    private String chef;
    private String timestamp;

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    double getPrice() {
        return price;
    }

    String getThumbnail() {
        return thumbnail;
    }

    String getChef() {
        return chef;
    }

    String getTimestamp() {
        return timestamp;
    }
}
