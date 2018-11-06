package com.sheepdivide.master.control;

import com.sheepdivide.master.dataLayer.POJO.Sheep;
import com.sheepdivide.master.dataLayer.database.CRUD.Read;
import com.sheepdivide.master.dataLayer.database.CRUD.Update;
import com.sheepdivide.master.security.SpringJDBCConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DisplaySheepController {

    //DISPLAY SHEEP
    @RequestMapping("/authorized/displaySheep.html")
    public String displaySheep(Model model){
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Read DB = new Read();
        DB.setDataSource(conf.dataSource());
        model.addAttribute("joinedSheep", DB.displayAllSheep());

        return "authorized/displaySheep";
    }

    @RequestMapping(value = "/authorized/displaySheep.html", method = RequestMethod.POST)
    public String displaySheep(@ModelAttribute("aSheep") Sheep aSheep, RedirectAttributes redirectAttributes){
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Read DB = new Read();
        DB.setDataSource(conf.dataSource());
        aSheep = DB.searchSheepToUpdate(aSheep.getSheepId()); //Fills Sheep object with data from database.

        redirectAttributes.addFlashAttribute("aSheep", aSheep); //Redirecting the Sheep object.

        return "redirect:updateSheep2.html";
    }


    //UPDATE SHEEP
    @RequestMapping(value = "/authorized/updateSheep1.html", method = RequestMethod.GET)
    public String updateSheep1(){
        return "authorized/updateSheep1";
    }

    @RequestMapping(value = "/authorized/updateSheep1.html", method = RequestMethod.POST)
    public String updateSheep1(@ModelAttribute("aSheep") Sheep aSheep, RedirectAttributes redirectAttributes){
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Read DB = new Read();
        DB.setDataSource(conf.dataSource());
        aSheep = DB.searchSheepToUpdate(aSheep.getSheepId()); //Fills Sheep object with data from database.

        redirectAttributes.addFlashAttribute("aSheep", aSheep); //Redirecting the Sheep object.

        return "redirect:updateSheep2.html"; //Redirects user to updateSheep2.
    }

    @RequestMapping(value = "/authorized/updateSheep2.html", method = RequestMethod.GET)
    public String updateSheep2(@ModelAttribute("aSheep") Sheep aSheep){ //The Sheep object from updateSheep1 can now be accessed in frontend.
        return "authorized/updateSheep2";
    }

    @RequestMapping(value = "/authorized/updateSheep2.html", method = RequestMethod.POST)
    public String updateSheep2(Sheep aSheep, Model model){ //Model is not used, but fixes duplicate method problem.
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        Update DB = new Update();
        DB.setDataSource(conf.dataSource());
        DB.updateAllValues(aSheep.getSheepWeight(), aSheep.getSheepType(), aSheep.getSheepWool(), aSheep.getSheepHorns(), aSheep.getSheepLegs(), aSheep.getNote(), aSheep.getSheepId());
        return "redirect:updateSheep1.html";
    }

}
