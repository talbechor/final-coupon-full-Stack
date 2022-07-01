package com.jb.couponsprojectteam.services.serviceDAO;

import com.jb.couponsprojectteam.beans.Categories;
import com.jb.couponsprojectteam.beans.Coupon;
import com.jb.couponsprojectteam.beans.Customer;
import com.jb.couponsprojectteam.exceptions.AlreadyExistsException;
import com.jb.couponsprojectteam.exceptions.NotExistException;

import java.util.List;

public interface CustomerService {

    Coupon purchaseCoupon(int couponID) throws NotExistException, AlreadyExistsException;

    List<Coupon> getAllCustomerCoupons() throws NotExistException;

    List<Coupon> getAllCustomerCouponsByCategory(Categories category) throws NotExistException;

    List<Coupon> getAllCustomerCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Customer getCustomerDetails();
}
