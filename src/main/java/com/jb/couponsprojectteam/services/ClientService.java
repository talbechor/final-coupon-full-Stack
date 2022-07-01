package com.jb.couponsprojectteam.services;

import com.jb.couponsprojectteam.repositories.CompanyRepo;
import com.jb.couponsprojectteam.repositories.CouponRepo;
import com.jb.couponsprojectteam.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {


    @Autowired
    protected CompanyRepo companyRepo;

    @Autowired
    protected CustomerRepo customerRepo;

    @Autowired
    protected CouponRepo couponRepo;

    public abstract boolean login(String email, String password);
}
