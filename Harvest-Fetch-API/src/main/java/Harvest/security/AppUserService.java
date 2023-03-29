package Harvest.security;

import Harvest.Models.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

    private final ArrayList<AppUser> users = new ArrayList<>();

    public AppUserService(PasswordEncoder encoder) {
        users.add(new AppUser("user", encoder.encode("user"), List.of("USER")));
        users.add(new AppUser("admin", encoder.encode("admin"), List.of("ADMIN")));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       AppUser user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);

       if(user == null){
           throw new UsernameNotFoundException("Username " + username + " not found.");
       }

        return user;
    }
}
