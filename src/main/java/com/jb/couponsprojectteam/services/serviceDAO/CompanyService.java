package com.jb.couponsprojectteam.services.serviceDAO;

import com.jb.couponsprojectteam.beans.Categories;
import com.jb.couponsprojectteam.beans.Company;
import com.jb.couponsprojectteam.beans.Coupon;
import com.jb.couponsprojectteam.exceptions.NotExistException;

import java.util.List;

public interface CompanyService {

    int addCoupon(Coupon coupon) throws NotExistException;

    void updateCoupon(Coupon coupon) throws NotExistException;

    void deleteCoupon(int couponID) throws NotExistException;

    List<Coupon> getAllCompanyCoupons() throws NotExistException;

    List<Coupon> getAllCompanyCouponsByCategory(Categories category) throws NotExistException;

    List<Coupon> getAllCompanyCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Company getCompanyDetails();
}
