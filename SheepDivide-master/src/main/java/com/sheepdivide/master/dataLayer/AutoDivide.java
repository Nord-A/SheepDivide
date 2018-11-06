package com.sheepdivide.master.dataLayer;

import com.sheepdivide.master.dataLayer.POJO.DivideSheep;
import com.sheepdivide.master.dataLayer.POJO.User;
import com.sheepdivide.master.dataLayer.database.CRUD.Read;
import com.sheepdivide.master.dataLayer.database.CRUD.Update;

import javax.sql.DataSource;
import java.util.List;

public class AutoDivide {
    private DataSource dataSource;

    public void setDataSource(DataSource ds){
        this.dataSource = ds;
    }

    //AutoSheepDivide. Divides all unowned sheep.
    public void divideRemainingSheep(int fieldId){
        Update up = new Update();
        Read re = new Read();
        up.setDataSource(dataSource);
        re.setDataSource(dataSource);
        List<User> users = calculateUserShares(fieldId); //List of all the users in a specific field.
        List<DivideSheep> unOwnedSheep = re.getUnOwnedSheep(); //List of all sheep without owners.
        List<DivideSheep> ownedSheep = re.getOwnedSheep(); //List of all sheep with owners.
        int k = 0; //Used to keep track of users in loops

        //Sets currentSheepPoints for all users in a specific field, if a user has claimed ownership of a sheep manually.
        for (int i = 0; i < ownedSheep.size(); i++){ //Loops through list of owned sheep.
            for (int l = 0; l < users.size(); l++){ //Loops through list of users.
                if (users.get(l).getUserId() == ownedSheep.get(i).getUserId()) { //Checks for matching userId's.
                    users.get(l).setCurrentSheepPoints(users.get(l).getCurrentSheepPoints() + ownedSheep.get(i).getSheepPoints()); //Adds sheepPoints to the users currentSheepPoints.
                    break;
                }
            }
        }

        //Divides unowned sheep among users in a specific field.
        for (int i = 0; i < unOwnedSheep.size(); i++){ //Loops through list of unowned sheep.
            if ((users.get(k).getAvailableSheepPoints() - 15) >= users.get(k).getCurrentSheepPoints() || k == users.size()-1) {             //Checks if availableSheepPoints is larger than currentSheepPoints. -15 to be more fair to the last user.
                up.autoAssignSheepOwner(users.get(k).getUserId(), unOwnedSheep.get(i).getSheepId()); //Updates in database.
                users.get(k).setCurrentSheepPoints(users.get(k).getCurrentSheepPoints() + unOwnedSheep.get(i).getSheepPoints());    //Adds sheepPoints to the users currentSheepPoints.
            }
            else {
                k++; //Next user
                i--; //To avoid skipping a sheep.
            }
        }

        System.out.println("2ndloop User1: " + users.get(0).getCurrentSheepPoints());
        System.out.println("2ndloop User2: " + users.get(1).getCurrentSheepPoints());
        System.out.println("2ndloop User3: " + users.get(2).getCurrentSheepPoints());
        //evt return disse værdier.
    }

    //Used in autoSheepDivide. Calculates availableSheepPoints for each user in a specific field.
    public List<User> calculateUserShares(int fieldId){
        Read DB = new Read();
        DB.setDataSource(dataSource);
        List<User> users = DB.getUserPercentShare(fieldId);
        double availableSheepPoints = (double)DB.getAllSheepPoints().get(0).getTotalSheepPoints();

        //Sets availableSheepPoints for all users in a specific field.
        for (int i = 0; i < users.size(); i++){
            users.get(i).setAvailableSheepPoints((int)(availableSheepPoints/100.0*users.get(i).getPercentShare()));
        }
        //Test
        System.out.println("Total before divide: " + availableSheepPoints);
        System.out.println(users.get(0).getUserId() + ": " + users.get(0).getAvailableSheepPoints());
        System.out.println(users.get(1).getUserId() + ": " + users.get(1).getAvailableSheepPoints());
        System.out.println(users.get(2).getUserId() + ": " + users.get(2).getAvailableSheepPoints());
        System.out.println("Total after divide: " + (users.get(0).getAvailableSheepPoints() + users.get(1).getAvailableSheepPoints() + users.get(2).getAvailableSheepPoints()));
        return users;
    }
}

