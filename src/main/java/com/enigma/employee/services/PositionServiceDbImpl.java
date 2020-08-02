package com.enigma.employee.services;

import com.enigma.employee.error.NotFoundException;
import com.enigma.employee.error.ResourceEmptyException;
import com.enigma.employee.models.Position;
import com.enigma.employee.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PositionServiceDbImpl implements PositionService{
    @Autowired
    PositionRepository repository;

    @Override
    public List<Position> getPositionList() {
        return repository.findAll();
    }

    @Override
    public Position getById(String id) {
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        } else throw new NotFoundException(id);
    }

    @Override
    public Position insert(Position position){
        return repository.save(position);
    }
}