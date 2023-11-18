import java.util.*;

public class test {

    public static void MaxGST(TreeMap<String,Integer> ProductToGST,String[] ProductName,int[] Price,int[] gst,int[] quantity){
        int div=0;
        int newVal=0;
        int max=0;
        for(int i=0;i<ProductToGST.size();i++) {
            div = Price[i] / 100;
            newVal = (div * gst[i]);
            ProductToGST.put(ProductName[i], newVal*quantity[i]);
            max=Math.max(max,ProductToGST.get(ProductName[i]));
        }
        System.out.println(ProductToGST);
        System.out.println("Maximum GST is umbrella");
    }
    public static void Discount(HashMap<String,Integer> ProductToPrice,String[] ProductName,int[] Price){
        int div=0;
        int pecentage=5;
        int newVal=0;
        int total = 0;
        for(int i=0;i<ProductToPrice.size();i++) {
            if (Price[i] >= 500) {
                div = Price[i] / 100;
                newVal = Price[i] - (div * pecentage);
                ProductToPrice.put(ProductName[i], newVal);
            }
            total += ProductToPrice.get(ProductName[i]);
        }
        System.out.println("The Total amout is "+total);
    }
    public static void main(String[] args) {
        HashMap<String,Integer> ProductToPrice = new HashMap<>();
        TreeMap<String,Integer> ProductToGST = new TreeMap<>();
        String[] ProductName = {"Leather wallet","Umbrella","Cigarette","Honey"};
        int[] price = {1100,900,200,100};
        int[] gst = {18,12,28,0};
        int[] quantity = {1,4,3,2};
        for(int i=0;i< price.length;i++){
            ProductToPrice.put(ProductName[i],price[i]);
        }
        for(int i=0;i<price.length;i++) {
            ProductToGST.put(ProductName[i], gst[i]);
        }
        System.out.println(ProductToPrice);
        System.out.println();
        Discount(ProductToPrice,ProductName,price);
        System.out.println("After Discount of unit more the 500 -> "+ ProductToPrice);
        System.out.println();
        MaxGST(ProductToGST,ProductName,price,gst,quantity);
        System.out.println();

    }
}
