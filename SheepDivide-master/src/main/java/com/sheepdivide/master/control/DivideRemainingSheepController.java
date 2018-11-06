package com.sheepdivide.master.control;

import com.sheepdivide.master.dataLayer.AutoDivide;
import com.sheepdivide.master.security.SpringJDBCConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DivideRemainingSheepController {

    @RequestMapping(value = "/authorized/divideRemainingSheep.html", method = RequestMethod.GET)
    public String DivideRemainingSheep(){
        return "authorized/divideRemainingSheep";
    }

    @RequestMapping(value = "/authorized/divideRemainingSheep.html", method = RequestMethod.POST)
    public String DivideRemainingSheep(Model model){ //Model is not used, but fixes duplicate method problem.
        //JDBC Template!
        SpringJDBCConfig conf = new SpringJDBCConfig();
        AutoDivide ad = new AutoDivide();
        ad.setDataSource(conf.dataSource());
        ad.divideRemainingSheep(1);

        return "authorized/divideRemainingSheep";
    }
}
