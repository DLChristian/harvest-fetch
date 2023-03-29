package Harvest.security;

import Harvest.Models.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

    private ArrayList<AppUser> users = new ArrayList<>();

    public AppUserService(PasswordEncoder passwordEncoder) {
        AppUser user = new AppUser();
        user.setUserName("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setAuthorities(List.of("USER"));
        users.add(user);

        AppUser admin = new AppUser();
        admin.setUserName("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setAuthorities(List.of("ADMIN"));
        users.add(admin);

        AppUser farmer = new AppUser();
        farmer.setUserName("user");
        farmer.setPassword(passwordEncoder.encode("farmer"));
        farmer.setAuthorities(List.of("FARMER"));
        users.add(farmer);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       AppUser user = users.stream().filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);

       if(user == null){
           throw new UsernameNotFoundException(String.format("%s not found", username));
       }

        return user;
    }
}
