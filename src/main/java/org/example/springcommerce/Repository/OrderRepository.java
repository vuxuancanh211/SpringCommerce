package org.example.springcommerce.Repository;

import org.example.springcommerce.Model.Order;
import org.example.springcommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
