package me.bouzri.kafkabillingproducer.entities;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import me.bouzri.kafkabillingproducer.enums.OrderStatus;
import me.bouzri.kafkabillingproducer.models.Customer;

import java.util.Collection;
import java.util.Date;


@AllArgsConstructor @NoArgsConstructor @Data

public class Order {

    private String id;
    private Date created;
    private OrderStatus status;
    private Long customerId;
    private Customer customer;
    private Collection<ProductItem> products;

    /*
    public double getTotal()
    {
        double sum = 0;
        for (ProductItem p : products)
        {
            sum += p.getAmount();
        }
        return sum;
    }

     */
}
