package com.quinbay.retailer.controller;

import com.quinbay.retailer.model.Retailer;
//import com.quinbay.retailer.service.Details;
import com.quinbay.retailer.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RetMain {
    @Autowired
    RetailerService retailerService;

    @PostMapping("/")
    public void add(@RequestBody ArrayList<Retailer> inputRetailer) {
        retailerService.addRetailer( inputRetailer);
    }

    @GetMapping("/findall")
    public ArrayList<Retailer> getAllRetailer() {
        return retailerService.findAllRetailer();
    }

    @GetMapping("/findbyid/{id}")
    public Retailer getRetailerUsingId(@PathVariable int id) {
        return retailerService.findAllRetailerByID(id);
    }

    @DeleteMapping("/delete")
    public void delete() {
        retailerService.deleteAllData();
    }



//
////    @Autowired
////    Details retDetails;
//
//    @GetMapping("/loadData")
//    public String loadData(){
//        retailerService.Service();
//        return "Data loaded";
//    }
//
//    @GetMapping("/displayRetailer/{retailerId}")
//    public String viewProduct(@PathVariable int retailerId)
//    {
//        //pr.Service();
//        return retDetails.getDetails(retailerId);
//    }
//    @PostMapping("/addWholeSaler")
//    public String postData(@RequestBody ArrayList<Retailer> inputRetailer)
//    {
//        return retailerService.addRetailer(inputRetailer);
//    }
    /*@PostMapping("/updateWholeSaler")
    public String updateRetailer(@RequestBody Retailer rs)
    {
        return retailerService.updateWholeSaler(rs);
    }

    @DeleteMapping("/deleteWholeSaler/{wholeSalerId}")
    public String deleteWholeSaler(@PathVariable int retailerId)
    {
        return retailerService.deleteRetailer(retailerId);
    }*/

//    @PutMapping("/allocateWholeSaler/{wholeSalerId}/{productId}/{itemCountToBuy}")
//    public String allocateRetailer(@PathVariable int retailerId,@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
//        return retailerService.allocateRetailer(retailerId,wholeSalerId,productId,itemCountToBuy);
//    }

}
