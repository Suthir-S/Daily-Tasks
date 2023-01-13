import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManagement {

    static ArrayList<Wholesaler> wList = new ArrayList<>();
    static ArrayList<Product> pList = new ArrayList<>();
    static ArrayList<Retailer> rList = new ArrayList<>();

    static ArrayList<String> w_products = new ArrayList<>();
    static ArrayList<String> r_products = new ArrayList<>();
    static Map<String, ArrayList<Product>> wMap = new HashMap<String, ArrayList<Product>>();

    public static void disp_prod() {
        for (Product product : pList) {
            System.out.print(product.id + "\t" + product.name + "\t" + product.price + "\t" + product.p_stock + "\n");
        }
    }

    public static void disp_wdetail() {
        for (Wholesaler det1 : wList) {
            System.out.print(det1.w_loc + "\n");
        }

    }

    public static void disp_rdetail() {
        for (Retailer det : rList) {
            System.out.print(det.r_name + "\n");
        }
    }

    /*
        public static void protpwsale(String wid,String id,int cou){
            for(Product pro: pList){
                if(pro.id.equals(id)){
                    if(Integer.parseInt(pro.p_stock)>=cou){
                        pro.p_stock = String.valueOf(Integer.parseInt(pro.p_stock)- cou);
                    }
                    else{
                        System.out.println("Stock not available");
                    }
                }

                System.out.print(pro.id + "\t" + pro.name + "\t" + pro.price + "\t" + pro.p_stock + "\n");
            }
            for(Wholesaler who : wList){
                System.out.println(who.w_loc);
            }
                if(who.loc.equals(wid)){
                    for(Product pro1 : pList){
                        if(pro1.id.equals(id)){
                            wList.add(pro1);
                        }
                    }
                }
            }
        }
    */
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
            while (sc.hasNextLine()) {
                String[] prod_data = sc.next().split(",", 4);
                pList.add(new Product(prod_data[0], prod_data[1], prod_data[2], prod_data[3]));
            }
            sc.close();
        } catch (Exception f) {
            System.out.println(f);
        }

        try {
            Scanner sc1 = new Scanner(new File("/Users/suthir/Downloads/wholesaler1.csv"));
            while (sc1.hasNextLine()) {
                String[] w_data = sc1.next().split(",");
                wList.add(new Wholesaler(w_data[0]));
            }
            sc1.close();
        } catch (Exception f) {
            System.out.println(f);
        }

        try {
            Scanner sc2 = new Scanner(new File("/Users/suthir/Downloads/Retailer1.csv"));
            while (sc2.hasNextLine()) {
                String[] r_data = sc2.next().split(",", 3);
                rList.add(new Retailer(r_data[0]));
            }
            sc2.close();
        } catch (Exception f) {
            System.out.println(f);
        }

        Scanner inp = new Scanner(System.in);
        int nu = 0;
        while (nu != 3) {
            System.out.println("Enter Mode\n1.Display\n2.Buy\n3.Exit\n");
            nu = inp.nextInt();
            switch (nu) {
                case 1:
                    System.out.println("\nEnter Display Mode\n10.Product Stock\n20.Wholesaler Detail\n30.Retailer Detail");
                    int nu2 = inp.nextInt();
                    switch (nu2) {
                        case 10:
                            disp_prod();
                            break;
                        case 20:
                            disp_wdetail();
                            break;
                        case 30:
                            disp_rdetail();
                            break;
                        default:
                            System.out.println("Default");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\nEnter Display Mode\n10.Product Stock\n20.Wholesaler Detail\n30.Retailer Detail");
                    int nu3 = inp.nextInt();
                    switch (nu3) {
                        case 10:
                            disp_prod();
                            break;
                        case 20:
                            disp_wdetail();
                            break;
                        case 30:
                            disp_rdetail();
                            break;
                        //isp_prod();
//                        System.out.println("Enter Wholesaler name item to buy : ");
//                        String wid1 = inp.nextLine();
//                        System.out.println("Enter Product id item to buy : ");
//                        String id1 = inp.next();
//                        System.out.println("Enter Product count item to buy : ");
//                        int p_stock1 = inp.nextInt();
//                        //protpwsale(wid1, id1,p_stock1);
//                        break;
                        case 3:
                            break;
                    }
                    if (nu == 3) {
                        break;
                    }
            }


        }
    }
}