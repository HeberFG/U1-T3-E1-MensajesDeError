package mx.edu.utez.mensajeserror.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.edu.utez.mensajeserror.entity.Taco;
import mx.edu.utez.mensajeserror.repository.TacoRepository;

@Controller
@RequestMapping("/tacos")
public class TacoController {

    @Autowired
    private TacoRepository tacoRepository;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("tacos", tacoRepository.findAll());
        return "lista";
    }

    @GetMapping("/create")
    public String create(Taco taco) {
        return "create";
    }

    @PostMapping("/save")
    public String save(Taco taco, RedirectAttributes attributes) {
        taco.setEstado(true);
        tacoRepository.save(taco);
        attributes.addFlashAttribute("message", "El taco ha sido agregado correctamente");
        return "redirect:/tacos/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("taco", tacoRepository.findById(id).get());
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Taco taco, RedirectAttributes attributes) {
        tacoRepository.save(taco);
        attributes.addFlashAttribute("message", "El taco ha sido actualizado correctamente");
        return "redirect:/tacos/list";
    }

    @GetMapping("/delete/{id}")
    public String getTaco(@PathVariable("id") Long id, RedirectAttributes attributes) {
        tacoRepository.deleteById(id);
        attributes.addFlashAttribute("message", "El taco ha sido eliminado correctamente");
        return "redirect:/tacos/list";
    }

}