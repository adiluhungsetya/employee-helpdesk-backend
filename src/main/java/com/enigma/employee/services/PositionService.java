package com.enigma.employee.services;

import com.enigma.employee.models.Position;

import java.util.List;

public interface PositionService {
    List<Position> getPositionList();
    Position getById(String id);
    Position insert(Position position);
}
