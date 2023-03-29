package Harvest.Controllers;

import Harvest.Models.AppUser;
<<<<<<< HEAD
import Harvest.security.JwtConvertor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
=======
import Harvest.security.JwtConverter;
>>>>>>> 2c6d71949ce42558c15f399c585efe553f467be9
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@ConditionalOnWebApplication
@RestController
@CrossOrigin
public class AuthController {

    private final AuthenticationManager manager;
    private final JwtConverter converter;

    public AuthController(AuthenticationManager manager, JwtConverter converter) {
        this.manager = manager;
        this.converter = converter;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AppUser user) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword());

        try {
            Authentication authentication = manager.authenticate(token);
            if (authentication.isAuthenticated()) {
                AppUser authenticatedUser = (AppUser) authentication.getPrincipal();
                String jwt = converter.userToToken((AppUser)authentication.getPrincipal());
                HashMap<String, String> map = new HashMap<>();
                map.put("jwt", jwt);
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
        } catch (AuthenticationException ex) {
            System.out.println(ex.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@AuthenticationPrincipal AppUser user) {
        String jwt = converter.userToToken(user);
        HashMap<String, String> map = new HashMap<>();
        map.put("jwt", jwt);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
