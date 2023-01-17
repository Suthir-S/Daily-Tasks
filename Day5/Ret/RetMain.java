package com.quinbay.retailer.controller;

import com.quinbay.retailer.model.Retailer;
import com.quinbay.retailer.service.RetDetails;
import com.quinbay.retailer.service.RetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RetMain {
    @Autowired
    RetService retService;
    @Autowired
    RetDetails retDetails;

    @GetMapping("/loadData")
    public String loadData(){
        retService.Service();
        return "Data loaded";
    }

    @GetMapping("/displayRetailer/{retailerId}")
    public String viewProduct(@PathVariable int retailerId)
    {
        //pr.Service();
        return retDetails.getDetails(retailerId);
    }
    @PostMapping("/addWholeSaler")
    public String postData(@RequestBody ArrayList<Retailer> inputRetailer)
    {
        return retService.addRetailer(inputRetailer);
    }
    @PostMapping("/updateWholeSaler")
    public String updateRetailer(@RequestBody Retailer rs)
    {
        return retService.updateWholeSaler(rs);
    }

    @DeleteMapping("/deleteWholeSaler/{wholeSalerId}")
    public String deleteWholeSaler(@PathVariable int retailerId)
    {
        return retService.deleteRetailer(retailerId);
    }

//    @PutMapping("/allocateWholeSaler/{wholeSalerId}/{productId}/{itemCountToBuy}")
//    public String allocateRetailer(@PathVariable int retailerId,@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
//        return retService.allocateRetailer(retailerId,wholeSalerId,productId,itemCountToBuy);
//    }

}
