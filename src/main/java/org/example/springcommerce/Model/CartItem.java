package org.example.springcommerce.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "shoppingCartID")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    public CartItem(int quantity, ShoppingCart shoppingCart, Product product) {
        this.quantity = quantity;
        this.shoppingCart = shoppingCart;
        this.product = product;
    }
}
