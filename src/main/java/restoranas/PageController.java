package restoranas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class PageController {
	
    @GetMapping("/")
    public String pradzia(Model model) {
        model.addAttribute("lst_menu", Menu.values() );    	
        return "index";
    }	
	
    @GetMapping("/uzsakymai")
    public String uzsakymai(Model model) {
        model.addAttribute("lst_menu", Menu.values() );    	
        return "uzsakymai";
    }	
    
    @GetMapping("/klientai")
    public String klientai(Model model) {
        model.addAttribute("lst_menu", Menu.values() );    	
        return "klientai";
    }    

    @GetMapping("/klientas")
    public String klientas(@RequestParam Integer id, Model model) {
        model.addAttribute("lst_menu", Menu.values() );
        return "klientas";
    }  
    
    @GetMapping("/pasiulymai")
    public String pasiulymai(@RequestParam Integer id, Model model) {

        model.addAttribute("lst_menu", Menu.values() );
        return "pasiulymai";
    } 
}
