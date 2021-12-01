package com.training.orderservice.service;

import com.training.orderservice.dao.OrderDao;
import com.training.orderservice.entity.Customer;
import com.training.orderservice.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderDao dao;

    @Value("${microservices.url.customer-service}")
    private String customerServiceUrl;


    public Order getOrderById(Integer id)
    {
        Optional<Order> op = dao.findById(id);

        if(op.isPresent())
        {
            Order order = op.get();

            try {



                // visit customer service and get customer details
                String url = customerServiceUrl + order.getCustomerId();
                log.debug("Visiting the customer service url:  " + url);

                RestTemplate rt = new RestTemplate();
                Customer cust = rt.getForObject(url, Customer.class);
                order.setCustomer(cust);

            } catch (Exception e) {
                log.error("There was an exception "+e);
            }


            return order;

        }
        throw new RuntimeException("No order found for id " + id);
    }
}
