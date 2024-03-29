package me.bouzri.analyticsservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.bouzri.analyticsservice.models.Product;


@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductItem {

    private Long id;
    private double quantity;
    private double price;
    private String productId;

    private Product product;

    private Order order;



}
