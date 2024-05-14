package com.example.accessingdatamysql;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String gewicht;

    @ManyToOne
    @JoinColumn(name = "data_warehouse_id")
    private Data_Warehouse dataWarehouse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGewicht() {
        return gewicht;
    }

    public void setGewicht(String gewicht) {
        this.gewicht = gewicht;
    }

    public Data_Warehouse getDataWarehouse() {
        return dataWarehouse;
    }

    public void setDataWarehouse(Data_Warehouse dataWarehouse) {
        this.dataWarehouse = dataWarehouse;
    }
}
