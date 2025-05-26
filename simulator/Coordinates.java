package simulator;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
        System.out.println("Coordinates created:\n" + 
                "Longitude: " + this.longitude + "\n" +
                "Latitude: " + this.latitude + "\n" +
                "Height: " + this.height);
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

    public void setLongitude(int p_longitude) {
        this.longitude = p_longitude;
    }

    public void setLatitude(int p_latitude) {
        this.longitude = p_latitude;
    }

    public void setHeight(int p_height) {
        this.height = p_height;
    }
}