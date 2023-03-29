package Harvest.Controllers;

import Harvest.Models.AppUser;
import Harvest.security.JwtConvertor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@ConditionalOnWebApplication
@RestController
public class AuthController {

    private final AuthenticationManager manager;
    private final JwtConvertor convertor;

    public AuthController(AuthenticationManager manager, JwtConvertor convertor) {
        this.manager = manager;
        this.convertor = convertor;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AppUser user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword());
        try {
            Authentication authentication = manager.authenticate(token);
            if (authentication.isAuthenticated()) {
                String jwt = convertor.userToToken((AppUser)authentication.getPrincipal());
                HashMap<String, String> values = new HashMap<>();
                values.put("jwt", jwt);
                return new ResponseEntity<>(values, HttpStatus.OK);
            }
        }catch (AuthenticationException ex) {
            System.out.println(ex.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}