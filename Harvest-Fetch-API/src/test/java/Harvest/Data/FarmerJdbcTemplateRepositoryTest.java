package Harvest.Data;

import Harvest.Models.Farmer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FarmerJdbcTemplateRepositoryTest {

    final static int NEXT_ID = 6;

    @Autowired
    FarmerJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAllFarmers() {
        List<Farmer> farmers = repository.findAll();
        assertNotNull(farmers);
        assertTrue(farmers.size() > 0);
    }

    @Test
    void shouldFindMemphisFarm(){
        Farmer farmer = repository.findById(3);
        assertEquals(3, farmer.getFarmerId());
        assertEquals("Memphis Farm", farmer.getFarmName());
    }
}