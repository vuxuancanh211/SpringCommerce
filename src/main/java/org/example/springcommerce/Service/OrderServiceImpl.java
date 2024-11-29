package org.example.springcommerce.Service;

import org.example.springcommerce.Model.*;
import org.example.springcommerce.Repository.OrderRepository;
import org.example.springcommerce.Repository.ShoppingCartRepository;
import org.example.springcommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private UserRepository userRepository;

//    public void placeOrder(User user) {
//        LocalDateTime now = LocalDateTime.now();
//        Order order = new Order();
//        order.setUser(user);
//        order.setOrderDate(now);
//        order = orderRepository.save(order);
//
//        ShoppingCart cart = cartService.getCart(user);
//        List<CartItem> cartItems = cart.getCartItems();
//        OrderDetail orderDetail = new OrderDetail();
//        for (CartItem cartItem : cartItems) {
//            orderDetail.setOrder(order);
//            orderDetail.setProduct(cartItem.getProduct());
//            orderDetail.setQuantity(cartItem.getQuantity());
//            orderDetail.setPrice(cartItem.getProduct().getPrice());
//            order.getOrderDetails().add(orderDetail);
//        }
//        orderRepository.save(order);
//        cartItems.clear();
//        shoppingCartRepository.save(cart);
//    }

    public String placeOrder(User user) {
        LocalDateTime now = LocalDateTime.now();

        ShoppingCart cart = cartService.getCart(user);
        List<CartItem> cartItems = cart.getCartItems();

        if (cartItems.size() == 0) {
            return "Not enough stock";
        }

        for (CartItem cartItem : cartItems) {
            int quantity = cartItem.getQuantity();
            int stock = cartItem.getProduct().getStock();

            if (quantity > stock) {
                return "Not enough stock";
            }
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(now);
        order = orderRepository.save(order);

        OrderDetail orderDetail = new OrderDetail();
        for (CartItem cartItem : cartItems) {
            orderDetail.setOrder(order);
            orderDetail.setProduct(cartItem.getProduct());
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetail.setPrice(cartItem.getProduct().getPrice());
            order.getOrderDetails().add(orderDetail);

            // Cập nhật lại tồn kho
            int updatedStock = cartItem.getProduct().getStock() - cartItem.getQuantity();
            cartItem.getProduct().setStock(updatedStock);
        }
        orderRepository.save(order);
        cartItems.clear();
        shoppingCartRepository.save(cart);
        return "Order placed successfully!";
    }

    public List<Order> getOrders(User user) {
        return orderRepository.findByUser(user);
    }

    public List<CartItem> showOrderDetails(User user) {
        return cartService.showCartItem(user);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        if (!orderRepository.existsById(id)) {
            return null;
        }
        order.setId(id);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
