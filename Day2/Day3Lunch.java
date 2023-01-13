import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



class Product {

    static String[] pro_name ;//= {"Moto", "Samsung", "Apple", "Poco", "redmi"};
    static int[] price ;//= {10000, 12000, 50000, 9000, 9500};
    static int[] stock;// = {10, 10, 10, 10, 10};


    public void initi() throws Exception {
        ArrayList<String> ar = new ArrayList<>();
        ArrayList<String> ar1 = new ArrayList<>();
        ArrayList<String> ar2 = new ArrayList<>();
        ArrayList<String> ar3 = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
                while (sc.hasNextLine()) {
                    String ss = sc.nextLine();
                    String[] x = ss.split(",");
                    ar.add(x[i]);
                }
            } else if (i == 1) {
                Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
                while (sc.hasNextLine()) {
                    String ss = sc.nextLine();
                    String sss = ss.trim();
                    String[] x = ss.split(",");
                    ar1.add(x[i]);

                }

            } else if (i == 2) {
                Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
                while (sc.hasNextLine()) {
                    String ss = sc.nextLine();
                    String sss = ss.trim();
                    String[] x = ss.split(",");
                    ar2.add(x[i]);

                }

            } else if (i == 3) {
                Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
                while (sc.hasNextLine()) {
                    String ss = sc.nextLine();
                    String sss = ss.trim();
                    String[] x = ss.split(",");
                    ar3.add(x[i]);

                }

            }

        }

        ar.remove(0);
        ar1.remove(0);
        ar2.remove(0);
        ar3.remove(0);

        String[] id = ar.toArray(new String[ar.size()]);
        pro_name = ar1.toArray(new String[ar1.size()]);
        String[] tprice = ar2.toArray(new String[ar2.size()]);
        String[] tstock = ar3.toArray(new String[ar3.size()]);

        int si_pri = tprice.length;
        price = new int[si_pri];
        for (int i = 0; i < si_pri; i++) {
            price[i] = Integer.parseInt(tprice[i]);
        }

        int si_sto = tstock.length;
        stock = new int[si_sto];
        for (int i = 0; i < si_sto; i++) {
            stock[i] = Integer.parseInt(tstock[i]);
        }
    }


    public void Product()
    {
        System.out.println("Stock Available Products");
        for (int i = 0; i < pro_name.length; i++) {
            System.out.println(i + " " + pro_name[i] + " Count " + stock[i]);
        }
    }
}
class wholesaler extends Product{
    static int[] w_stock={0,0,0,0,0};
    public void items(){
//        System.out.println("Available Products");
//        for(int i=0;i<pro_name.length;i++){
//            System.out.println(i+" "+pro_name[i] +" Count "+stock[i]);
//        }
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int cou = inp.nextInt();
        if(cou>stock[num]){
            System.out.println("Stock not exist");
        }
        else{
            System.out.println("You have to pay Rs."+price[num]);
            stock[num]-=cou;
            w_stock[num]+=cou;
        }
    }
    public void availpro(){
        System.out.println("Wholesaler Available Products\n");
        for(int i=0;i<pro_name.length;i++){
            System.out.println(i+" "+pro_name[i] +" Count "+w_stock[i]);
        }
    }
}

class phoneWorld extends wholesaler{
    int[] r1_stock={0,0,0,0,0};
    int[] r1_price = {10500,12500,55500,9500,10000};
    public void items(){
        //System.out.println("\nWholesaler Available Products");
        //for(int i=0;i<pro_name.length;i++){
        //    System.out.println(i+" "+pro_name[i] +" Count "+w_stock[i]);
        //}
        System.out.println("Enter Product and Count");
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int cou = inp.nextInt();
        if(cou>w_stock[num]){
            System.out.println("Stock not exist");
        }
        else{
            System.out.println("For each You have to pay Rs."+r1_price[num]);
            r1_stock[num]+=cou;
            w_stock[num]-=cou;
//            System.out.println("Wholesaler Available Products\n");
//            for(int i=0;i<pro_name.length;i++){
//                System.out.println(i+" "+pro_name[i] +" Count "+w_stock[i]);
//            }
        }
    }
    public void ph_availpro(){
        System.out.println("phoneWorld Available Products\n");
        for(int i=0;i<pro_name.length;i++){
            System.out.println(i+" "+pro_name[i] +" Count "+r1_stock[i]);
        }
    }
}
class MobZone extends wholesaler{
    int[] r2_stock={0,0,0,0,0};
    int[] r2_price = {11000,13000,56500,11000,13000};
    public void items(){
        //System.out.println("\nWholesaler Available Products");
        //for(int i=0;i<pro_name.length;i++){
        //    System.out.println(i+" "+pro_name[i] +" Count "+r2_stock[i]);
        //}
        System.out.println("Enter Product and Count");
        Scanner inp = new Scanner(System.in);
        int num = inp.nextInt();
        int cou = inp.nextInt();
        if(cou>w_stock[num]){
            System.out.println("Stock not exist");
        }
        else{
            System.out.println("For each You have to pay Rs."+r2_price[num]);
            r2_stock[num]+=cou;
            w_stock[num]-=cou;
//            System.out.println("Wholesaler Available Products\n");
//            for(int i=0;i<pro_name.length;i++){
//                System.out.println(i+" "+pro_name[i] +" Count "+w_stock[i]);
//            }
        }
    }
    public void Mob_availpro(){
        System.out.println("MobZone Available Products\n");
        for(int i=0;i<pro_name.length;i++){
            System.out.println(i+" "+pro_name[i] +" Count "+r2_stock[i]);
        }
    }
}
public class Day3Lunch {
    public static void main(String args[]) throws Exception{
        Scanner tyin = new Scanner(System.in);
        int sw = 0;
        wholesaler w = new wholesaler();
        w.initi();
        phoneWorld p = new phoneWorld();
        MobZone m = new MobZone();
        while(sw!=8){
            System.out.println("Enter the case you need to perform:\n1.Display Product Stock\n2.Display Wholesaler Stock\n3.Display phoneWorld Stock\n4.Display MobZone stock\n5.Wholesaler\n6.phoneWorld\n7.MobZone\n8.Exit");
            sw=tyin.nextInt();
            switch(sw){
                case 1:
                    w.Product();
                    break;
                case 2:
                    w.availpro();
                    break;
                case 3:
                    p.ph_availpro();
                    break;
                case 4:
                    m.Mob_availpro();
                    break;
                case 5:
                    w.Product();
                    //w.sto_items();
                    w.items();
                    w.availpro();
                    break;
                case 6:
                    w.availpro();
                    p.items();
                    p.ph_availpro();
                    break;
                case 7:
                    w.availpro();
                    m.items();
                    m.Mob_availpro();
                    break;
                case 8:
                    break;
            }
            if(sw==8){
                break;
            }
        }
    }
}
