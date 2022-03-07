package com.filot.filotshop.config.secuity;

import com.filot.filotshop.FilotShopApplication;
import com.filot.filotshop.config.AmazonS3Config;
import com.filot.filotshop.user.entity.Address;
import com.filot.filotshop.user.entity.User;
import com.filot.filotshop.user.repository.UserRepository;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@SpringBootTest
@Transactional
@TestPropertySource(locations={"classpath:application.yml","classpath:aws.yml"})
class JwtTokenProviderTest {
    
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserRepository userRepository;
    @Test
    public void 회원가입한다(){
        User user = new User();
        user.setName("nameA");
        user.setEmail("ASDSADASD");
        user.setPassword("passwordA");
        user.setAddress(new Address("detailRoadA", "roadA"));
        user.setPhoneNumber("123123");
        user.setRoles(Collections.singletonList("ROLE_USER"));
        
        userRepository.save(user);

//        assertThat(user.getRoles().)
        System.out.println("user.getRoles().get(0) = " + user.getRoles().get(0));
    }
    
    @Test
    public void 관리자권한등업한다(){
        User user = new User();
        user.setName("nameA");
        user.setEmail("emailA");
        user.setPassword("passwordA");
        user.setAddress(new Address("detailRoadA", "roadA"));
        user.setPhoneNumber("01099043322");
        user.setRoles(Collections.singletonList("ROLE_USER,ROLE_ADMIN"));

        System.out.println("user.getRoles().get(0) = " + user.getRoles().get(0));
    }

}