package com.example.xpdayone.businesslogic;

import com.example.xpdayone.model.Database;
import com.example.xpdayone.model.User;
import java.text.DecimalFormat;
import java.util.List;

public class StatsCalculator {

    private Database database;
    public StatsCalculator(Database database) {
        this.database = database;
    }

    public double getAverageAmount(){
        double sum = 0.0;
        List<User> users = database.getAllUsers();
        for (User user : users) {
            sum += user.getAmount();
        }
        double avg = sum / users.size();
        return avg;
    }
}
