package com.mypossystem.my.pos.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private long customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private ArrayList contactNumber;
    private int nic;
    private boolean active;
}
