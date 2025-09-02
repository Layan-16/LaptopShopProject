import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       
       char selection;
       
       final int priceD = 2500;
       final int priceL = 2000;
       final int priceM = 5000;
       
       int quantityD = 0;
       int quantityL = 0;
       int quantityM = 0;
       
       int counterD = 0;
       int counterL = 0;
       int counterM = 0;
       
       int totalD = 0;
       int totalL = 0;
       int totalM = 0;
       
       int subtotal = 0;
       
       String name;
       String mobileNum;
       
       System.out.println("------------------------------------");
       System.out.println("Wellcome to the laptop store!");
       System.out.println("------------------------------------");
       
       do{
           System.out.println("D: Dell (Price 2500 SAR)");
           System.out.println("L: Lenovo (Price 2000 SAR)");
           System.out.println("M: MacBook (Price 5000 SAR)");
           System.out.println("B: To get the bill\n");
           
           System.out.print("Enter your selection: ");
           selection = sc.next().charAt(0);
           
           if(selection == 'D' || selection == 'd'){
               System.out.print("Enter quantity: ");
               quantityD = sc.nextInt();
               counterD++;
               System.out.println();
           }
           else if(selection == 'L' || selection == 'l'){
               System.out.print("Enter quantity: ");
               quantityL = sc.nextInt();
               counterL++;
               System.out.println();
           }
           else if(selection == 'M' || selection == 'm'){
               System.out.print("Enter quantity: ");
               quantityM = sc.nextInt();
               counterM++;
               System.out.println();
           }
           else if(selection == 'B' || selection == 'b'){
               break;
           }
           else{
               System.out.println("Invalid option. Please try again.\n");
           }
       }
       while(selection != 'B' && selection != 'b');
       
       if(counterD == 0 && counterL == 0 && counterM == 0){
           System.out.println("Nothing selected!");
           return;
       }
       
       System.out.println("------------------------------------");
       
       sc.nextLine();
       System.out.print("Enter your name: ");
       name = sc.nextLine();
       
       do{
            System.out.print("Enter your mobile number: ");
            mobileNum = sc.nextLine();
       }
       while(!isValidMobile(mobileNum));
       
       System.out.println("Hi "+name+",");
       System.out.println("--------------Details---------------");
       System.out.println("Item     Quantity     Total Price");
       
       if(counterD > 0){
           totalD = quantityD * priceD;
           System.out.println("Dell     "+quantityD+"           "+totalD);  
       }
       if (counterL > 0){
           totalL = quantityL * priceL;
           System.out.println("Lenovo   "+quantityL+"           "+totalL);
       }
       if (counterM > 0){
           totalM = quantityM * priceM;
           System.out.println("MacBook  "+quantityM+"           "+totalM);
       }
       
       subtotal = totalD + totalL + totalM;
       
       System.out.println("------------------------------------");
       System.out.println("Subtotal: "+subtotal);
       System.out.println("Total Price: "+calculateTax(subtotal)+" SAR");
       System.out.println("------------------------------------");
       System.out.println("Thank you for shopping with us!");
    }
    
    public static boolean isValidMobile(String mobileNum){
        
        if(mobileNum.charAt(0) == '0' && mobileNum.length() == 10 ){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static double calculateTax(int subtotal){
        
        final double rate = 0.15;
        
        double tax;
        double totalPrice;
        
        tax = subtotal * rate;
        totalPrice = subtotal + tax;
        
        System.out.println("Tax: "+tax);
        
        return totalPrice;
    }
}
