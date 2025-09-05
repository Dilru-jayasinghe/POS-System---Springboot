package com.mypossystem.my.pos.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerUpdateDTO {
    private long customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
}
