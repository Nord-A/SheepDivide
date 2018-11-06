package com.sheepdivide.master.dataLayer.database.CRUD;

import com.sheepdivide.master.dataLayer.database.CRUD.Interfaces.DeleteDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Delete implements DeleteDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource ds){
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    //Deletes a sheep from the database.
    public void deleteSheep(String sheepId){
        String sql = "DELETE FROM sheep WHERE sheepId = ? LIMIT 1";
        jdbcTemplateObject.update(sql, sheepId);
    }

    //Removes all rows in sheep table.
    public void deleteAllSheep(){
        String sql = "DELETE FROM sheep";
        jdbcTemplateObject.update(sql);
    }
}
