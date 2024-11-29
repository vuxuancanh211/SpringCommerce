package org.example.springcommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String color;
    private int stock;
    private double weight;
    private String size;
    private String description;
    private String imageUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "brandID")
    private Brand brand;

    public Product(String name, double price, Brand brand, String color, int stock, String imageUrl ,Category category) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.color = color;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public Product(String name, double price, Brand brand, String color, int stock, String imageUrl, Category category, double weight, String size, String description) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.stock = stock;
        this.weight = weight;
        this.size = size;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.brand = brand;
    }

    public Product(String name, double price, String color, int stock) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.stock = stock;
    }
}
