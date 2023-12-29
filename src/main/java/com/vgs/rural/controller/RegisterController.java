package com.vgs.rural.controller;

import com.vgs.rural.dto.RegisterDTO;
import com.vgs.rural.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @GetMapping
    public ResponseEntity getAll(){
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity post(@Valid @RequestBody RegisterDTO register){
        try {
            register.setIs_active(true);
            return new ResponseEntity<>(service.save(register), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity put(@Valid @RequestBody RegisterDTO register){
        try {
            return new ResponseEntity<>(service.update(register), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        try {
            return new ResponseEntity<>("Register removed successfully.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
