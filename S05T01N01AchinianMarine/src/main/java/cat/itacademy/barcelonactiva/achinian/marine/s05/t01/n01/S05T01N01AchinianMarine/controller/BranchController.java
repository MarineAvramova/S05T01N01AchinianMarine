package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.controller;

import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.domain.Branch;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n01.S05T01N01AchinianMarine.model.sevices.BranchService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("")
    public String home(Model model){
        List<BranchDTO> branchDTOS = branchService.getAll();
        model.addAttribute("listBranches",
               branchDTOS );
        return "index";
    }
    @GetMapping ("/new_branch")
    public String showAddForm(Model model){
        model.addAttribute("branch", new Branch());
        return "new_branch";
    }

    @PostMapping("/new_branch")
    public String add(@ModelAttribute("branch") Branch branch, Model model){
        Branch branchDTOS = branchService.add(branch);
        branchService.getAll();
        model.addAttribute("listBranches",
                branchDTOS );
        return "redirect:/";
    }
    @RequestMapping(value = "/update_branch/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateBranch(@PathVariable("id") Integer id, @ModelAttribute("branch") Branch branch, BindingResult result, Model model, HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("GET")) {
            Branch fetchedBranch = branchService.getOne(id);
            model.addAttribute("branch", fetchedBranch);
            return "update_branch";
        } else if (request.getMethod().equalsIgnoreCase("POST")) {
            if (result.hasErrors()) {
                return "update_branch"; // Return the update form view in case of validation errors
            }
            branchService.update(branch);
            return "redirect:/";
        }
        return "redirect:/"; // Default redirect if neither GET nor POST
    }
//    @GetMapping("/update_branch/{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model){
//        Branch branch =  branchService.getOne(id); //get branch from service
//        model.addAttribute("branch", branch);//set branch as a model to pre-populate the form
//        return "redirect:/";
//    }
//
//    @PostMapping("/update_branch/{id}")
//    public String update(@ModelAttribute("branch") Branch branch, Model model){
//        Branch existingBranch = branchService.getOne(branch.getPk_BranchID());
//        existingBranch.setNameBranch((String) model.getAttribute("nameBranch"));
//        existingBranch.setCountryBranch((String) model.getAttribute("countryBranch"));
//        branchService.update(existingBranch);
//        model.addAttribute("branch", branch);
//        return "redirect:/";
//    }

@GetMapping("/deleteBranch/{id}")
    public String deleteBranch(@PathVariable(value = "id")Integer id){
       branchService.delete(id);
        return "redirect:/";
}

}
