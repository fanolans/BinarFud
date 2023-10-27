package org.binarfud.util;

import org.binarfud.entity.*;
import org.binarfud.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class DataInitialization {

    @Autowired
    MerchantRepository merchantRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init(){
        insertMerchantData();
        insertUserData();
        insertProductData();
        insertOrderData();
        insertOrderDetailData();
        log.info("Insert Data to Database");
    }

    public void insertMerchantData(){
        Merchant merchant1 = new Merchant();
        merchant1.setMerchant_name("Merchant_1");
        merchant1.setMerchant_location("Purwokerto");
        merchant1.setOpen(true);
        merchantRepository.save(merchant1);
        Merchant merchant2 = new Merchant();
        merchant2.setMerchant_name("Merchant_2");
        merchant2.setMerchant_location("Yogyakarta");
        merchant2.setOpen(false);
        merchantRepository.save(merchant2);
        Merchant merchant3 = new Merchant();
        merchant3.setMerchant_name("Merchant_3");
        merchant3.setMerchant_location("Bandung");
        merchant3.setOpen(true);
        merchantRepository.save(merchant3);
    }

    public void insertUserData(){
        User user1 = new User();
        user1.setUsername("user1");
        user1.setEmail_address("user1@gmail.com");
        user1.setPassword("123456");
        userRepository.save(user1);
        User user2 = new User();
        user2.setUsername("user2");
        user2.setEmail_address("user2@gmail.com");
        user2.setPassword("123456");
        userRepository.save(user2);
        User user3 = new User();
        user3.setUsername("user3");
        user3.setEmail_address("user3@gmail.com");
        user3.setPassword("123456");
        userRepository.save(user3);
    }

    public void insertProductData(){
        List<Merchant> merchantData = merchantRepository.findAll();

        Product product1 = new Product();
        product1.setProduct_name("Product_1");
        product1.setPrice(1000);
        product1.setAvailable(false);
        product1.setMerchant(merchantData.get(0));
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProduct_name("Product_1");
        product2.setPrice(2000);
        product2.setMerchant(merchantData.get(1));
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setProduct_name("Product_1");
        product3.setPrice(3000);
        product3.setMerchant(merchantData.get(2));
        productRepository.save(product3);
    }

    public void insertOrderData(){
        Date date = new Date();

        List<User> userData = userRepository.findAll();

        Order order1 = new Order();
        order1.setOrder_time(date);
        order1.setDestination_address("Purwokerto");
        order1.setCompleted(false);
        order1.setUser(userData.get(0));
        orderRepository.save(order1);

        Order order2 = new Order();
        order2.setOrder_time(date);
        order2.setDestination_address("Yogyakarta");
        order2.setCompleted(true);
        order2.setUser(userData.get(1));
        orderRepository.save(order2);

        Order order3 = new Order();
        order3.setOrder_time(date);
        order3.setDestination_address("Bandung");
        order3.setCompleted(false);
        order3.setUser(userData.get(2));
        orderRepository.save(order3);
    }

    public void insertOrderDetailData(){
        List<Order> orderData = orderRepository.findAll();
        List<Product> productData = productRepository.findAll();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setQuantity(4);
        orderDetail1.setTotal_price(21000);
        orderDetail1.setOrder(orderData.get(0));
        orderDetail1.setProduct(productData.get(0));
        orderDetailRepository.save(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setQuantity(2);
        orderDetail2.setTotal_price(34000);
        orderDetail2.setOrder(orderData.get(1));
        orderDetail2.setProduct(productData.get(1));
        orderDetailRepository.save(orderDetail2);

        OrderDetail orderDetail3 = new OrderDetail();
        orderDetail3.setQuantity(1);
        orderDetail3.setTotal_price(7000);
        orderDetail3.setOrder(orderData.get(2));
        orderDetail3.setProduct(productData.get(2));
        orderDetailRepository.save(orderDetail3);

        OrderDetail orderDetail4 = new OrderDetail();
        orderDetail4.setQuantity(6);
        orderDetail4.setTotal_price(98000);
        orderDetail4.setOrder(orderData.get(3));
        orderDetail4.setProduct(productData.get(3));
        orderDetailRepository.save(orderDetail4);
    }

}
