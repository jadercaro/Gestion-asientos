package co.udea.airline.api.services.seats.service;

import co.udea.airline.api.model.jpa.model.seats.Seat;
import co.udea.airline.api.model.jpa.model.vehicles.Aircraft;
import co.udea.airline.api.model.jpa.repository.seats.ISeatRepository;
import co.udea.airline.api.utils.common.Messages;
import co.udea.airline.api.utils.exception.BusinessException;
import co.udea.airline.api.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class SeatServiceImpl implements ISeatService{

    @Autowired
    ISeatRepository seatRepository;

    @Autowired
    Messages messages;

    public Seat save(Seat s){
        return seatRepository.save(s);
    }

    public Seat update(Seat seat) {
        Optional<Seat> seatOptional = seatRepository.findById(seat.getId());
        if (seatOptional.isEmpty()){
            throw new DataNotFoundException(String.format(messages.get("seat.update.does.not.exist")));
        }
        return seatRepository.save(seat);
    }

    @Override
    public Optional<Seat> findSeatById(Long id) {
        return seatRepository.findById(id);
    }
}
