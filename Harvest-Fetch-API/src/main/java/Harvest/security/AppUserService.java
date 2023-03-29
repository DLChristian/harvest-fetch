package Harvest.security;

import Harvest.Data.AppUserJdbcTemplateRepository;
import Harvest.Models.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

    private final AppUserJdbcTemplateRepository repository;

    public AppUserService(AppUserJdbcTemplateRepository repository) {
        this.repository = repository;
    }

    public AppUserService(PasswordEncoder passwordEncoder, AppUserJdbcTemplateRepository repository) {
        this.repository = repository;
        AppUser user = new AppUser();
        user.setUserName("user");
        user.setPassword(passwordEncoder.encode("user"));
//        user.setAuthorities(List.of("USER"));
//        users.add(user);

        AppUser admin = new AppUser();
        admin.setUserName("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
//        admin.setAuthorities(List.of("ADMIN"));
//        users.add(admin);

        AppUser farmer = new AppUser();
        farmer.setUserName("user");
        farmer.setPassword(passwordEncoder.encode("farmer"));
//        farmer.setAuthorities(List.of("FARMER"));
//        users.add(farmer);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = this.repository.findByUserName(username);

       if(user == null){
           throw new UsernameNotFoundException("Username " + username + " not found.");
       }

        return user;
    }
}
