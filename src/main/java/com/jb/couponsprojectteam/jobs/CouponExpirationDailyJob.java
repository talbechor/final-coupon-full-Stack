package com.jb.couponsprojectteam.jobs;

import com.jb.couponsprojectteam.repositories.CouponRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class CouponExpirationDailyJob {
    private final CouponRepo couponRepo;

    @Scheduled(cron = "0 0 0 * * ? ", zone = "Asia/Jerusalem")
    public void deleteExpiredCoupons() {
        couponRepo.deletePurchasedExpiredCoupons();
        couponRepo.deleteExpiredCoupons();
        System.out.println("The daily job has finished");
    }

}
