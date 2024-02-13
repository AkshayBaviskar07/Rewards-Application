package com.rewards.app.helper;

import com.rewards.app.entities.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserService {

    User user[] = new User[10];     //creates user array

    public UserService(){
        // initializing user array while creating object

        user[0] = new User(1, "Akshay", "Akshay", 1000);
        user[1] = new User(2, "Roopa", "Roopa", 1000);
        user[2] = new User(3, "Vidya", "Vidya", 1000);
        user[3] = new User(4, "John", "John", 1000);
        user[4] = new User(5, "Ved", "Ved", 1000);
        user[5] = new User(4, "Aditi", "Aditi", 1000);
        user[6]= new User(5, "Prachi", "Prachi", 1000);
        user[7] = new User(5, "Hitha", "Hitha", 1000);
        user[8] = new User(4, "Diya", "Diya", 1000);
        user[9]= new User(5, "Prachet", "Prachet", 1000);
    }

    /*
        This method will validate user login credential and will return user if credential matches
    * */
    public User validateUser(UserService userService){
        Scanner scanner = new Scanner(System.in);
        User regUser = null;
        boolean loginUser = false;

        try{
            System.out.println("Enter user-name: ");
            String userName = scanner.next();
            System.out.println("Enter password: ");
            String passWord = scanner.next();

            for(User user : userService.user){
                if(null != user && (userName.equalsIgnoreCase(user.getName()) && passWord.equalsIgnoreCase(user.getPassword())))
                {
                    loginUser = true;
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Login Successfully..");
                    System.out.println("Calculating rewards points..");

                    regUser = user;
                    return regUser;
                }
            }

            InvalidUserException ie = new InvalidUserException("Wrong creadential..");
            System.out.println(ie.getMessage());
            throw ie;
        } catch(InvalidUserException iue) {
            System.out.println("Enter valid credential or you will blocked..");
            System.out.println("-----------------------------------------------------------");

            try {
                System.out.println("Enter user-name: ");
                String userName = scanner.next();
                System.out.println("Enter password: ");
                String passWord = scanner.next();

                for (User user : userService.user) {
                    if (null != user && (userName.equalsIgnoreCase(user.getName()) && passWord.equalsIgnoreCase(user.getPassword()))) {
                        loginUser = true;
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Login Successfully..");
                        System.out.println("Calculating rewards points..");

                        regUser = user;
                        return regUser;
                    }
                }

                if (!loginUser) {
                    InvalidUserException ie = new InvalidUserException("Wrong creadential..");
                    System.out.println(ie.getMessage());
                    throw ie;
                }
            } catch (InvalidUserException ie) {
                System.out.println("Blocked for some time.....");
            } catch (Exception e) {
                System.out.println("Something went wrong...");
                e.printStackTrace();
            }
        }
        return regUser;
    }
}
