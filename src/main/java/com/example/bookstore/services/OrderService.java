package com.example.bookstore.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookstore.model.Order;
import com.example.bookstore.repository.OrderRepository;
@Service
public class OrderService {
private final OrderRepository orderRepository;
@Autowired
public OrderService(OrderRepository orderRepository) {
this.orderRepository = orderRepository;
}
public Order createOrder(Order order) {
return orderRepository.save(order);
}
public Order getOrder(Long orderId) {
return orderRepository.findById(orderId).orElse(null);
}
public Optional<Order> getOrdersById(Long customerId) {
return orderRepository.findById(customerId);
}
public void deleteOrder(Long orderId) {
orderRepository.deleteById(orderId);
}
public List<Order> getAllOrders() {
return orderRepository.findAll();
}
public Order addOrder(Order order) {
return orderRepository.save(order);
}
public Order getOrderById(Long id) {
return orderRepository.findById(id).orElse(null);
}
public Order updateOrder(Long id, javax.persistence.criteria.Order order) {
Optional<Order> optionalOrder = orderRepository.findById(id);
if (optionalOrder.isPresent()) {
Order existingOrder = optionalOrder.get();
existingOrder.setCustomerId(order.getCustomerId());
existingOrder.setOrder(order.getOrder());
existingOrder.setTotalPrice(order.getTotalPrice());
return orderRepository.save(existingOrder);
}
return null;
}
}
