package com.example.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditController {

    private final CreditModelService service;

    @Autowired
    public CreditController(CreditModelService service) {
        this.service = service;
    }

    @PostMapping("/predict")
    public CreditModel predict(@RequestBody CreditRequest req) throws Exception {
        return service.predict(req);
    }
}
