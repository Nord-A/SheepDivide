package com.sheepdivide.master.control;

import com.sheepdivide.master.dataLayer.POJO.Sheep;
import com.sheepdivide.master.dataLayer.database.CRUD.Create;
import com.sheepdivide.master.security.SpringJDBCConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterSheepController {
    @RequestMapping(value = "/authorized/registerSheep.html", method = RequestMethod.GET)
    public String registerSheep(){
        return "authorized/registerSheep";
    }

    @RequestMapping(value = "/authorized/registerSheep.html", method = RequestMethod.POST)
    public String registerSheep(Sheep aSheep){
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Create DB = new Create();
        DB.setDataSource(conf.dataSource());
        DB.registerSheep(aSheep.getSheepId(), aSheep.getSheepType(), aSheep.getSheepWeight(), aSheep.getSheepWool(), aSheep.getSheepHorns(), aSheep.getSheepLegs(), aSheep.getNote());

        return "redirect:registerSheepSuccess.html";
    }

    @RequestMapping(value = "/authorized/registerSheepSuccess.html", method = RequestMethod.GET)
    public String registerSheepSuccess(){

        return "authorized/registerSheepSuccess";
    }

    @RequestMapping(value = "/authorized/registerSheepSuccess.html", method = RequestMethod.POST)
    public String registerSheepSuccess(Sheep aSheep){
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Create DB = new Create();
        DB.setDataSource(conf.dataSource());
        DB.registerSheep(aSheep.getSheepId(), aSheep.getSheepType(), aSheep.getSheepWeight(), aSheep.getSheepWool(), aSheep.getSheepHorns(), aSheep.getSheepLegs(), aSheep.getNote());

        return "authorized/registerSheepSuccess";
    }
}
