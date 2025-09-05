package com.mypossystem.my.pos.project.entity;

import com.mypossystem.my.pos.project.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @Column(name = "item_id",length = 25)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_type",length = 100,nullable = false)
    private MeasuringUnitType measuringUnitType;
    @Column(name = "balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price", length = 100, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 100,nullable = false)
    private double sellingPrice;

    @Column(name = "active_stste", columnDefinition = "TINYINT default 0")
    private boolean activeState;


    public double getPrice() {
        return 0;
    }
}
