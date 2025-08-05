package com.example.project1.Service;

import com.example.project1.Repo.ModuleRepo;
import com.example.project1.model.Module;
import com.example.project1.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepo repo;

    //get method
    public List<Module> getAllModule() {
        return repo.findAll();
    }

    //get by id
    public Module getModuleById(int id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
    }

    //post method
    public void addModule(Module module) {
        repo.save(module);
    }

    //put method
    public void updateModule(Integer id, Module updatedModule){
        Optional<Module> optionalModule = repo.findById(id);

        if ( optionalModule.isPresent()){
            Module existingModule = optionalModule.get();

            if (updatedModule.getName() != null){
                existingModule.setName((updatedModule.getName()));
            }
            if (updatedModule.getCourse() != null){
                existingModule.setCourse((updatedModule.getCourse()));
            }

            repo.save(existingModule);
        }
    }

    //delete method
    public void deleteModule(int id) {
        repo.deleteById(id);
    }
}
