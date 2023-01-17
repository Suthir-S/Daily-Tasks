package com.quinbay.wholesaler.controller;

import com.quinbay.wholesaler.model.Wholesaler;
import com.quinbay.wholesaler.service.WhoDetails;
import com.quinbay.wholesaler.service.WhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class WhoMain {
    @Autowired
    WhoService whoService;
    @Autowired
    WhoDetails whoDetails;

    @GetMapping("/loadData")
    public String loadData(){
        whoService.Service();
        return "Data loaded";
    }

    @GetMapping("/displayWholeSaler/{wholeSalerId}")
    public String viewProduct(@PathVariable int wholeSalerId)
    {
        return whoDetails.getDetails(wholeSalerId);
    }
    @PostMapping("/addWholeSaler")
    public String postData(@RequestBody ArrayList<Wholesaler> inputWholeSaler)
    {
        return whoService.addWholeSaler(inputWholeSaler);
    }
    //
    //

    /*@DeleteMapping("/deleteWholeSaler/{wholeSalerId}")
    public String deleteWholeSaler(@PathVariable int wholeSalerId)
    {
        return whoService.deleteWholesaler(wholeSalerId);
    }*/

    @PutMapping("/allocateWholeSaler/{wholeSalerId}/{productId}/{itemCountToBuy}")
    public String allocateWholeSaler(@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
        return whoService.allocateWholesaler(wholeSalerId,productId,itemCountToBuy);
    }

}
