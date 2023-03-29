package Harvest.Data;

import Harvest.Models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository {


    List<Product> findAll();
}
