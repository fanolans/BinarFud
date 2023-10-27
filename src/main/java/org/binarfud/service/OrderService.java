package org.binarfud.service;

import org.binarfud.dto.OrderDetailEntityDTO;
import org.binarfud.dto.OrderEntityDTO;
import org.binarfud.entity.Order;
import org.binarfud.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface OrderService {

    Page<Order> findAll(Pageable pageable);
    Map findById(UUID id);
    Map save(OrderEntityDTO orderDetail);
    Map update(UUID id, OrderEntityDTO orderDetail);

    Page<OrderDetail> findAllOrderDetail(Pageable pageable);

    Map findByIdOrderDetail(UUID id);

    Map saveOrderDetail(OrderDetailEntityDTO orderDetail);

    Map updateOrderDetail(UUID id, OrderDetailEntityDTO orderDetail);
}
