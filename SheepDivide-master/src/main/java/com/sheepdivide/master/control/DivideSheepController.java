package com.sheepdivide.master.control;

import com.sheepdivide.master.dataLayer.POJO.DisplaySheep;
import com.sheepdivide.master.dataLayer.database.CRUD.Update;
import com.sheepdivide.master.security.SpringJDBCConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DivideSheepController {

    @RequestMapping(value = "/authorized/divideSheep.html", method = RequestMethod.GET)
    public String divideSheep(){

        return "authorized/divideSheep";
    }

    @RequestMapping(value = "/authorized/divideSheep.html", method = RequestMethod.POST)
    public String divideSheep(DisplaySheep ds){
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Update DB = new Update();
        DB.setDataSource(conf.dataSource());
        DB.assignSheepOwner(ds.getUsername(), ds.getSheepId());

        return "authorized/divideSheep";
    }

}
