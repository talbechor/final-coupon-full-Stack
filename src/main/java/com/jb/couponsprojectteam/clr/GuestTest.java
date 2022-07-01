package com.jb.couponsprojectteam.clr;

import com.jb.couponsprojectteam.services.serviceImpl.GuestServiceImpl;
import com.jb.couponsprojectteam.utils.TablePrinter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class GuestTest implements CommandLineRunner {
    private final GuestServiceImpl guestService;
    @Override
    public void run(String... args) throws Exception {
        TablePrinter.print(guestService.getAllCouponsInDB());
    }
}
