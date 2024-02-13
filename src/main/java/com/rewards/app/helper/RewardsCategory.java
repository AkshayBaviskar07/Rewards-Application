package com.rewards.app.helper;

import com.rewards.app.entities.User;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RewardsCategory{
   public boolean redeemRewards(User user){
       boolean exitOpt = true;
       int points = 0;  //calculate points

       ArrayList<String> categories=new ArrayList<>();
       categories.add("1.Electronics");
       categories.add("2.Clothing");
       categories.add("3.Gift cards");
       categories.add("4.Exit");

       categories.forEach(System.out::println);

       HashMap<Integer, String> electronics = new HashMap<>();
       electronics.put(1, "BOAT - earbuds : 1000 points");
       electronics.put(2, "FireBolt - Smart Watch : 2000 points");

       HashMap<Integer, String> clothing = new HashMap<>();
       clothing.put(1, "CottonKing shirt : 750 points");
       clothing.put(2, "Levis T-shirt : 650 points");

       HashMap<Integer, String> giftCards = new HashMap<>();
       giftCards.put(1, "Amazon gift voucher : 200 points");
       giftCards.put(2, "FlipKart gift voucher : 200 points");
       giftCards.put(3, "D-Mart gift voucher : 200 points");

       Scanner sc = new Scanner(System.in);
       int catChoice = sc.nextInt();    //category choice to choose rewards category

       int choice;

       switch(catChoice){
           case 1:
               System.out.println("---------------------------------------");
               System.out.println("   Electronics Rewards category");
               System.out.println("---------------------------------------");

               for(Map.Entry<Integer,String>entry : electronics.entrySet())
                   System.out.println(entry.getKey()+" : "+entry.getValue());

               System.out.println("Enter your choice..");
               choice = sc.nextInt();

               if(choice == 1){
                   if((user.getPoints() - 1000) > 0){
                       points = user.getPoints() - 1000;
                       user.setPoints(points);
                       user.giftRewards.add("BOAT - earbuds");
                       System.out.println("You have redeemed 1000 points");
                   } else{
                       //points are not sufficient
                       System.out.println("Insufficient points to redeemed");
                       System.out.println("Available points : "+user.getPoints());
                   }
               }
               if(choice == 2){
                   if((user.getPoints() - 2000) > 0){
                       points = user.getPoints() - 2000;
                       user.setPoints(points);
                       user.giftRewards.add("FireBolt - Smart Watch");
                       System.out.println("You have redeemed 2000 points");
                   } else{
                       //points are not sufficient
                       System.out.println("Insufficient points to redeemed");
                       System.out.println("Available points : "+user.getPoints());
                   }
               }
               break;

           case 2:
               System.out.println("---------------------------------------");
               System.out.println("   Clothing Rewards category");
               System.out.println("---------------------------------------");

               for(Map.Entry<Integer,String> entry: clothing.entrySet())
                   System.out.println(entry.getKey()+" : "+entry.getValue());

               System.out.println("Enter your choice..");
               choice = sc.nextInt();

               if(choice == 1){
                   if((user.getPoints() - 750) > 0){
                       points = user.getPoints()-750;
                       user.setPoints(points);
                       user.giftRewards.add("CottonKing shirt");
                       System.out.println("You have redeemed 750 points");
                   } else{
                       //points are not sufficient
                       System.out.println("Insufficient points to redeemed");
                       System.out.println("Available points : "+user.getPoints());
                   }
               }
               if(choice == 2){
                   if((user.getPoints() - 650) > 0){
                       points = user.getPoints() - 650;
                       user.setPoints(points);
                       user.giftRewards.add("Levis T-shirt");
                       System.out.println("You have redeemed 650 points");
                   } else{
                       //points are not sufficient
                       System.out.println("Insufficient points to redeemed");
                       System.out.println("Available points : "+user.getPoints());
                   }
               }
               break;

           case 3:
               System.out.println("---------------------------------------");
               System.out.println("   Gift-Cards category");
               System.out.println("---------------------------------------");

               for(Map.Entry<Integer,String> entry : giftCards.entrySet())
                   System.out.println(entry.getKey()+" : "+entry.getValue());

               System.out.println("Enter your choice..");
               choice = sc.nextInt();

               if(choice == 1){
                   if((user.getPoints() - 200) > 0){
                       points = user.getPoints() - 200;
                       user.setPoints(points);
                       long coupon = generateRandomNum();
                       user.giftRewards.add("Amazon gift voucher");
                       System.out.println("Coupon Code : "+"AMAZN"+coupon);
                       System.out.println("You have redeemed 200 points");
                   } else{
                       //points are not sufficient
                       System.out.println("Insufficient points to redeemed");
                       System.out.println("Available points : "+user.getPoints());
                   }
               }
               if(choice == 2){
                   if((user.getPoints() - 200) > 0){
                       points = user.getPoints() - 200;
                       user.setPoints(points);
                       long coupon = generateRandomNum();
                       user.giftRewards.add("FlipKart gift voucher");
                       System.out.println("Coupon Code : "+"FLPKRT"+coupon);
                       System.out.println("You have redeemed 200 points");
                   } else{
                       //points are not sufficient
                       System.out.println("Insufficient points to redeemed");
                       System.out.println("Available points : "+user.getPoints());
                   }
               }
               if(choice == 3){
                   if((user.getPoints() - 200) > 0){
                       points = user.getPoints() - 200;
                       user.setPoints(points);
                       long coupon = generateRandomNum();
                       user.giftRewards.add("D-Mart gift voucher");
                       System.out.println("Coupon Code : "+"DMRT"+coupon);
                       System.out.println("You have redeemed 200 points");
                   } else{
                       //points are not sufficient
                       System.out.println("Insufficient points to redeemed");
                       System.out.println("Available points : "+user.getPoints());
                   }
               }
               break;

           default:
               exitOpt = false;
               System.out.println("----------------------------------");
               System.out.println("See you soon....");
       }
       return exitOpt;
   }

   //generates a random number for coupon code
   public long generateRandomNum(){
       Random random = new Random();
       return ThreadLocalRandom.current().nextLong();
   }
}
