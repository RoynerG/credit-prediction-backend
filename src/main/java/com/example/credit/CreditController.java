package com.example.credit;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditController {

    private final CreditModelService service;

    public CreditController(CreditModelService service) {
        this.service = service;
    }

    @Operation(summary = "Predecir clasificación de crédito",
            description = "Recibe un objeto CreditRequest con los datos del solicitante y devuelve la predicción")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Predicción exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditModel.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud mal formada")
    })
    @PostMapping("/predict")
    public CreditModel predict(@RequestBody CreditRequest request) throws Exception {
        return service.predict(request);
    }
}
