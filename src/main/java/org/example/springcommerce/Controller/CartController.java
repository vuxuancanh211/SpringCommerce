package org.example.springcommerce.Controller;

import org.example.springcommerce.Model.CartItem;
import org.example.springcommerce.Model.User;
import org.example.springcommerce.Model.User_Detail;
import org.example.springcommerce.Service.CartServiceImpl;
import org.example.springcommerce.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/cart")
    public String showCart(Model model) {
        User_Detail user = (User_Detail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CartItem> cartItems = cartService.showCartItem(user.getUser());
        double totalPrice = cartService.getTotalPrice(user.getUser());
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", String.format("%.2f", totalPrice));
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addCartItem(@RequestParam long productId, @RequestParam int quantity) {
        User_Detail user = (User_Detail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cartService.addItemToCart(user.getUser(), productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeCartItem(@RequestParam(value = "itemIdRemove") Long productId) {
        User_Detail user = (User_Detail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cartService.removeItemFromCart(user.getUser(), productId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateCartItem(@RequestParam(value = "itemIdUpdate", required = false) Long itemId,
                                 @RequestParam(value = "quantity", required = false) Integer quantity) {
        User_Detail user = (User_Detail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cartService.updateCartItem(user.getUser(), itemId, quantity);
        return "redirect:/cart";
    }
}
