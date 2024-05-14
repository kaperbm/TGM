package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.accessingdatamysql.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Optional<Product> findByIdAndDataWarehouse(Integer productID, Data_Warehouse dataWarehouse);

}
