package me.ivan.darazhanov.firstprojectspring.controller;

import me.ivan.darazhanov.firstprojectspring.model.Toy;
import me.ivan.darazhanov.firstprojectspring.model.User;
import me.ivan.darazhanov.firstprojectspring.model.dto.ToyDTO;
import me.ivan.darazhanov.firstprojectspring.model.dto.UserDTO;
import me.ivan.darazhanov.firstprojectspring.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/toys")
public class ToyController {
    private final ToyService toyService;

    @Autowired
    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Toy>> getToys() {
        List<Toy> toyList = new ArrayList<Toy>();
        toyService.findAll().forEach(toyList::add);

        return new ResponseEntity<>(toyList, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Object> createToy(@RequestBody ToyDTO toy) {

        if (toyService.save(toy)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(toy);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "invalid data"));

    }
    @GetMapping("/get-toy/{id}")
    public ResponseEntity<?> getToyById(@PathVariable int id) {
        ToyDTO toydata = toyService.findToyById(id);
        if (toydata == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Invalid id: " + id));
        }
        return ResponseEntity.ok(toydata);
    }

    @PutMapping("/update-toy/{id}")
    public ResponseEntity<?> updateToy(@RequestBody ToyDTO toyDTO, @PathVariable int id) {
        if (toyService.updateToy(toyDTO, id)) {
            return ResponseEntity.status(HttpStatus.OK).body(toyDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid id: " + id));
    }

    @DeleteMapping("/delete-toy/{id}")
    public ResponseEntity<?> deleteToy(@PathVariable int id) {
        if (toyService.deleteToy(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("Successfully deleted user on", " id: " + id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid id: " + id));
    }

}
