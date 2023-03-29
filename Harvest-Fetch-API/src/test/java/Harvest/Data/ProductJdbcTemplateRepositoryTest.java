package Harvest.Data;

import Harvest.Models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProductJdbcTemplateRepositoryTest {
    final static int NEXT_ID = 11;

    @Autowired
    ProductJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAll() {
        List<Product> products = repository.findAll();
        assertNotNull(products);
        assertTrue(products.size() >= 8 && products.size() <= 11);
    }
}