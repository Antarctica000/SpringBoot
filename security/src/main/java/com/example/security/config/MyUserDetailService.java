package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("通过用户名加载用户");
        com.example.security.pojo.User user = userService.getUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return new User(user.getUsername() ,user.getPassword(),
                createAuthority(user.getRoles()));

    }

    //这里是将数据库的角色分割，构造GrantedAuthority
    private List<SimpleGrantedAuthority> createAuthority(String roles) {
        String[] roleArray = roles.split(",");
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (String role : roleArray) {
            authorityList.add(new SimpleGrantedAuthority(role));
        }
        return authorityList;
    }
}
