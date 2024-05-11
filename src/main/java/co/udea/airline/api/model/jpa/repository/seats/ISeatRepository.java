package co.udea.airline.api.model.jpa.repository.seats;

import co.udea.airline.api.model.jpa.model.seats.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeatRepository  extends JpaRepository<Seat,Long> {
}
