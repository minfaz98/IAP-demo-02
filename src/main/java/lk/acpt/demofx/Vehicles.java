package lk.acpt.demofx;

public class Vehicles {
    private int id;
    private String brand;
    private int price;
    private String model;
    private int year;

    public Vehicles() {
    }

    public Vehicles(String brand, int id, String model, int price, int year) {
        this.brand = brand;
        this.id = id;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
