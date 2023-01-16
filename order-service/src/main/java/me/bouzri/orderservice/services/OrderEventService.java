package me.bouzri.orderservice.services;

import lombok.AllArgsConstructor;

import me.bouzri.orderservice.entities.Order;
import me.bouzri.orderservice.entities.ProductItem;
import me.bouzri.orderservice.enums.OrderStatus;
import me.bouzri.orderservice.feign.CustomerRestClientService;
import me.bouzri.orderservice.feign.ProductItemRestClient;
import me.bouzri.orderservice.models.Customer;
import me.bouzri.orderservice.models.Product;
import me.bouzri.orderservice.repositories.OrderRepository;
import me.bouzri.orderservice.repositories.ProductItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Consumer;


@Service
@AllArgsConstructor
public class OrderEventService {

    private OrderRepository or;
    private ProductItemRepository pir;
    private CustomerRestClientService crcs;
    private ProductItemRestClient pirc;
    @Bean
    public Consumer<Order> BillsEventConsumer()
    {
        return (input) -> {

            //List<Customer> customers = crcs.getCustomers().getContent().stream().toList();
            List<Product> products = pirc.pageProducts(0, 20).getContent().stream().toList();
            Random random = new Random();
            Order order = input;
            Customer customer = crcs.getCustomer(order.getCustomerId());
            order.setCustomer(customer);
            order.setId(UUID.randomUUID().toString());
            Order savedOrder = or.save(order);
            for (int j = 0; j < products.size(); j++)
            {
                if (Math.random() > 0.60)
                {
                    ProductItem productItem = ProductItem.builder()
                            .order(savedOrder)
                            .productId(products.get(j).getId())
                            .price(products.get(j).getPrice())
                            .quantity(random.nextInt(5) + 1)
                            .product(products.get(j))
                            .build();
                    pir.save(productItem);
                }
            }
            //System.out.println(savedOrder.toString());
        };
    }







}
