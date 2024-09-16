package org.example.ordermangementsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Orders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String customerName;
    private Double orderTotal;
}
