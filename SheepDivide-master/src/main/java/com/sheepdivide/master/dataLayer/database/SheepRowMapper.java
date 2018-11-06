package com.sheepdivide.master.dataLayer.database;

import com.sheepdivide.master.dataLayer.POJO.Sheep;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SheepRowMapper implements RowMapper {

    //SELECT in database
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sheep aSheep = new Sheep();
        aSheep.setSheepId(rs.getString("sheepId"));
        aSheep.setSheepWeight(rs.getInt("weightKg"));
        aSheep.setSheepType(rs.getString("typeOfSheep"));
        aSheep.setSheepWool(rs.getInt("wool"));
        aSheep.setSheepHorns(rs.getInt("horns"));
        aSheep.setSheepLegs(rs.getInt("legs"));
        aSheep.setNote(rs.getString("note"));
        //evt select userid.
        return aSheep;
    }
}
