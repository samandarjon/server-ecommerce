package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.entity.Order;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.OrderDto;
import uz.pdp.ecommerce.security.CurrentUser;
import uz.pdp.ecommerce.service.OrderService;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getUserOrders(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @CurrentUser User user) {
        Page<Order> orders = orderService.getOrders(page, user.getId());

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneOrder(@PathVariable UUID id, @CurrentUser User user) {
        Order one = orderService.getOne(id, user.getId());
        return ResponseEntity.ok(one);
    }

    @GetMapping("/seller")
    public ResponseEntity<?> getSellerOrder(@CurrentUser User user,
                                            @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Page<Order> orders = orderService.sellerOrders(user.getId(), page);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateOrderFormConsumer(@PathVariable UUID id,
                                                      @RequestBody OrderDto orderDto,
                                                      @CurrentUser User user) {
        ApiResponse update = orderService.update(id, orderDto, user.getId());

        return ResponseEntity.ok(update);
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto) {
        ApiResponse add = orderService.add(orderDto);
        return ResponseEntity.status(add.getStatus()).body(add);
    }


}
