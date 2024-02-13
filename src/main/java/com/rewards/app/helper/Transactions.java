package com.rewards.app.helper;

import com.rewards.app.entities.User;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Transactions implements Runnable{

    User user;
    public Transactions(User user){
        this.user = user;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        boolean flag=true;
        try{
            RewardsCategory rewardsCategory = new RewardsCategory();
            Random random = new Random();
            int max = 1000000;
            int min = 10000;

            //generate random amount
            int randomAmount = ThreadLocalRandom.current().nextInt(min, max);
            user.setAmount(randomAmount);
            Thread.sleep(5000);
            System.out.println("Total Transaction: "+user.getAmount());
            System.out.println("----------------------------------------------");
            int rewardPoints = randomAmount/100;
            user.setPoints(rewardPoints);

            boolean exitOpt = true;
            while(flag){
                System.out.println("Total redeem points: "+user.getPoints());
                System.out.println("----------------------------------------------");
                exitOpt = rewardsCategory.redeemRewards(user);

                if(!user.giftRewards.isEmpty()){
                    int redeemPoints = rewardPoints-user.getPoints();
                    System.out.println("You have redeem "+redeemPoints+" points under following categories.");
                    user.giftRewards.forEach(System.out::println);
                }

                System.out.println();
                System.out.println("Remaining points: "+user.getPoints());
                System.out.println("----------------------------------------------");
                if(user.getPoints() > 0){
                    if(!exitOpt){
                        flag=false;
                    } else{
                        System.out.println("Do you want to play again press Y/N");
                        String playAgain = sc.next();

                        if(playAgain.equalsIgnoreCase("y"))
                            flag=true;
                        else if(playAgain.equalsIgnoreCase("n"))
                            flag=false;
                        else
                            System.out.println("Invalid option.Enter correct option.");
                    }
                } else{
                    System.out.println("do not have sufficient points.");
                }
            }

        }catch (InterruptedException ie){
            ie.printStackTrace();
        }catch (InputMismatchException ime){
            System.out.println("Invalid input.");
            ime.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
