package co.udea.airline.api.services.seats.service;

import co.udea.airline.api.model.jpa.model.seats.Seat;
import co.udea.airline.api.model.jpa.repository.seats.ISeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class SeatServiceImpl implements ISeatService{

    @Autowired
    ISeatRepository seatRepository;

    public Seat save(Seat s){
        return seatRepository.save(s);
    }

    @Override
    public Optional<Seat> findSeatById(Long id) {
        return seatRepository.findById(id);
    }
}
