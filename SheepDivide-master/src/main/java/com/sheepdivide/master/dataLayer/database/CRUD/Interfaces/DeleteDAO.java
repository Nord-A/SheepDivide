package com.sheepdivide.master.dataLayer.database.CRUD.Interfaces;

import javax.sql.DataSource;

public interface DeleteDAO {
    void setDataSource(DataSource ds);
    void deleteSheep(String sheepId);
    void deleteAllSheep();
}
