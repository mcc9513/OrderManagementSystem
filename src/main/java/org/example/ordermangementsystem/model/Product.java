package org.example.ordermangementsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private Double productPrice;
    private Integer productQuantity;
}
