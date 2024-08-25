package org.example.javeeepos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDto {
    private String orderId;
    private String cusId;
    private String proId;
    private double qty;
    private double price;
}
