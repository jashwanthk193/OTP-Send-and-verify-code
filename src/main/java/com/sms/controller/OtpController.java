package com.sms.controller;


import com.sms.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class OtpController {

    @Autowired
    private OtpService otpService;



    @PostMapping("/send-otp")
    public ResponseEntity<String> sendSmsOtp(@RequestParam String phoneNumber) {
        otpService.sendOtp(phoneNumber);
        return ResponseEntity.ok("otp sent successfully");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
       boolean isVerified=otpService.verifyOtp(phoneNumber,otp);
       if(isVerified){
           return ResponseEntity.ok("OTP verified successfully");
       }else{
           return ResponseEntity.ok("please provide correct otp");
       }
    }
}
