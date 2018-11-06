package com.sheepdivide.master.control;

import org.springframework.stereotype.Controller;

@Controller
public class UpdateSheepController {

//    @RequestMapping(value = "/authorized/updateSheep1.html", method = RequestMethod.GET)
//    public String updateSheep1(){
//        return "authorized/updateSheep1";
//    }
//
//    @RequestMapping(value = "/authorized/updateSheep1.html", method = RequestMethod.POST)
//    public String updateSheep1(@ModelAttribute("aSheep") Sheep aSheep, RedirectAttributes redirectAttributes){
//        //JDBC Template!
//        SpringJDBCConfig conf = new SpringJDBCConfig();
//        DAOJDBCTemplate DB = new DAOJDBCTemplate();
//        DB.setDataSource(conf.dataSource());
//        aSheep = DB.searchSheepToUpdate(aSheep.getSheepId()); //Fills Sheep object with data from database.
//
//        redirectAttributes.addFlashAttribute("aSheep", aSheep); //Redirecting the Sheep object.
//
//        return "redirect:updateSheep2.html"; //Redirects user to updateSheep2.
//    }
//
//    @RequestMapping(value = "/authorized/updateSheep2.html", method = RequestMethod.GET)
//    public String updateSheep2(@ModelAttribute("aSheep") Sheep aSheep){ //The Sheep object from updateSheep1 can now be accessed in frontend.
//        return "authorized/updateSheep2";
//    }
//
//    @RequestMapping(value = "/authorized/updateSheep2.html", method = RequestMethod.POST)
//    public String updateSheep2(Sheep aSheep, Model model){ //Model is not used, but fixes duplicate method problem.
//        //JDBC Template!
//        SpringJDBCConfig conf = new SpringJDBCConfig();
//        DAOJDBCTemplate DB = new DAOJDBCTemplate();
//        DB.setDataSource(conf.dataSource());
//        DB.updateAllValues(aSheep.getSheepWeight(), aSheep.getSheepType(), aSheep.getSheepWool(), aSheep.getSheepHorns(), aSheep.getSheepLegs(), aSheep.getNote(), aSheep.getSheepId());
//        return "redirect:updateSheep1.html";
//    }
}
