package com.rewardsApp.helper;

import com.rewardsApp.entities.User;

public class UserService {

    User user[] = new User[10];

    public UserService(){
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
}
