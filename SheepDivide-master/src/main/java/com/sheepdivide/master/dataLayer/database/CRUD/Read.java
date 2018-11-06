package com.sheepdivide.master.dataLayer.database.CRUD;

import com.sheepdivide.master.dataLayer.POJO.*;
import com.sheepdivide.master.dataLayer.database.CRUD.Interfaces.ReadDAO;
import com.sheepdivide.master.dataLayer.database.SheepRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class Read implements ReadDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource ds){
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    //Used in autoSheepDivide. Gets total amount of sheep points.
    public List<SheepPoints> getAllSheepPoints(){
        String sql = "SELECT SUM(weightKg + wool + horns + legs + typeofsheep.valueOfType) AS totalsheeppoints \n" +
                "FROM (sheep INNER JOIN typeofsheep ON sheep.typeOfSheep=typeofsheep.typeOfSheep)";
        List<SheepPoints> result = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(SheepPoints.class));
        return result;
    }

    //Used in autoSheepDivide. Gets each user percent share in a specific field.
    public List<User> getUserPercentShare(int fieldId){
        String sql = "SELECT userId, percentShare FROM shares";
        List<User> users = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(User.class));
        return users;
    }

    //Used in autoSheepDivide. Gets list of unowned sheep.
    public List<DivideSheep> getUnOwnedSheep(){ //missing fieldId parameter
        String sql = "SELECT sheep.sheepId, sheep.weightKg + sheep.wool + sheep.horns + sheep.legs + typeofsheep.valueOfType AS sheepPoints FROM (sheep INNER JOIN typeofsheep ON sheep.typeOfSheep=typeofsheep.typeOfSheep) WHERE userId IS NULL ORDER BY RAND()";
        List<DivideSheep> allSheep = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(DivideSheep.class));
        return allSheep;
    }

    //Used in autoSheepDivide. Gets list of owned sheep.
    public List<DivideSheep> getOwnedSheep(){ //missing fieldId parameter.
        String sql = "SELECT sheep.sheepId, sheep.userId, sheep.weightKg + sheep.wool + sheep.horns + sheep.legs + typeofsheep.valueOfType AS sheepPoints FROM (sheep INNER JOIN typeofsheep ON sheep.typeOfSheep=typeofsheep.typeOfSheep) WHERE userId IS NOT NULL";
        List<DivideSheep> allSheep = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(DivideSheep.class));
        return allSheep;
    }

    //Selects a sheep from the database.
    public Sheep searchSheepToUpdate(String sheepId){
        String sql = "SELECT * FROM sheep WHERE sheepId = ?";
        Sheep aSheep = (Sheep)jdbcTemplateObject.queryForObject(sql, new Object[] { sheepId }, new SheepRowMapper());
        return aSheep;
    }

    //Displays all sheep in database.
    public List<DisplaySheep> displayAllSheep(){
        String sql = "SELECT sheep.sheepId, sheep.typeOfSheep, sheep.weightKg, sheep.wool, sheep.horns, sheep.legs, sheep.note, field.fieldName, users.username, typeofsheep.valueOfType, weightKg+wool+horns+legs+valueOfType AS sheepPoints " +
                "FROM (((sheep INNER JOIN field ON sheep.fieldId=field.fieldId) LEFT JOIN users ON sheep.userId=users.userId) INNER JOIN typeofsheep ON sheep.typeOfSheep=typeofsheep.typeOfSheep) ORDER BY sheepPoints DESC";
        List<DisplaySheep> joinedSheep = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(DisplaySheep.class));
        return joinedSheep;
    }
}
