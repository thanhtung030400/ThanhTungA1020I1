package com.codegym.demo.service;

import com.codegym.demo.model.Position;

public interface PositionService {
    Iterable<Position> findAll();
    Position findById(Long id);
    void save(Position position);
}
