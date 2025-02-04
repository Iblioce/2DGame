package Map;

public class Floor {
    private int height;
    private int width;

    public Floor(int height, int width) {
        this.height = height;
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
