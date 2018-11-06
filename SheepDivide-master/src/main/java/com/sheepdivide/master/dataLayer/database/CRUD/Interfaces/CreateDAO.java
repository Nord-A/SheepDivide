package com.sheepdivide.master.dataLayer.database.CRUD.Interfaces;

import javax.sql.DataSource;

public interface CreateDAO {
    void setDataSource(DataSource ds);
    void registerSheep(String sheepId, String sheepType, int sheepWeight, int sheepWool, int sheepHorns, int sheepLegs, String note);
}
