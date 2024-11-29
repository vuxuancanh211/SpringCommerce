package org.example.springcommerce.Repository;

import org.example.springcommerce.Model.Order;
import org.example.springcommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);

}
