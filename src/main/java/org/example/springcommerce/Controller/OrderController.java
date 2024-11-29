package org.example.springcommerce.Controller;

import org.example.springcommerce.Model.*;
import org.example.springcommerce.Repository.ShoppingCartRepository;
import org.example.springcommerce.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @GetMapping("/order")
    public String showOrder(Model model) {
        User_Detail user = (User_Detail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CartItem> orderDetails = orderService.showOrderDetails(user.getUser());
        double totalPrice = cartService.getTotalPrice(user.getUser());
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("totalPrice", String.format("%.2f", totalPrice));
        model.addAttribute("user", user.getUser());
        return "check-out";
    }

    @PostMapping("/order/place")
    public String placeOrder(Model model) {
        User_Detail user = (User_Detail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String message = orderService.placeOrder(user.getUser());
        if(message.equals("Not enough stock")) {
            return "redirect:/order";
        }
        List<Order> orders = orderService.getOrders(user.getUser());
        model.addAttribute("orders", orders);
        return "order-history";
    }

    @GetMapping("/order/history")
    public String showOrderHistory(Model model) {
        User_Detail user = (User_Detail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Order> orders = orderService.getOrders(user.getUser());
        model.addAttribute("orders", orders);
        return "order-history";
    }

    @GetMapping("/order/clear")
    public String clearOrder(Model model) {
        User_Detail user = (User_Detail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ShoppingCart cart = cartService.getCart(user.getUser());
        List<CartItem> cartItems = cart.getCartItems();
        cartItems.clear();
        shoppingCartRepository.save(cart);
        return "redirect:/cart";
    }

}
