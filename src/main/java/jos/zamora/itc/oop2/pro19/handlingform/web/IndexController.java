/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jos.zamora.itc.oop2.pro19.handlingform.web;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jos1727
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    
    @RequestMapping( method = RequestMethod.GET )
    public String index(Model model) {
        Date today = new Date();
        model.addAttribute("today", today);
        return "index";
    }
    
}
