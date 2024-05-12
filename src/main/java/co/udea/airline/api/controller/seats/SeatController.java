package co.udea.airline.api.controller.seats;

import co.udea.airline.api.model.jpa.model.seats.Seat;
import co.udea.airline.api.services.seats.service.ISeatService;
import co.udea.airline.api.services.seats.service.SeatServiceImpl;
import co.udea.airline.api.utils.common.Messages;
import co.udea.airline.api.utils.common.StandardResponse;
import co.udea.airline.api.utils.exception.DataDuplicatedException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.Optional;

@Tag(name = "Seat", description = "Seat management")
@RestController
@RequestMapping("/api/seat")
public class SeatController {

    @Autowired
    private SeatServiceImpl seatService;

    @Autowired
    private Messages messages;

    @PostMapping("/v1/save")
    @Operation(summary = "Save a single Seat")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Seat.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "Seat saved successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid Request"),
            @ApiResponse(responseCode = "409", description = "Seat already exists"),
            @ApiResponse(responseCode = "500", description = "Server internal Error")})
    public ResponseEntity<StandardResponse<Seat>> saveV1(@Valid @RequestBody Seat seat) {
        if (seatService.findSeatById(seat.getId()).isPresent()) {
            throw new DataDuplicatedException(
                    String.format(
                            messages.get("seat.save.duplicate.id"),
                            seat.getId()
                    )
            );
        };

        return ResponseEntity.ok(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("seat.save.successful"),
                seatService.save(seat)
                )
        );
    }

    @GetMapping("/v1/find/{id}")
    @Operation(summary = "Get Seat by Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Seat.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "Seat obtained successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid Request"),
            @ApiResponse(responseCode = "404", description = "Seat Not found"),
            @ApiResponse(responseCode = "500", description = "Server internal Error")})
    public ResponseEntity<StandardResponse<Seat>> getSeatByIdV1(@PathVariable String id) {
        Optional<Seat> seatFound = seatService.findSeatById(Long.valueOf(id));
        if (seatFound.isPresent()){
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                    messages.get("seat.findById"),
                    seatService.findSeatById(Long.valueOf(id)).get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/v1/update/{id}")
    @Operation(summary = "Update seat by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Seat.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "Seat updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid Request"),
            @ApiResponse(responseCode = "40", description = "Seat Not found"),
            @ApiResponse(responseCode = "500", description = "Server internal Error")})
    public ResponseEntity<StandardResponse<Seat>> updateSeatV1(@Valid @RequestBody Seat seat) {
        return ResponseEntity.ok(
                new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                        messages.get("seat.update.successful"),
                        seatService.update(seat)
                )
        );
    }

}
