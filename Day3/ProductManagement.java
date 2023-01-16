import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.String;

public class ProductManagement {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Wholesaler> wholesaler_details = new ArrayList<>();
    static ArrayList<Retailer> retailer_details = new ArrayList<>();

    public static void main(String[] args) {

        String line = "";
        String splitBy = ",";
        try {
            BufferedReader sc1 = new BufferedReader(new FileReader("/Users/suthir/Downloads/Product1.csv"));
            while ((line = sc1.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                products.add(new Product(Integer.parseInt(productSplit[0]), productSplit[1], Integer.parseInt(productSplit[2]), Integer.parseInt(productSplit[3])));
            }
            sc1.close();
        }
        catch (Exception f) {
            System.out.println(f);
        }
        try {
            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/suthir/Downloads/wholesaler.csv"));
            while ((line = sc2.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                wholesaler_details.add(new Wholesaler(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc2.close();
        }
        catch (Exception f) {
            System.out.println(f);
        }
        try {

            BufferedReader sc3 = new BufferedReader(new FileReader("/Users/suthir/Downloads/Retailer.csv"));
            while ((line = sc3.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                retailer_details.add(new Retailer(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc3.close();
        }
        catch (Exception f) {
            System.out.println(f);
        }
        int user = 1;
        while (user!=7) {
            System.out.println("Enter the option:\n1.Display\n2.Product to wholeseller\n3.Product to retailer\n4.Product Stock\n5.Wholesaler Stock\n6.Retailer Stock\n7.Exit");
            Scanner sc = new Scanner(System.in);
            user = sc.nextInt();
            switch (user) {
                case 1:
                    System.out.println("1. Display : \n1.Products\n2.Wholesaler\n3.Retailer\n");
                    int dis = sc.nextInt();
                    switch (dis){
                    case 1: {
                        System.out.println("P_Id" + "\t" + "P_Name" + "\t\t\t" + "Price" + "\t" + "Stock"  );
                        for (Product p : products) {
                            System.out.println(p.id + "\t\t" + p.name + "\t\t\t" + p.price + "\t" + p.stock );
                        }
                        System.out.println("\n");
                        break;
                    }
                    case 2: {
                        System.out.println("Wholesaler details");
                        for (Wholesaler w : wholesaler_details) {
                            System.out.println("W_id\tW_name");
                            System.out.println(w.getWholesaler_id() + "\t" + w.getWholesaler_name());
                        }
                        System.out.println("\n");
                        break;

                    }
                    case 3: {
                        System.out.println("Retailer details");
                        for (Retailer r : ProductManagement.retailer_details) {
                            System.out.println("R_id\tR_name");
                            System.out.println(r.getRetailer_id() + "\t" + r.getRetailer_name());
                        }
                        System.out.println("\n");
                        break;

                    }
                }
                break;

                case 2: {
                    System.out.println("Enter wholesaler id");
                    int wholeSalerId = sc.nextInt();
                    System.out.println("Enter product id");
                    int productId = sc.nextInt();
                    System.out.println("Enter number of items to buy");
                    int itemCountToBuy = sc.nextInt();
                    allocateWholesaler(wholeSalerId, productId, itemCountToBuy);
                    System.out.println("\n");
                    break;
                }
                case 3: {
                    System.out.println("Enter retailer id");
                    int retailerId = sc.nextInt();
                    System.out.println("Enter wholesaler id");
                    int wholeSalerId = sc.nextInt();
                    System.out.println("Enter product id");
                    int productId = sc.nextInt();
                    System.out.println("Enter number of items to buy");
                    int itemCountToBuy = sc.nextInt();
                    allocateRetailer(retailerId, wholeSalerId, productId, itemCountToBuy);
                    System.out.println("\n");
                    break;
                }
                case 4: {
                    System.out.println("Enter product id");
                    int nameProduct = sc.nextInt();
                    displayProduct(nameProduct);
                    System.out.println("\n");

                    break;
                }
                case 5: {
                    System.out.println("Enter product id");
                    int productId = sc.nextInt();
                    displayWholesaler(productId);
                    System.out.println("\n");
                    break;
                }
                case 6: {
                    System.out.println("Enter product id");
                    int productId = sc.nextInt();
                    displayRetailer(productId);
                    System.out.println("\n");
                    break;
                }
                case 7:
                    break;
            }
            if(user==7){
                break;
            }
        }
    }

    static void genBill(int item, int price){
        System.out.println(item);
        System.out.println(price);
        double dis = 0.0;
        if(item>10 && item<50){
            dis = 0.1;
            //dis += (price*item *0.1);
        }
        else if(item>50 && item<100){
            dis = 0.2;
            //dis += (price*item *0.2);
        }
        else if(item>100){
            dis = 0.3;
            //dis += (price*item *0.3);
        }
        double tot_price;
        tot_price = (price * item)  - (dis * price);
        System.out.println(tot_price);

    }
    static void allocateWholesaler(int wholeSalerId, int productId, int itemCountToBuy) {
        for (Wholesaler eachWholesaler : wholesaler_details) {
            if (eachWholesaler.getWholesaler_id() == wholeSalerId) {
                for (Product eachProduct : products) {
                    if (eachProduct.getStock() > itemCountToBuy) {
                        if (eachProduct.getId() == productId) {
                            if (eachWholesaler.wholesaler_product_list.size() == 0) {
                                Product newProduct = new Product(eachProduct.getId(), eachProduct.getName(), eachProduct.getPrice(), itemCountToBuy);
                                eachWholesaler.setWholesaler_product_list(newProduct);
                                eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                                genBill(itemCountToBuy , eachProduct.getPrice());
                            } else {
                                int flag = 0;
                                for (Product checkProduct : eachWholesaler.wholesaler_product_list) {
                                    if (checkProduct.getId() == productId) {
                                        checkProduct.setStock(checkProduct.getStock() + itemCountToBuy);
                                        eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                                        flag = 1;
                                        genBill(itemCountToBuy , eachProduct.getPrice());

                                    }
                                    if (flag == 0) {
                                        Product newProduct = new Product(eachProduct.getId(), eachProduct.getName(),
                                                eachProduct.getPrice(), itemCountToBuy);
                                        eachWholesaler.setWholesaler_product_list(newProduct);
                                        eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                                        genBill(itemCountToBuy , eachProduct.getPrice());
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Wholesaler have Insufficient stock");
                    }
                }
            }
        }




    }
    static void RgenBill(int item, int price){
        System.out.println(item);
        System.out.println(price);
        double dis = 0.0;
        if(item>10 && item<50){
            dis = 0.05;
            //dis += (price*item *0.1);
        }
        else if(item>50 && item<100){
            dis = 0.1;
            //dis += (price*item *0.2);
        }
        else if(item>100){
            dis = 1.5;
            //dis += (price*item *0.3);
        }
        double tot_price;
        tot_price = (price * item)  - (dis * price);
        System.out.println(tot_price);

    }

    static void allocateRetailer(int retailerId, int wholeSalerId, int productId, int itemCountToBuy) {
        for (Retailer re : retailer_details) {
            if (re.getRetailer_id() == retailerId) {
                for (Wholesaler ws : wholesaler_details) {
                    if (ws.getWholesaler_id() == wholeSalerId) {
                        for (Product pr : ws.wholesaler_product_list) {
                            if (pr.getId() == productId) {
                                if (pr.getStock() > itemCountToBuy) {
                                    if (re.retailer_product_list.size() == 0) {
                                        Product newProduct = new Product(pr.getId(), pr.getName(), pr.getPrice(), itemCountToBuy);
                                        re.setRetailerProductList(newProduct);
                                        pr.setStock(pr.getStock() - itemCountToBuy);
                                        RgenBill(itemCountToBuy , pr.getPrice());
                                    } else {
                                        int flag = 0;
                                        for (Product checkProduct : re.retailer_product_list) {
                                            if (checkProduct.getId() == productId) {
                                                checkProduct.setStock(checkProduct.getStock() + itemCountToBuy);
                                                pr.setStock(pr.getStock() - itemCountToBuy);
                                                flag = 1;
                                                genBill(itemCountToBuy , pr.getPrice());

                                            }
                                            if (flag == 0) {
                                                Product newProduct = new Product(pr.getId(), pr.getName(),
                                                        pr.getPrice(), itemCountToBuy);
                                                re.setRetailerProductList(newProduct);
                                                pr.setStock(pr.getStock() - itemCountToBuy);
                                                RgenBill(itemCountToBuy , pr.getPrice());
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Wholesaler have Insufficient stock");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void displayProduct(int nameProduct) {
        for (Product itr : products) {
            if (itr.id == nameProduct) {
                System.out.println(itr.stock);
                break;
            }
        }
    }

    static void displayWholesaler(int productId) {
        for (int i = 0; i < wholesaler_details.size(); i++) {
            for (Product pr : wholesaler_details.get(i).wholesaler_product_list) {
                if (pr.getId() == productId) {
                    System.out.println("Wholesaler ID :" + wholesaler_details.get(i).getWholesaler_id() + " -- Wholesaler name :" + wholesaler_details.get(i).getWholesaler_name());
                    System.out.println("ProductId" + " " + "ProductName" + " " + "Price" + " " + "Stock");
                    System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice() + " " + pr.getStock());
                }
            }
        }
    }

    static void displayRetailer(int productId) {
        for (int i = 0; i < retailer_details.size(); i++) {
            for (Product pr : retailer_details.get(i).retailer_product_list) {
                if (pr.getId() == productId) {
                    System.out.println("Retailer ID :" + retailer_details.get(i).getRetailer_id() + " -- Retailer name :" + retailer_details.get(i).getRetailer_name());
                    System.out.println("ProductId" + " " + "ProductName" + " " + "Price" + " " + "Stock");
                    System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice() + " " + pr.getStock());
                }
            }
        }
    }
}
