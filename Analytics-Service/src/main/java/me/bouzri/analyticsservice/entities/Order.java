package me.bouzri.analyticsservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.bouzri.analyticsservice.enums.OrderStatus;
import me.bouzri.analyticsservice.models.Customer;


import java.util.Collection;
import java.util.Date;


@AllArgsConstructor @NoArgsConstructor @Data

public class Order {

    private String id;
    private Date created;
    private String status;
    private Long customerId;
    private Customer customer;
    private Collection<ProductItem> products;

}
