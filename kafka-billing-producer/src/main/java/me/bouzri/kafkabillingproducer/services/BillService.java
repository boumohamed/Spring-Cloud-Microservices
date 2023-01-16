package me.bouzri.kafkabillingproducer.services;

import lombok.AllArgsConstructor;
import me.bouzri.kafkabillingproducer.entities.Bill;
import me.bouzri.kafkabillingproducer.entities.ProductItem;
import me.bouzri.kafkabillingproducer.feign.CustomerRestClient;
import me.bouzri.kafkabillingproducer.feign.ProductItemRestClient;
import me.bouzri.kafkabillingproducer.models.Customer;
import me.bouzri.kafkabillingproducer.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

@Service
public class BillService {


    @Bean
    public Supplier<Bill> BillSupplier()
    {
        Bill bill = new Bill(null, new Date(), 1L, null, null);
        return () ->  bill;
    }




}
