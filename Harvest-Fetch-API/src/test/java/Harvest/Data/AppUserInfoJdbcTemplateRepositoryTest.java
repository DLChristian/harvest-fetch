package Harvest.Data;

import Harvest.Models.AppUser;
import Harvest.Models.AppUserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AppUserInfoJdbcTemplateRepositoryTest {

    final static int NEXT_ID = 12;

    @Autowired
    AppUserInfoJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAllUsers() {
        List<AppUserInfo> users = repository.findAll();
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

}