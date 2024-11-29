package org.example.springcommerce.RESTfulAPIS;

import org.example.springcommerce.Model.Order;
import org.example.springcommerce.Model.OrderDetail;
import org.example.springcommerce.Service.OrderService;
import org.example.springcommerce.Service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Lấy chi tiết đơn hàng theo ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Order order = orderService.getOrderById(id);
//        List<OrderDetail> orders = order.getOrderDetails();
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(order);
    }

    // Tạo mới một đơn hàng (POST)
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

    // Cập nhật đơn hàng (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        if (id <= 0 || order == null) {
            return ResponseEntity.badRequest().build();
        }
        Order updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedOrder);
    }

    // Xóa đơn hàng (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().body("ID không hợp lệ.");
        }
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy đơn hàng với ID: " + id);
        }
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Đã xóa thành công đơn hàng với ID: " + id);
    }
}
