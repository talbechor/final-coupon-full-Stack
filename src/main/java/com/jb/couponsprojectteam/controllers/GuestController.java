package com.jb.couponsprojectteam.controllers;

import com.jb.couponsprojectteam.beans.ClientDetails;
import com.jb.couponsprojectteam.beans.ClientType;
import com.jb.couponsprojectteam.exceptions.LoginException;
import com.jb.couponsprojectteam.exceptions.NotExistException;
import com.jb.couponsprojectteam.exceptions.TokenException;
import com.jb.couponsprojectteam.services.serviceImpl.GuestServiceImpl;
import com.jb.couponsprojectteam.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class GuestController {
    private final GuestServiceImpl guestService;
    private final JWT jwt;
    ClientDetails clientDetails= ClientDetails.builder()
            .email("guest@.com")
            .clientType(ClientType.GUEST)
            .password("GUEST")
            .build();

    @GetMapping("/allCoupons")
    public ResponseEntity<?> getAllCoupons() throws NotExistException, TokenException, LoginException {
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(clientDetails))
                .body(guestService.getAllCouponsInDB());
    }
}
