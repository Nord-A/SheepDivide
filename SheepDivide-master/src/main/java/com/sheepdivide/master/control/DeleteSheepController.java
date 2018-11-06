package com.sheepdivide.master.control;

import com.sheepdivide.master.dataLayer.POJO.Sheep;
import com.sheepdivide.master.dataLayer.database.CRUD.Delete;
import com.sheepdivide.master.dataLayer.database.CRUD.Update;
import com.sheepdivide.master.security.SpringJDBCConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteSheepController {

    @RequestMapping(value = "/authorized/deleteSheep.html", method = RequestMethod.GET)
    public String deleteSheep(){

        return "authorized/deleteSheep";
    }

    @RequestMapping(value = "/authorized/deleteSheep.html", method = RequestMethod.POST)
    public String deleteSheep(Sheep aSheep){
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Delete DB = new Delete();
        DB.setDataSource(conf.dataSource());
        DB.deleteSheep(aSheep.getSheepId());

        return "authorized/deleteSheep";
    }

    @RequestMapping(value = "/authorized/deleteAllSheep.html", method = RequestMethod.GET)
    public String deleteAllSheep(Model model){ //Model is not used, but fixes duplicate method problem.

        return "authorized/deleteAllSheep";
    }

    @RequestMapping(value = "/authorized/deleteAllSheep.html", method = RequestMethod.POST)
    public String deleteAllSheep(){
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Delete DB = new Delete();
        DB.setDataSource(conf.dataSource());
        DB.deleteAllSheep();

        return "authorized/deleteAllSheep";
    }

    @RequestMapping(value = "/authorized/clearAllSheepOwners.html", method = RequestMethod.GET)
    public String clearAllSheepOwners(Model model){ //Model is not used, but fixes duplicate method problem.

        return "authorized/clearAllSheepOwners";
    }

    @RequestMapping(value = "/authorized/clearAllSheepOwners.html", method = RequestMethod.POST)
    public String clearAllSheepOwners(){
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Update DB = new Update();
        DB.setDataSource(conf.dataSource());
        DB.clearAllSheepOwners();

        return "authorized/clearAllSheepOwners";
    }

}
