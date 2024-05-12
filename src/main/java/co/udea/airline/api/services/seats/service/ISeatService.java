package co.udea.airline.api.services.seats.service;

import co.udea.airline.api.model.jpa.model.seats.Seat;

import java.util.Optional;

public interface ISeatService {
    public Optional<Seat> findSeatById(Long id);

}
