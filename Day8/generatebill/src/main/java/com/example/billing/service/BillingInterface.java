package com.example.billing.service;

public interface BillingInterface {
    void  generatePDF(String whname,int pid,String pname,int price,double gst);
    void sendEmail();

}
