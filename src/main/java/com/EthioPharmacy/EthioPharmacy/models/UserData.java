package com.EthioPharmacy.EthioPharmacy.models;
import com.EthioPharmacy.EthioPharmacy.models.User;

import java.util.ArrayList;
import java.util.List;
public class UserData {

    static ArrayList<User> users = new ArrayList<>();
    public static List<User> getUsers(){
        return users;
    }
    
}
