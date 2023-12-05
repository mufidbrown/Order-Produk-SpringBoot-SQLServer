package restorder.orderproduk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "products")
//@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Integer quantity;
    private double price;
    private String description;



    public Product(long l, String piano, int i, double v, String bagus) {
    }

    public Product() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }

    public String getDescription(){
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
