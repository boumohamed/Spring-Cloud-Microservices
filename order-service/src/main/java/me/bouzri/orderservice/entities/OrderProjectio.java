package me.bouzri.orderservice.entities;

import me.bouzri.orderservice.enums.OrderStatus;
import me.bouzri.orderservice.models.Customer;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Projection(types = Order.class, name = "full")
public interface OrderProjectio {
     String getId();
     Date getCreated();
     OrderStatus getStatus();
     Long getCustomerId();
     Customer getCustomer();
     Collection<ProductItem> getGroducts();
}

