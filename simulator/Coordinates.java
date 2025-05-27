package simulator;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
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
        // normalize the longitude to be within -180 to 180
        p_longitude = ((p_longitude + 180) % 360 + 360) % 360 - 180;
        this.longitude = p_longitude;
    }

    public void setLatitude(int p_latitude) {
        // normalize the latitude to be within -90 to 90
        if (p_latitude < -90) {
            p_latitude = -90;
        } else if (p_latitude > 90) {
            p_latitude = 90;
        }
        this.longitude = p_latitude;
    }

    public void setHeight(int p_height) {
        this.height = p_height;
    }
}