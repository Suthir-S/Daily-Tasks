package com.quinbay.retailer.service;

import com.quinbay.retailer.api.RetailerInterface;
import com.quinbay.retailer.model.Retailer;
import com.quinbay.retailer.model.RetailerStock;
//import com.quinbay.retailer.web.client.RetClientAPI;
import com.quinbay.retailer.repository.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class RetailerService implements RetailerInterface {
    //@Autowired
    //RetClientAPI retClientAPI;
    static ArrayList<Retailer> retailer_details = new ArrayList<>();

    @Autowired
    RetailerRepository retailerRepository;

    @Override
    public ArrayList<Retailer> findAllRetailer() {
        return (ArrayList<Retailer>) retailerRepository.findAll();
    }
    @Override
    public Retailer findAllRetailerByID (int id) {
        Optional<Retailer> opt = retailerRepository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public void addRetailer(ArrayList<Retailer> inputRetailer) {
        for (Retailer who : inputRetailer) {
            Retailer newRetailer  = new Retailer(who.getId(),who.getRetailer_name(),who.getRetailer_ref());
            retailerRepository.save(newRetailer);
        }
    }
    @Override
    public void deleteAllData() {
        retailerRepository.deleteAll();
    }



//    public static void Service() {
//
//        try {
//            String line = "";
//            String splitBy = ",";
//
//            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/suthir/Downloads/Retailer.csv"));
//            while ((line = sc2.readLine()) != null) {
//                String[] productSplit = line.split(splitBy);
//                retailer_details.add(new Retailer(Integer.parseInt(productSplit[0]), productSplit[1]));
//            }
//            sc2.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    //Add new retailer to retailer arraylist
//    public static String addRetailer(ArrayList<Retailer> inputRetailer) {
//        for (Retailer input : inputRetailer) {
//            int flag = 0;
//            for (Retailer rs : retailer_details) {
//                if (input.getRetailer_id() == rs.getRetailer_id()) {
//                    flag = 1;
//                }
//            }
//            if (flag == 0) {
//                Retailer newRetailer = new Retailer(input.getRetailer_id(), input.getRetailer_name());
//                retailer_details.add(newRetailer);
//            }
//        }
//        String str = "";
//        for (Retailer rs : retailer_details) {
//            str += rs.getRetailer_id() + " " + rs.getRetailer_name() + "\n";
//        }
//
//        return str;
//    }
//
//    public static String deleteRetailer(int retailerId){
//        int count = 0;
//        int delIndex =0;
//        boolean flag=false;
//        for (Retailer rl : retailer_details) {
//            if(retailerId == rl.getRetailer_id()) {
//                System.out.println(rl.getRetailer_id());
//                delIndex=count;
//                flag=true;
//            }
//            count++;
//
//        }
//        if(flag==true) {
//            retailer_details.remove(delIndex);
//        }
//
//        String str = "";
//        for (Retailer r : retailer_details) {
//            str += r.getRetailer_id()+r.getRetailer_name()  + "\n";
//        }
//
//        return str;
//    }
//    public static String updateWholeSaler(Retailer inputRetailer){
//        for (Retailer rs : retailer_details) {
//            if (inputRetailer.getRetailer_id() == rs.getRetailer_id()) {
//                rs.setRetailer_name(inputRetailer.getRetailer_name());
//            }
//        }
//
//        return "Product updated";
//    }
//

    }





