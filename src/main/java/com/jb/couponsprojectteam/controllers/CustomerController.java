package com.jb.couponsprojectteam.controllers;

import com.jb.couponsprojectteam.beans.Categories;
import com.jb.couponsprojectteam.beans.ClientType;
import com.jb.couponsprojectteam.exceptions.AlreadyExistsException;
import com.jb.couponsprojectteam.exceptions.LoginException;
import com.jb.couponsprojectteam.exceptions.NotExistException;
import com.jb.couponsprojectteam.exceptions.TokenException;
import com.jb.couponsprojectteam.services.serviceImpl.CustomerServiceImpl;
import com.jb.couponsprojectteam.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CustomerController {
    private final JWT jwt;
    private final CustomerServiceImpl customerService;

    @PostMapping("/purchaseCoupon/{couponID}")
    public ResponseEntity<?> purchaseCoupon(@RequestHeader(name = "Authorization") String token, @PathVariable int couponID) throws TokenException, LoginException, NotExistException, AlreadyExistsException {
        jwt.checkUser(token, ClientType.CUSTOMER);



        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(  customerService.purchaseCoupon(couponID));
    }

    @GetMapping("/getCustomerCoupons")
    public ResponseEntity<?> getCustomerCoupons(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCoupons());
    }

    @GetMapping("/getCustomerCouponsByCategory/{category}")
    public ResponseEntity<?> getCustomerCouponsByCategory(@RequestHeader(name = "Authorization") String token, @PathVariable Categories category) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCouponsByCategory(category));
    }

    @GetMapping("/getCustomerCouponsByMaxPrice/{maxPrice}")
    public ResponseEntity<?> getCustomerCouponsByMaxPrice(@RequestHeader(name = "Authorization") String token, @PathVariable double maxPrice) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getAllCustomerCouponsByMaxPrice(maxPrice));
    }

    @GetMapping("/getCustomerDetails")
    public ResponseEntity<?> getCustomerDetails(@RequestHeader(name = "Authorization") String token) throws TokenException, LoginException {
        jwt.checkUser(token, ClientType.CUSTOMER);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(customerService.getCustomerDetails());
    }

}
