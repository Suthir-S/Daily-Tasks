package com.example.billing.kafka;

import com.example.billing.model.Product;
import com.example.billing.model.Wholesaler;
import com.example.billing.service.BillingService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class KafkaListenerClass {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BillingService billingService;

    @KafkaListener(topics="send.billingInfo",groupId = "generatebill")
    public void getWholesaler(ConsumerRecord<?,String> consumerRecord){
       Wholesaler wholesaler =null;
       Product product =null;
        try{
            product = objectMapper.readValue(consumerRecord.value(), new TypeReference<Product>() {
            });
            wholesaler = objectMapper.readValue(consumerRecord.value(), new TypeReference<Wholesaler>() {
            });
            String wname=wholesaler.getWhname();
            int pid=product.getId();
            String pname=product.getName();
            int price=product.getPrice();
           double gst=product.getGst();
            System.out.println(wname);
            System.out.println(pid);
            System.out.println(pname);
            System.out.println(price);
            System.out.println(gst);

            billingService.sendEmail();
            Scanner sc = new Scanner(System.in);
            billingService.generatePDF(wname,pid,pname,price,gst);

        }catch(Exception e){

        }
      }

}