package events.tcs.com.events.data;

/**
 * Created by arun on 6/6/2018.
 */

public class Card {
    private String heading;
    private String headingDesc;
    private String timming;
    private String owner;
    private Double Latitude, Longitude;

    public Card() {
        this.heading = "";
        this.headingDesc = "";
        this.timming = "";
        this.owner = "";
        Latitude = 0.0;
        Longitude = 0.0;
        this.isTravel = false;
    }
    public Card(String heading, String headingDesc, String timming, String owner, Double latitude, Double longitude, boolean isTravel) {
        this.heading = heading;
        this.headingDesc = headingDesc;
        this.timming = timming;
        this.owner = owner;
        Latitude = latitude;
        Longitude = longitude;
        this.isTravel = isTravel;
    }

    public String getHeading() {

        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getHeadingDesc() {
        return headingDesc;
    }

    public void setHeadingDesc(String headingDesc) {
        this.headingDesc = headingDesc;
    }

    public String getTimming() {
        return timming;
    }

    public void setTimming(String timming) {
        this.timming = timming;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public boolean isTravel() {
        return isTravel;
    }

    public void setTravel(boolean travel) {
        isTravel = travel;
    }

    private boolean isTravel;

}
