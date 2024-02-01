package MountMomos.controller;

import MountMomos.Entity.Momos;
import MountMomos.repositoey.MomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/momos")
public class MomosController {

    @Autowired
    private MomoRepository momoRepository;

    @PostMapping("/addmomo")
    public ResponseEntity<?> addMomos(@RequestBody Momos momos ){
        Momos save=momoRepository.save(momos);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/getmomo/{id}")
    public ResponseEntity<?> getMomosById(@PathVariable int id){
        Optional<Momos> momosOptional =momoRepository.findById(id);
        return ResponseEntity.ok(momosOptional.get());
    }

//    @GetMapping("/getmomo")
//    public ResponseEntity<?> getMomos(){
//        List<Momos> momoLst = this.momoRepository.findAll();
//        return ResponseEntity.ok(momoLst);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMomos(@PathVariable int id, @RequestBody Momos updatedMomos) {
        Optional<Momos> existingMomosOptional = this.momoRepository.findById(id);
        if (existingMomosOptional.isPresent()) {
            Momos existingMomos = existingMomosOptional.get();
            // Update properties of existingMomos with those from updatedMomos
            existingMomos.setName(updatedMomos.getName());
            existingMomos.setType(updatedMomos.getType());

            Momos savedMomos =momoRepository.save(existingMomos);
            return ResponseEntity.ok(savedMomos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
