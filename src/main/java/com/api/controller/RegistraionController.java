package com.api.controller;


import com.api.Entity.Registraion;
import com.api.service.RegistraionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registraion")
public class RegistraionController {

    private RegistraionService registraionService;

    public RegistraionController(RegistraionService registraionService) {
        this.registraionService = registraionService;
    }

@GetMapping
    public ResponseEntity<List<Registraion>> getAllRegistraions(){
    List<Registraion> registraions = registraionService.getRegistraions();
    return new ResponseEntity<>(registraions, HttpStatus.OK);


}

@PostMapping
    public ResponseEntity<Registraion> createRegistraion(
            @RequestBody Registraion registraion

){
        Registraion reg =registraionService.createRegistraion(registraion);
        return new ResponseEntity<>(reg,HttpStatus.CREATED);

}
    @DeleteMapping
public ResponseEntity<String> deleteRegistraion(
        @RequestParam long id

){
        registraionService.deleteRegistraion(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);

}

@PutMapping("/{id}")
   public ResponseEntity<Registraion> updateRegiatraion(
           @PathVariable long id,
           @RequestBody Registraion registraion
) {
        Registraion updateReg = registraionService.updateRegistraion(id,registraion);
       return new ResponseEntity<>(updateReg, HttpStatus.OK);
}

}
