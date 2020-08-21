package uz.pdp.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Address;
import uz.pdp.ecommerce.entity.Order;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.entity.enums.OrderType;
import uz.pdp.ecommerce.exceptions.Forbidden;
import uz.pdp.ecommerce.exceptions.NotFoundException;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.OrderDto;
import uz.pdp.ecommerce.repository.AddressRepository;
import uz.pdp.ecommerce.repository.OrderRepository;
import uz.pdp.ecommerce.repository.ProductRepository;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Page<Order> getOrders(Integer page, UUID id) {
        return orderRepository.findByCreatedBy(id, PageRequest.of(page, 5));
    }

    public ApiResponse add(OrderDto orderDto) {
        Product product = productRepository.findById(orderDto.getProductId())
                .orElseThrow(() -> new NotFoundException("Mahuslot topilmadi."));
        Address address = addressRepository.findById(orderDto.getAddressId())
                .orElseThrow(() -> new NotFoundException("Bunday Address mavjud emas"));

        Order order = new Order(product,
                orderDto.getAmount(),
                OrderType.NEW,
                false,
                address);
        orderRepository.save(order);
        return new ApiResponse("Mahsulot buyurtma berildi.", 201);


    }

    public ApiResponse update(UUID id, OrderDto orderDto, UUID userId) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bunday buyurtma topilmadi"));
        if (!order.getCreatedBy().equals(userId)) {
            throw new Forbidden("Sizda bunday imkoniya mavjud emas.");
        }
        order.setOrderType(orderDto.getOrderType());
        order.setConsumerSeen(true);
        orderRepository.save(order);
        return new ApiResponse("Buyurtma holati o`zgartirildi.", 200);
    }

    public Order getOne(UUID id, UUID userId) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Bunday buyurtma topiladi."));
        if (order.getProduct().getCreatedBy().equals(userId)) {
            order.setConsumerSeen(true);
        }
        orderRepository.save(order);
        return order;
    }

    public Page<Order> sellerOrders(UUID id, Integer page) {
        return orderRepository.findByProductCreatedByOrderByCreatedAt(id, PageRequest.of(page, 10));

    }
}
