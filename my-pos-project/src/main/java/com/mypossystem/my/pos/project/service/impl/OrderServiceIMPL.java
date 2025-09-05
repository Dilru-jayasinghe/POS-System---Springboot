package com.mypossystem.my.pos.project.service.impl;

import com.mypossystem.my.pos.project.dto.OrderItemDTO;
import com.mypossystem.my.pos.project.dto.request.OrderRequestDTO;
import com.mypossystem.my.pos.project.dto.response.OrderResponseDTO;
import com.mypossystem.my.pos.project.entity.Customer;
import com.mypossystem.my.pos.project.entity.Item;
import com.mypossystem.my.pos.project.entity.OrderItem;
import com.mypossystem.my.pos.project.entity.enums.OrderStatus;
import com.mypossystem.my.pos.project.repo.CustomerRepo;
import com.mypossystem.my.pos.project.repo.ItemRepo;
import com.mypossystem.my.pos.project.repo.OrderRepo;
import com.mypossystem.my.pos.project.service.OrderService;
import com.mypossystem.my.pos.project.util.mappers.OrderMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.mypossystem.my.pos.project.entity.Order;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override

    public OrderResponseDTO createOrder(OrderRequestDTO request) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        if (request.getCustomerId() != null) {
            Customer customer = customerRepo.findById(request.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            order.setCustomer(customer);
        }

        double totalAmount = 0;

        for (OrderItemDTO itemDTO : request.getItems()) {
            Item item = itemRepo.findById(itemDTO.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setPrice(item.getSellingPrice());
            orderItem.setSubTotal(item.getSellingPrice() * itemDTO.getQuantity());

            order.addOrderItem(orderItem);

            totalAmount += orderItem.getSubTotal();
        }

        order.setTotalAmount(totalAmount);

        Order savedOrder = orderRepo.save(order);

        return orderMapper.orderToOrderResponseDTO(savedOrder);
    }

    @Override
    public OrderResponseDTO getOrderById(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));
        return orderMapper.toOrderResponseDTO(order);
    }
}
