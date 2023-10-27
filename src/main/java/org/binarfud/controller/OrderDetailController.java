package org.binarfud.controller;

import org.binarfud.dto.OrderDetailEntityDTO;
import org.binarfud.entity.OrderDetail;
import org.binarfud.service.impl.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {

    @Autowired
    private OrderImpl orderImpl;


    @GetMapping({"", "/"})
    public Page<OrderDetail> getOrderDetail(){
        Pageable pageable = PageRequest.of(0, 100);
        return orderImpl.findAllOrderDetail(pageable);
    }

    @PostMapping({"", "/"})
    public Map addOrderDetail(@RequestBody OrderDetailEntityDTO orderDetail){

        return orderImpl.saveOrderDetail(orderDetail);
    }

    @GetMapping({"{id}", "{id}/"})
    public Map findOrderDetail(@PathVariable UUID id){
        return orderImpl.findByIdOrderDetail(id);
    }

    @PutMapping({"{id}", "{id}/"})
    public Map updateOrderDetail(@PathVariable UUID id, @RequestBody OrderDetailEntityDTO orderDetail){
        return orderImpl.updateOrderDetail(id, orderDetail);
    }
}
