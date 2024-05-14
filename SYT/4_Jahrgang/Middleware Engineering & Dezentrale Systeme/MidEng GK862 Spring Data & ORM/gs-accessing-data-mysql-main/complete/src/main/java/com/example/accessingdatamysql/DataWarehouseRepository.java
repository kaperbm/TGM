package com.example.accessingdatamysql;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.accessingdatamysql.Data_Warehouse;

@Repository
public interface DataWarehouseRepository extends CrudRepository<Data_Warehouse, Integer> {
    // You can add custom query methods here if needed
}
