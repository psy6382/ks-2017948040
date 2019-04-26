package ac.ks0.controller;

import ac.ks0.domain.Basic;
import ac.ks0.repository.BasicRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BasicController {
    private BasicRepository basicRepository;

    public BasicController(BasicRepository basicRepository){
        this.basicRepository = basicRepository;
    }
    @GetMapping("/basic")
    public List<String> basic(){
        List<String> basicList = new ArrayList<>();
        for (Basic s : basicRepository.findAll()){
            basicList.add(s.getName());
        }
        return basicList;
    }
}
