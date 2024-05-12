package co.udea.airline.api.model.jpa.model.seats;

import co.udea.airline.api.utils.common.SeatClassEnum;
import co.udea.airline.api.utils.common.SeatLocationEnum;
import co.udea.airline.api.utils.common.SeatStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seat")
    private Long id;

    @NotNull
    @Column(name = "status")
    private SeatStatusEnum status = SeatStatusEnum.AVAILABLE;

    @NotNull
    @Column(name = "class")
    private SeatClassEnum seatClass;

    @NotNull
    @Column(name = "location")
    private SeatLocationEnum location;

    @NotNull
    @Column(name = "surcharge")
    private int surcharge = 0;
}


