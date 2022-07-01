package com.jb.couponsprojectteam.services.serviceImpl;

import com.jb.couponsprojectteam.beans.Coupon;
import com.jb.couponsprojectteam.exceptions.ExceptionType;
import com.jb.couponsprojectteam.exceptions.NotExistException;
import com.jb.couponsprojectteam.repositories.CouponRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class GuestServiceImpl {
    private final CouponRepo couponRepo;

    public List<Coupon> getAllCouponsInDB() throws NotExistException {
        List<Coupon> coupons= couponRepo.findAll();
        if (coupons.isEmpty()){
            throw new NotExistException(ExceptionType.COUPON);
        }
        return coupons;
    }
}
