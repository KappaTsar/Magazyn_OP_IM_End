package pl.edu.wszib.store.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "tproduct")
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int    id;
    private String name;
    private double price;
    private int    quan;

    public Product(int id, String name, double price, int quan) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quan = quan;
    }

    public Product() {
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id_s){
        this.id = id_s;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name_s){
        this.name = name_s;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price_s){
        this.price = price_s;
    }

    public int getQuan(){
        return this.quan;
    }

    public void setQuan(int quan_s){
        this.quan = quan_s;
    }

    public Product clone() {
        return new Product(this.id, this.name, this.price, this.quan);
    }

    @Override
    public String toString() {
        return "Productdaoimpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quan=" + quan +
                '}';
    }
}
