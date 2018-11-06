package com.sheepdivide.master.dataLayer.database.CRUD.Interfaces;

import com.sheepdivide.master.dataLayer.POJO.*;

import javax.sql.DataSource;
import java.util.List;

public interface ReadDAO {
    void setDataSource(DataSource ds);
    List<User> getUserPercentShare(int fieldId);
    List<SheepPoints> getAllSheepPoints();
    List<DivideSheep> getUnOwnedSheep();
    List<DivideSheep> getOwnedSheep();
    Sheep searchSheepToUpdate(String sheepId);
    List<DisplaySheep> displayAllSheep();
}
