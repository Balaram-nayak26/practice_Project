package com.example.project1.Controller;


import com.example.project1.Service.ModuleService;
import com.example.project1.model.Instructor;
import com.example.project1.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModuleController {

    @Autowired
    private ModuleService service;

    //get all modules
    @GetMapping("/module")
    public List<Module> getAllModule(){
        return service.getAllModule();
    }

    //get modules by id
    @GetMapping("/module/{Id}")
    public Module getModuleById(@PathVariable int Id){
        return service.getModuleById(Id);
    }

    //Post method for module
    @PostMapping("/module")
    public void addModule(@RequestBody Module module){
        System.out.println(module);
        service.addModule(module);
    }

    //Put method for module
    @PutMapping("module/{Id}")
    public void updateModule(@PathVariable Integer Id, @RequestBody Module module){
        service.updateModule(Id, module);
    }

    //Delete method for modules
    @DeleteMapping("/module/{Id}")
    public void deleteModule(@PathVariable int Id){
        service.deleteModule(Id);
    }
}
