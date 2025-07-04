import java.time.LocalDate;

public class Product implements shippable{
    private String name;
    private double price;
    private int quantity;
    private double weight;
    protected boolean shipable;
    protected  boolean expirable;
    protected boolean expired;


    Product(){

    }
    Product(String name, double price, int quantity,double weight,boolean shipable,boolean expirable,boolean expired){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.shipable = shipable;
        this.expirable = expirable;
        this.expired = expired;
    }
    public double getPrice() {
            return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getWeight() {
        return weight;
    }



}

