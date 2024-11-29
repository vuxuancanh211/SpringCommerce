package org.example.springcommerce.Repository;

import org.example.springcommerce.Model.ShoppingCart;
import org.example.springcommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUser(User user);
}
