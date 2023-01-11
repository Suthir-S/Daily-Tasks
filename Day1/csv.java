import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class csv
{
    public static void main(String[] args) throws Exception
    {
        //Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
        //sc.useDelimiter(",");
        ArrayList<String> ar=new ArrayList<>();
        ArrayList<String> ar1=new ArrayList<>();
        ArrayList<String> ar2=new ArrayList<>();
        ArrayList<String> ar3=new ArrayList<>();

        for(int i=0;i<6;i++) {
            if(i==0){
                Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
                while (sc.hasNextLine()) {
                    String ss = sc.nextLine();
                    String[] x = ss.split(",");
                    ar.add(x[i]);
                }
                //System.out.println(ar.get(i));
            }
            else if (i == 1)
            {
                Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
                while (sc.hasNextLine())
                {
                    String ss = sc.nextLine().replaceAll("( )+", " ");
                    String sss = ss.trim().replaceAll(" +", " ");
                    String[] x = ss.split(",");
                    ar1.add(x[i]);

                }
                //System.out.println(ar.get(i));

            }
            else if (i == 2)
            {
                Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
                while (sc.hasNextLine())
                {
                    String ss = sc.nextLine().replaceAll("( )+", " ");
                    String sss = ss.trim().replaceAll(" +", " ");
                    String[] x = ss.split(",");
                    ar2.add(x[i]);

                }
                //System.out.println(ar.get(i));

            }
            else if (i == 3)
            {
                Scanner sc = new Scanner(new File("/Users/suthir/Downloads/Product.csv"));
                while (sc.hasNextLine())
                {
                    String ss = sc.nextLine().replaceAll("( )+", " ");
                    String sss = ss.trim().replaceAll(" +", " ");
                    String[] x = ss.split(",");
                    ar3.add(x[i]);

                }
                //System.out.println(ar.get(i));

            }

        }

        ar.remove(0);
        ar1.remove(0);
        ar2.remove(0);
        ar3.remove(0);

        String[] id=ar.toArray(new String[ar.size()]);
        String[] pro_name=ar1.toArray(new String[ar1.size()]);
        String[] tprice=ar2.toArray(new String[ar2.size()]);
        String[] tstock=ar3.toArray(new String[ar3.size()]);


        int si_pri = tprice.length;
        int[] price=new int[si_pri];
        for(int i=0;i<si_pri;i++){
            price[i]=Integer.parseInt(tprice[i]);
        }

        int si_sto = tstock.length;
        int[] stock=new int[si_sto];
        for(int i=0;i<si_sto;i++){
            stock[i]=Integer.parseInt(tstock[i]);
        }


        for(int i=0;i<5;i++) {
            System.out.println(id[i]);
        }
        for(int i=0;i<5;i++) {
            System.out.println(pro_name[i]);
        }
        for(int i=0;i<5;i++) {
            System.out.println(price[i]);
    }
        for(int i=0;i<5;i++) {
            System.out.println(stock[i]);
        }
        //System.out.println(ar1.get(i));
          //  sc.close();
    }
}
