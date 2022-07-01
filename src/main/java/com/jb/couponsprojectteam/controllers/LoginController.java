package com.jb.couponsprojectteam.controllers;

import com.jb.couponsprojectteam.beans.ClientDetails;
import com.jb.couponsprojectteam.exceptions.LoginException;
import com.jb.couponsprojectteam.services.LoginService;
import com.jb.couponsprojectteam.services.serviceImpl.AdminServiceImpl;
import com.jb.couponsprojectteam.services.serviceImpl.CompanyServiceImpl;
import com.jb.couponsprojectteam.services.serviceImpl.CustomerServiceImpl;
import com.jb.couponsprojectteam.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
    private final JWT jwt;
    private final LoginService loginService;
    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> login(@RequestBody ClientDetails clientDetails) throws LoginException {
        if (loginService.login(clientDetails) != null) {
            return ResponseEntity.ok()
                    .header("Authorization", jwt.generateToken(clientDetails)).build();
        }
        throw new LoginException(clientDetails.getClientType());
    }

}
