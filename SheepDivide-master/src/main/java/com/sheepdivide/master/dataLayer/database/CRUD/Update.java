package com.sheepdivide.master.dataLayer.database.CRUD;

import com.sheepdivide.master.dataLayer.database.CRUD.Interfaces.UpdateDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Update implements UpdateDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource ds){
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    //Used in autoSheepDivide. Assigns owner to a single sheep. Used in divideRemainingSheep(autoSheepDivide).
    public void autoAssignSheepOwner(int userId, String sheepId){
        String sql = "UPDATE sheep SET userId = ? WHERE sheepId = ?";
        jdbcTemplateObject.update(sql, userId, sheepId);
    }

    //Assigns owner to a single sheep. Used to manually assign owner.
    public void assignSheepOwner(String username, String sheepId){ //int userId
        int userId = 0;
        String lowercase = username.toLowerCase();

        //Bad practice! Won't work if more users are added.
        if (lowercase.equals("hennic"))
            userId = 1;
        else if (lowercase.equals("jontho"))
            userId = 2;
        else if (lowercase.equals("stenae"))
            userId = 3;
        String sql = "UPDATE sheep SET userId = ? WHERE sheepId = ?";
        jdbcTemplateObject.update(sql, userId, sheepId);
    }

    //Clears all sheep owners.
    public void clearAllSheepOwners(){
        String sql = "UPDATE sheep SET userId = NULL";
        jdbcTemplateObject.update(sql);
    }

    //Updates all Sheep values except sheepId and userId.
    public void updateAllValues(int sheepWeight, String sheepType, int sheepWool, int sheepHorns, int sheepLegs, String note, String sheepId){
        String sql = "UPDATE sheep SET weightKg = ?, typeOfSheep = ?, wool = ?, horns = ?, legs = ?, note = ? WHERE sheepId = ?";
        jdbcTemplateObject.update(sql, sheepWeight, sheepType, sheepWool, sheepHorns, sheepLegs, note, sheepId);
    }
}
