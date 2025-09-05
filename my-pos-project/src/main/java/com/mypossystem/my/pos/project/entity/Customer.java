package com.mypossystem.my.pos.project.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.*;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "customer")

@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})

public class Customer {
    @Id
    @Column(name = "customer_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    @Column(name = "customer_name",length = 255,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255,nullable = false)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "contact_number",columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "nic")
    private int nic;

    @Column(name = "active_stste",columnDefinition = "TINYINT default 1 ")
    private boolean active;
}
