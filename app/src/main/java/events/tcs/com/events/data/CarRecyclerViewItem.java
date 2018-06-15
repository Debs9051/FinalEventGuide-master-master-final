package events.tcs.com.events.data;

public class CarRecyclerViewItem {

    // Save car name.
    private String carName;

    // Save car image resource id.
    private int carImageId;
    private String imageName;

    public CarRecyclerViewItem(String carName, int carImageId) {
        this.carName = carName;
        this.carImageId = carImageId;

    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarImageId() {
        return carImageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setCarImageId(int carImageId) {
        this.carImageId = carImageId;
    }

}
