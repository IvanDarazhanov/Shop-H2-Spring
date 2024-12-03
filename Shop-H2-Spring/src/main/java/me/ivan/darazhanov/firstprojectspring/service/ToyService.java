package me.ivan.darazhanov.firstprojectspring.service;

import me.ivan.darazhanov.firstprojectspring.model.Toy;
import me.ivan.darazhanov.firstprojectspring.model.User;
import me.ivan.darazhanov.firstprojectspring.model.dto.ToyDTO;
import me.ivan.darazhanov.firstprojectspring.model.dto.UserDTO;
import me.ivan.darazhanov.firstprojectspring.repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToyService {

    private final ToyRepository toyRepository;

    @Autowired
    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public List<Toy> findAll(){
        return toyRepository.findAll();
    }
    public boolean save (ToyDTO toyDTO) {
        if (toyDTO==null)
            return false;
        Toy toy = new Toy();
        toy.setName(toyDTO.getName());
        toy.setPrice(toyDTO.getPrice());

        toyRepository.save(toy);
        return true;
    }

    public ToyDTO findToyById(int id) {
        Optional<Toy> optional = toyRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        ToyDTO toyDTO = new ToyDTO();
        toyDTO.setName(optional.get().getName());
        toyDTO.setPrice(optional.get().getPrice());
        return toyDTO;
    }
    public Toy findEToyById(int id) {
        Optional<Toy> optional = toyRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Toy toy = new Toy();
        toy.setName(optional.get().getName());
        toy.setPrice(optional.get().getPrice());
        return toy;
    }

    public boolean updateToy(ToyDTO toyDTO, int id) {
        Optional<Toy> optional = toyRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        Toy toy = optional.get();
        toy.setName(toyDTO.getName());
        toy.setPrice(toyDTO.getPrice());
        toyRepository.save(toy);
        return true;
    }

    public boolean deleteToy(int id) {
        Optional<Toy> optional = toyRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        toyRepository.deleteById(id);
        return true;
    }
}
