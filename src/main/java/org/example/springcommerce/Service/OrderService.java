package org.example.springcommerce.Service;

import org.example.springcommerce.Model.CartItem;
import org.example.springcommerce.Model.Order;
import org.example.springcommerce.Model.User;

import java.util.List;

public interface OrderService {
    List<CartItem> showOrderDetails(User user);

    Order getOrderById(Long id);
    Order addOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}
