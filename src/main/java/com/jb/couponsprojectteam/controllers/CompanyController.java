package com.jb.couponsprojectteam.controllers;

import com.jb.couponsprojectteam.beans.Categories;
import com.jb.couponsprojectteam.beans.ClientType;
import com.jb.couponsprojectteam.beans.Coupon;
import com.jb.couponsprojectteam.exceptions.LoginException;
import com.jb.couponsprojectteam.exceptions.NotExistException;
import com.jb.couponsprojectteam.exceptions.TokenException;
import com.jb.couponsprojectteam.services.serviceImpl.CompanyServiceImpl;
import com.jb.couponsprojectteam.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final JWT jwt;
    private final CompanyServiceImpl companyService;

    @PostMapping("/addCoupon")
    @CrossOrigin
    public ResponseEntity<?> addCoupon(@RequestHeader(name = "Authorization") String token, @RequestBody Coupon coupon) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(  companyService.addCoupon(coupon));
    }

    @PutMapping("/updateCoupon")
    @CrossOrigin
    public ResponseEntity<?> updateCoupon(@RequestHeader(name = "Authorization") String token, @RequestBody Coupon coupon) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);
        companyService.updateCoupon(coupon);
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Coupon #" + coupon.getId() + " updated Successfully");
    }

    @DeleteMapping("/deleteCoupon/{couponID}")
    public ResponseEntity<?> deleteCoupon(@RequestHeader(name = "Authorization") String token, @PathVariable int couponID) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);
        companyService.deleteCoupon(couponID);
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Coupon #" + couponID + " deleted Successfully");
    }

    @GetMapping("/getAllCompanyCoupons")
    @CrossOrigin
    public ResponseEntity<?> getAllCompanyCoupons(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCoupons());
    }

    @GetMapping("/getAllCompanyCouponsByCategory/{category}")
    public ResponseEntity<?> getAllCompanyCouponsByCategory(@RequestHeader(name = "Authorization") String token, @PathVariable Categories category) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCouponsByCategory(category));
    }

    @GetMapping("/getAllCompanyCouponsByMaxPrice/{maxPrice}")
    public ResponseEntity<?> getAllCompanyCouponsByMaxPrice(@RequestHeader(name = "Authorization") String token, @PathVariable double maxPrice) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCouponsByMaxPrice(maxPrice));
    }

    @GetMapping("/getCompanyDetails")
    @CrossOrigin
    public ResponseEntity<?> getCompanyDetails(@RequestHeader(name = "Authorization") String token) throws TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getCompanyDetails());
    }

}
