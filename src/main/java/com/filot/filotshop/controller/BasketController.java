package com.filot.filotshop.controller;

import com.filot.filotshop.config.secuity.JwtTokenProvider;
import com.filot.filotshop.basket.entity.BasketForm;
import com.filot.filotshop.basket.service.BasketService;
import com.filot.filotshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class BasketController {

    private final UserService userService;
    private final BasketService basketService;
    private final JwtTokenProvider jwtTokenProvider;


//ok
    @PostMapping("/products/{id}/basket")
    @Transactional
    public void addProductInToBasket(HttpServletRequest req, @PathVariable(name = "id") Long productId , @RequestBody BasketForm basketForm) {
        String userEmail = jwtTokenProvider.getUserEmail(req);

        if(userEmail== null && userEmail.equals("")){
            return;
        }

        basketService.addBasket(userEmail, productId,basketForm);
    }


}
