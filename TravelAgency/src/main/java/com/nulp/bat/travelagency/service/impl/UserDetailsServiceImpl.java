package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.model.User;
import com.nulp.bat.travelagency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByloginUser(username).orElseThrow(() -> new UsernameNotFoundException("Could not find user"));

///        return new MyUserDetails(user);
        String role = user.getRole().getRole();
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return new org.springframework.security.core.userdetails.User(user.getLoginUser(), user.getPasswordUser(), authorities);
//        return new org.springframework.security.core.userdetails.User(user.getLoginUser(), user.getPasswordUser(), user.getRole().getRole());
    }
}
