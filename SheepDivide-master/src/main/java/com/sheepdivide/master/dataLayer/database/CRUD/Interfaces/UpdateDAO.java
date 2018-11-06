package com.sheepdivide.master.dataLayer.database.CRUD.Interfaces;

import javax.sql.DataSource;

public interface UpdateDAO {
    void setDataSource(DataSource ds);
    void autoAssignSheepOwner(int userId, String sheepId);
    void assignSheepOwner(String username, String sheepId);
    void clearAllSheepOwners();
    void updateAllValues(int sheepWeight, String sheepType, int sheepWool, int sheepHorns, int sheepLegs, String note, String sheepId);
}
