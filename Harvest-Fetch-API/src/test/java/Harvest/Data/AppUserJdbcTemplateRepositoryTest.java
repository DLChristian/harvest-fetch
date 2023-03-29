package Harvest.Data;

import Harvest.Models.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AppUserJdbcTemplateRepositoryTest {

    final static int NEXT_ID = 7;

    @Autowired
    AppUserJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAllUsers() {
        List<AppUser> users = repository.findAll();
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    void shouldFindTestOne(){
        AppUser testOne = repository.findById(1);
        assertEquals(1, testOne.getUserId());
        assertEquals("testone", testOne.getUserName());
    }

    @Test
    void shouldAddUser(){
        AppUser appUser = makeUser();
        AppUser actual = repository.add(appUser);
        assertNotNull(actual);
        assertEquals(NEXT_ID, actual.getUserId());
    }

    private AppUser makeUser(){
        AppUser appUser = new AppUser();
        appUser.setUserName("TestSeven");
        appUser.setFirstName("Lenore");
        appUser.setLastName("Kelly");
        appUser.setAddress("1213 Cardinal lake Dr.");
        appUser.setZipCode("08043");
        appUser.setCity("Cherry Hill");
        appUser.setState("NJ");
        appUser.setEmail("fakeEmail@gmail.com");
        appUser.setPhone("1234567890");
        appUser.setPhotoUrl("");
        return appUser;
    }
}