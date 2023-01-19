package com.quinbay.wholesaler.api;

import com.quinbay.wholesaler.model.Wholesaler;

import java.util.ArrayList;

public interface WholesalerInterface {
    ArrayList<Wholesaler> findAllWholesaler();
    Wholesaler findAllWholesalerByID(int id);
    void addWholesaler(ArrayList<Wholesaler> inputWholesalers);
    void deleteAllData();
}
