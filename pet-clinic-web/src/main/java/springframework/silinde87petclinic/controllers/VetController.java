package springframework.silinde87petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springframework.silinde87petclinic.model.Vet;
import springframework.silinde87petclinic.services.VetService;

import java.util.Set;

/**
 * Created by jt on 7/22/18.
 */
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

    @GetMapping({"/api/vets", "/api/vets.html"})
    public @ResponseBody Set<Vet> getVetsJson(){

        return vetService.findAll();
    }
}
