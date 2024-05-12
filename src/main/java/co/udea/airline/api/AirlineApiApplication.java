package co.udea.airline.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Testing
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import co.udea.airline.api.model.jpa.model.seats.Seat;
import java.util.NoSuchElementException;
import co.udea.airline.api.model.jpa.repository.seats.ISeatRepository;
import co.udea.airline.api.utils.common.SeatClassEnum;
import co.udea.airline.api.utils.common.SeatLocationEnum;



//@EnableTransactionManagement
@SpringBootApplication
@ComponentScan({
        "co.udea.airline.api.controller",
        "co.udea.airline.api.model",
        "co.udea.airline.api.services",
        "co.udea.airline.api.utils",
})

public class AirlineApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AirlineApiApplication.class, args);
    }

    // Bean for Testing Purposes
//    @Bean
//    CommandLineRunner runner(ISeatRepository seatRepository) {
//        return args -> {
//
//            Seat seat = new Seat();
//            seat.setSeatClass(SeatClassEnum.FIRST_CLASS);
//            seat.setLocation(SeatLocationEnum.AISLE);
//
//            seatRepository.save(seat);
//            Seat saved = seatRepository.findById(seat.getId()).orElseThrow(NoSuchElementException::new);
//        };
//    }

}
