package com.example.credit;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/credit")
public class CreditController {

    @Autowired
    private CreditModelService service;

    @GetMapping("/evaluate")
    public String eval() throws Exception {
        // Devuelve el reporte de accuracy para todos los modelos
        return service.getEvaluationReport();
    }

    @PostMapping("/predict")
    public PredictionResponse predict(@RequestBody CreditRequest req) throws Exception {
        // 1) Construir instancia
        weka.core.Instance inst = service.buildInstance(req);
        // 2) Predecir
        String predictedClass = service.predictWithNaiveBayes(inst);
        // 3) Devolver JSON
        return new PredictionResponse(predictedClass,
                "1 = buen pagador; 2 = mal pagador");
    }

    // DTO de respuesta
    static class PredictionResponse {
        private String predictedClass;
        private String note;

        public PredictionResponse(String cls, String note) {
            this.predictedClass = cls;
            this.note = note;
        }
        // getters
        public String getPredictedClass() { return predictedClass; }
        public String getNote() { return note; }
    }
}
