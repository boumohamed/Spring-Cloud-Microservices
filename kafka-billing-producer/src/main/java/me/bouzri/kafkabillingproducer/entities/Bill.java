package me.bouzri.kafkabillingproducer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.bouzri.kafkabillingproducer.models.Customer;

import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class Bill {
    private Long id;
    private Date date;
    private Long customerId;
    private Collection<ProductItem> productItems;
    private Customer customer;

}
