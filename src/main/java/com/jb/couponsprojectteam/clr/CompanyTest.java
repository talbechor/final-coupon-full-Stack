package com.jb.couponsprojectteam.clr;

import com.jb.couponsprojectteam.beans.Categories;
import com.jb.couponsprojectteam.beans.ClientDetails;
import com.jb.couponsprojectteam.beans.ClientType;
import com.jb.couponsprojectteam.beans.Coupon;
import com.jb.couponsprojectteam.repositories.CouponRepo;
import com.jb.couponsprojectteam.services.LoginService;
import com.jb.couponsprojectteam.services.serviceImpl.CompanyServiceImpl;
import com.jb.couponsprojectteam.utils.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Order(2)
public class CompanyTest implements CommandLineRunner {

    private final CouponRepo couponRepo;
    private final LoginService loginService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Company Test \n");

        System.out.println("Company 1");


        companyTest1();


        System.out.println("Company 2");
        companyTest2();
    }

    private void companyTest1() throws Exception {
        CompanyServiceImpl company1 = (CompanyServiceImpl) loginService.login(
                new ClientDetails("no-reply@oren.inc", "orenInc", ClientType.COMPANY));


        company1.addCoupon((Coupon.builder()
//                .company(company1.getCompanyDetails())
                .category(Categories.FOOD)
                .title("Mcdonald's")
                .description("bla bla")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(10)
                .price(19.90)
                .image("https://cdn.mcdonalds.pl/uploads/20201125090229/mcroyal.png")
                .build()));

        company1.addCoupon((Coupon.builder()
//                .company(company1.getCompanyDetails())
                .category(Categories.FOOD)
                .title("greek salad")
                .description("10% discount")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(30)
                .price(24.90)
                .image("https://th.bing.com/th/id/R.fe4d1a398e5d528d125c1653cb4387a1?rik=5ZVDTsIGhtDIIg&pid=ImgRaw&r=0")
                .build()));



        company1.addCoupon(Coupon.builder()
//                .company(company1.getCompanyDetails())
                .category(Categories.ELECTRICITY)
                .title("Apple watch")
                .description("15% discount!!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(10)
                .price(700)
                .image("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/45-nc-alum-midnight-sport-gray-s7?wid=1200&hei=630&fmt=jpeg&qlt=95&.v=1631855766000")
                .build());

        System.out.println("Adding coupons");
        TablePrinter.print(company1.getAllCompanyCoupons());

        System.out.println("Updating coupon #1");
        company1.updateCoupon(Coupon.builder()
                .id(1)
//                .company(company1.getCompanyDetails())
                .category(Categories.FOOD)
                .title("Mcdonald's")
                .description("10% discount Mc royal meal !!!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(10)
                .price(19.90)
                .image("https://cdn.mcdonalds.pl/uploads/20201125090229/mcroyal.png")
                .build());

        TablePrinter.print(company1.getAllCompanyCoupons());

        System.out.println("Print all company coupons by category - FOOD");
        TablePrinter.print(company1.getAllCompanyCouponsByCategory(Categories.FOOD));

        System.out.println("Print all company coupons by max price - 40");
        TablePrinter.print(company1.getAllCompanyCouponsByMaxPrice(40));

        System.out.println("Deleting coupon #2");
//        company1.deleteCoupon(2);
//        TablePrinter.print(company1.getAllCompanyCoupons());

        System.out.println("Get company #1 details");
//        TablePrinter.print(company1.getCompanyDetails()); doesn't work - failed to lazily initialize
        System.out.println(company1.getCompanyDetails() + "\n");
    }

    private void companyTest2() throws Exception {
        CompanyServiceImpl company2 = (CompanyServiceImpl) loginService.login(
                new ClientDetails("noreply@lea.inc", "leasInc", ClientType.COMPANY));

        company2.addCoupon(Coupon.builder()
//                .company(company2.getCompanyDetails())
                .category(Categories.FOOD)
                .title("Food Discount")
                .description("bla bla")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now()))
                .amount(10)
                .price(39.90)
                .image("Food")
                .build());

        company2.addCoupon(Coupon.builder()
//                .company(company2.getCompanyDetails())
                .category(Categories.ELECTRICITY)
                .title("Oven Discount")
                .description("20% off beast oven you can find!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(10)
                .price(499.9)
                .image("https://media3.bosch-home.com/Product_Shots/1600x900/MCSA02401843_HBJ558YS0T_BuiltInOven_Bosch_STP_EVO_def.png")
                .build());

        company2.addCoupon(Coupon.builder()
//                .company(company2.getCompanyDetails())
                .category(Categories.VACATION)
                .title("mykonos greece vacation")
                .description("20% off 4 nights!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(10)
                .price(4999.9)
                .image("https://th.bing.com/th/id/R.e01b8c72230dee216ad93d6ebeb1c99f?rik=xI3gkZtk%2bfMXMQ&pid=ImgRaw&r=0")
                .build());

        System.out.println("Adding coupons");
        TablePrinter.print(company2.getAllCompanyCoupons());

        System.out.println("Updating coupon #3");
        Coupon coupon = couponRepo.findById(3).get();
        coupon.setTitle("BLAH");


        TablePrinter.print(company2.getAllCompanyCoupons());

        System.out.println("Print all company coupons by category - FOOD");
        TablePrinter.print(company2.getAllCompanyCouponsByCategory(Categories.FOOD));

        System.out.println("Print all company coupons by max price - 40");
        TablePrinter.print(company2.getAllCompanyCouponsByMaxPrice(40));

        System.out.println("Deleting coupon #3");
        company2.deleteCoupon(4);
        TablePrinter.print(company2.getAllCompanyCoupons());

        System.out.println("Get company #2 details");
//        TablePrinter.print(company2.getCompanyDetails()); doesn't work - failed to lazily initialize
        System.out.println(company2.getCompanyDetails() + "\n");
    }

}
