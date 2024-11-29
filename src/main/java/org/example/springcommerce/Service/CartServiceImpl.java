package org.example.springcommerce.Service;

import org.example.springcommerce.Model.CartItem;
import org.example.springcommerce.Model.Product;
import org.example.springcommerce.Model.ShoppingCart;
import org.example.springcommerce.Model.User;
import org.example.springcommerce.Repository.CartItemRepository;
import org.example.springcommerce.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductService productService;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    public ShoppingCart getCart(User user) {
        return shoppingCartRepository.findByUser(user)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return shoppingCartRepository.save(cart);
                });
    }

    @Override
    public void addItemToCart(User user, Long productId, int quantity) {
        ShoppingCart cart = getCart(user);
        CartItem item = null;
        for (CartItem cartItem : cart.getCartItems()) {
            if(cartItem.getProduct().getId() == productId) {
                item = cartItem;
                break;
            }
        }
        if(item == null) {
            Product product = productService.getProduct(productId);
            item = new CartItem(quantity, cart, product);
            cart.getCartItems().add(item);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
        shoppingCartRepository.save(cart);
    }

    @Override
    public List<CartItem> showCartItem(User user) {
        ShoppingCart cart = getCart(user);
        if (cart == null) {
            cart = new ShoppingCart(user);
        }
        return cart.getCartItems();
    }

    public void removeItemFromCart(User user, Long itemId) {
        ShoppingCart cart = getCart(user);
        CartItem itemRemove = null;
        for (CartItem cartItem : cart.getCartItems()) {
            if(cartItem.getId() == itemId) {
                itemRemove = cartItem;
                break;
            }
        }
        if(itemRemove != null) {
            cart.getCartItems().remove(itemRemove);
            shoppingCartRepository.save(cart);
        }
    }

    @Override
    public double getTotalPrice(User user) {
        ShoppingCart cart = getCart(user);
        List<CartItem> cartItems = cart.getCartItems();
        double totalPrice = 0;
        for (CartItem cartItem : cartItems) {
            totalPrice += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }

    public CartItem getItemById(Long itemId) {
        return cartItemRepository.findById(itemId).orElse(null);
    }

    public void saveItem(CartItem item) {
        cartItemRepository.save(item);
    }

    public void updateCartItem(User user, Long itemId, Integer quantity) {
        ShoppingCart cart = getCart(user);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            if(cartItem.getId() == itemId) {
                cartItem.setQuantity(quantity);
            }
        }
        shoppingCartRepository.save(cart);
    }
}
