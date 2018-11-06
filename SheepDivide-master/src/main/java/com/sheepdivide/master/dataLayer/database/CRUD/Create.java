package com.sheepdivide.master.dataLayer.database.CRUD;

import com.sheepdivide.master.dataLayer.database.CRUD.Interfaces.CreateDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Create implements CreateDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource ds){
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    //Inserts a sheep into database with all values except userId.
    public void registerSheep(String sheepId, String sheepType, int sheepWeight, int sheepWool, int sheepHorns, int sheepLegs, String note){
        String sql = "INSERT INTO sheep(sheepId, weightKg, typeOfSheep, wool, horns, legs, note) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(sql, sheepId, sheepWeight, sheepType, sheepWool, sheepHorns, sheepLegs, note);
    }
}
