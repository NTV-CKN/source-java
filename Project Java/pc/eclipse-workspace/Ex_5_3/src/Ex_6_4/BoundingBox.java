package Ex_6_4;
/**
 * trong BoudingBox co 4 thuoc tinh va cac method goi ra gia tri va thay doi gia tri
    private int minX; // toa do nho x
    private int minY; // toa do nho y
    private int maxX; // toa do lon x
    private int maxY; // toa do lon y
    
 */
public class BoundingBox {
    private int minX; // toa do nho x
    private int minY; // toa do nho y
    private int maxX; // toa do lon x
    private int maxY; // toa do lon y


    @Override
	public String toString() {
		return "BoundingBox [minX=" + minX + ", minY=" + minY + ", maxX=" + maxX + ", maxY=" + maxY + "]";
	}

	// Constructor
    public BoundingBox(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    // Getters and Setters
    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
}
