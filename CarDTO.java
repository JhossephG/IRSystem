public class CarDTO {

private int manufactureYear, saleValue, purchaseValue, key;
private String model, brand, chassis;
private boolean inStore;

public CarDTO(int manufactureYear, int saleValue, int purchaseValue, String model, String brand) {
    this.manufactureYear = manufactureYear;
    this.saleValue = saleValue;
    this.purchaseValue = purchaseValue;
    this.model = model;
    this.brand = brand;
}

public int getManufactureYear() {
    return manufactureYear;
}

public void setManufactureYear(int manufactureYear) {
    this.manufactureYear = manufactureYear;
}

public int getSaleValue() {
    return saleValue;
}

public void setSaleValue(int saleValue) {
    this.saleValue = saleValue;
}

public int getPurchaseValue() {
    return purchaseValue;
}

public void setPurchaseValue(int purchaseValue) {
    this.purchaseValue = purchaseValue;
}

public String getModel() {
    return model;
}

public void setModel(String model) {
    this.model = model;
}

public String getBrand() {
    return brand;
}

public void setBrand(String brand) {
    this.brand = brand;
}

public String getChassis() {
    return chassis;
}

public void setChassis(String chassis) {
    this.chassis = chassis;
}

public boolean isInStore() {
    return inStore;
}

public void setInStore(boolean inStore) {
    this.inStore = inStore;
}



}
