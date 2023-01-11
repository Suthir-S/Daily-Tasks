import java.util.Scanner;
class Product{
    static String[] pro_name = {"Moto","Samsung","Apple","Poco","redmi"};
    static String pro_type = "Phones";
    static String pro_category = "Electronics";
    static int[] price = {10000,12000,50000,9000,9500};
    static int[] stock = {10,10,10,10,10};
    public void Product() {
        System.out.println("Stock Available Products");
        for (int i = 0; i < pro_name.length; i++) {
            System.out.println(i + " " + pro_name[i] + " Count " + stock[i]);
        }
    }
}
class wholesaler extends Product{
    static int[] w_stock={0,0,0,0,0};
    public void items(){
        System.out.println("Available Products");
        for(int i=0;i<pro_name.length;i++){
            System.out.println(i+" "+pro_name[i] +" Count "+stock[i]);
        }
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
            System.out.println("Product type\n"+pro_type);
            System.out.println("Product Category\n"+pro_category+"\n");
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
            System.out.println("You have to pay Rs."+r1_price[num]);
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
            System.out.println("You have to pay Rs."+r2_price[num]);
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
    public static void main(String args[]){
        Scanner tyin= new Scanner(System.in);
        int sw = 0;
        wholesaler w = new wholesaler();
        phoneWorld p = new phoneWorld();
        MobZone m = new MobZone();
        while(sw!=4){
            System.out.println("Enter the case you need to perform:\n1.Wholesaler\n2.phoneWorld\n3.MobZone\n4.Exit");
            sw=tyin.nextInt();
            switch(sw){
                case 1:
                    w.items();
                    w.availpro();
                    w.Product();
                    break;
                case 2:
                    p.items();
                    p.ph_availpro();
                    break;
                case 3:
                    w.availpro();
                    m.items();
                    m.Mob_availpro();
                    break;
                case 4:
                    break;
            }
            if(sw==4){
                break;
            }
        }
    }
}
