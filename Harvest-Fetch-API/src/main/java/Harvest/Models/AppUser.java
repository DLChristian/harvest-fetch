package Harvest.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUser implements UserDetails {

    private int appUserId;

    private String userName;

    private String password; // hash

    private ArrayList<GrantedAuthority> authorities = new ArrayList<>();

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void addAuthorities(List<String> authorities) {
        this.authorities.clear();
        for(String name: authorities){
            this.authorities.add(new SimpleGrantedAuthority(name));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



//    private String firstName;
//    private String lastName;
//    private String address;
//    private String zipCode;
//    private String city;
//    private String state;
//    private String email;
//    private String phone;
//    private String photoUrl;
//

//
//
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getPhotoUrl() {
//        return photoUrl;
//    }
//
//    public void setPhotoUrl(String photoUrl) {
//        this.photoUrl = photoUrl;
//    }
}
