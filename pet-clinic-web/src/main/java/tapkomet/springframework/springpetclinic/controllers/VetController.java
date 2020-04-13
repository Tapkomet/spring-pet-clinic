package tapkomet.springframework.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tapkomet.springframework.springpetclinic.model.Vet;
import tapkomet.springframework.springpetclinic.services.VetService;

import java.util.Set;

/**
 * Created by Tapkomet on 11/18/2019
 */
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

    @RequestMapping({"/api/vets"})
    public @ResponseBody
    Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
