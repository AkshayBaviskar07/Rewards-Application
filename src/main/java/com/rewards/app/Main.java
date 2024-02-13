package com.rewards.app;

import com.rewards.app.entities.User;
import com.rewards.app.helper.Transactions;
import com.rewards.app.helper.UserService;

public class Main {
    public static void welcomeMsg(){
        System.out.println("==========================================================================");
        System.out.println("             Welcome to rewards application.                                      ");
        System.out.println("On every 100/- spent, you will get 1 point as reward.");
        System.out.println("You can redeem these points to purchase items from various categories.");
        System.out.println("==========================================================================");
    }

    public static void main(String[] args) {
        welcomeMsg();
        UserService userService = new UserService();
        User regUser = userService.validateUser(userService);

        if(null != regUser){
            Transactions transactions = new Transactions(regUser);
            Thread thread = new Thread(transactions);
            thread.start();
        } else{
            System.out.println("Please try again.");
        }
    }
}