package com.jb.couponsprojectteam.controllers;

import com.jb.couponsprojectteam.beans.ClientType;
import com.jb.couponsprojectteam.beans.Company;
import com.jb.couponsprojectteam.beans.Customer;
import com.jb.couponsprojectteam.exceptions.LoginException;
import com.jb.couponsprojectteam.exceptions.NotExistException;
import com.jb.couponsprojectteam.exceptions.TokenException;
import com.jb.couponsprojectteam.services.serviceImpl.AdminServiceImpl;
import com.jb.couponsprojectteam.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final JWT jwt;
    private final AdminServiceImpl adminService;

    @PostMapping("/addCompany")
    @CrossOrigin
    public ResponseEntity<?> addCompany(@RequestHeader(name = "Authorization") String token, @RequestBody Company company) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(  adminService.addCompany(company));
    }

    @PutMapping("/updateCompany")
    @CrossOrigin
    public ResponseEntity<?> updateCompany(@RequestHeader(name = "Authorization") String token, @RequestBody Company company) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);
        adminService.updateCompany(company);
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Company #" + company.getId() + " updated successfully");
    }

    @DeleteMapping("/deleteCompany/{companyID}")
    @CrossOrigin
    public ResponseEntity<?> deleteCompany(@RequestHeader(name = "Authorization") String token, @PathVariable int companyID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.deleteCompany(companyID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Company #" + companyID + " deleted successfully");
    }

    @GetMapping("/allCompanies")
    @CrossOrigin
    public ResponseEntity<?> getAllCompanies(@RequestHeader(name = "Authorization") String token) throws  LoginException, TokenException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getAllCompanies());


    }

    @GetMapping("/getCompanyByID/{companyID}")
    @CrossOrigin
    public ResponseEntity<?> getCompanyByID(@RequestHeader(name = "Authorization") String token, @PathVariable int companyID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getCompanyByID(companyID));
    }

    @PostMapping("/addCustomer")
    @CrossOrigin
    public ResponseEntity<?> addCustomer(@RequestHeader(name = "Authorization") String token, @RequestBody Customer customer) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(   adminService.addCustomer(customer));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestHeader(name = "Authorization") String token, @RequestBody Customer customer) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.updateCustomer(customer);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Customer #" + customer.getId() + " updated successfully");
    }

    @DeleteMapping("/deleteCustomer/{customerID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> deleteCustomer(@RequestHeader(name = "Authorization") String token, @PathVariable int customerID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.deleteCustomer(customerID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Customer #" + customerID + " updated successfully");
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<?> getAllCustomers(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token.replace("Bearer ", "")))
                .body(adminService.getAllCustomers());
    }

    @GetMapping("/getCustomerByID/{customerID}")
    public ResponseEntity<?> getCustomerByID(@RequestHeader(name = "Authorization") String token, @PathVariable int customerID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getCustomerByID(customerID));
    }

}
