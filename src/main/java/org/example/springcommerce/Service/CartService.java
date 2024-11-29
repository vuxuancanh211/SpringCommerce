package org.example.springcommerce.Service;

import org.example.springcommerce.Model.CartItem;
import org.example.springcommerce.Model.ShoppingCart;
import org.example.springcommerce.Model.User;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.List;

public interface CartService {
    ShoppingCart getCart(User user);
    void addItemToCart(User user, Long productId, int quantity);
    List<CartItem> showCartItem(User user);
    void removeItemFromCart(User user, Long productId);
    double getTotalPrice(User user);
    CartItem getItemById(Long productId);
    void saveItem(CartItem item);
    void updateCartItem(User user, Long itemId, Integer quantity);
}
