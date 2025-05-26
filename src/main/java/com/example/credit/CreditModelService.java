package com.example.credit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class CreditModelService {

    private Classifier model;
    private Instances dataStructure;

    @PostConstruct
    public void init() throws Exception {
        // 1) Carga el modelo .model desde classpath:/models/credit-model.model
        Resource modelRes = new ClassPathResource("models/credit-model.model");
        try (InputStream in = modelRes.getInputStream()) {
            this.model = (Classifier) weka.core.SerializationHelper.read(in);
        }

        // 2) Carga el ARFF desde classpath:/data/credit-g.arff con un Reader
        Resource arffRes = new ClassPathResource("data/credit-g.arff");
        try (InputStream in = arffRes.getInputStream();
             Reader      r  = new BufferedReader(new InputStreamReader(in))) {
            this.dataStructure = new Instances(r);
        }

        if (this.dataStructure == null) {
            throw new IllegalStateException("No se pudo cargar la estructura de datos (credit-g.arff)");
        }
        // Fija el índice de clase al último atributo
        this.dataStructure.setClassIndex(this.dataStructure.numAttributes() - 1);
    }

    public CreditModel predict(CreditRequest req) throws Exception {
        if (dataStructure == null) {
            throw new IllegalStateException("El dataset no fue cargado correctamente");
        }

        // 3) Crea la instancia y rellénala igual que antes
        Instance inst = new weka.core.DenseInstance(dataStructure.numAttributes());
        inst.setDataset(dataStructure);

        inst.setValue(dataStructure.attribute("checking_status"), req.getCheckingStatus());
        inst.setValue(dataStructure.attribute("duration"), req.getDuration());
        inst.setValue(dataStructure.attribute("credit_history"), req.getCreditHistory());
        inst.setValue(dataStructure.attribute("purpose"), req.getPurpose());
        inst.setValue(dataStructure.attribute("credit_amount"), req.getCreditAmount());
        inst.setValue(dataStructure.attribute("savings_status"), req.getSavingsStatus());
        inst.setValue(dataStructure.attribute("employment"), req.getEmployment());
        inst.setValue(dataStructure.attribute("installment_commitment"), req.getInstallmentCommitment());
        inst.setValue(dataStructure.attribute("personal_status"), req.getPersonalStatus());
        inst.setValue(dataStructure.attribute("other_parties"), req.getOtherParties());
        inst.setValue(dataStructure.attribute("residence_since"), req.getResidenceSince());
        inst.setValue(dataStructure.attribute("property_magnitude"), req.getPropertyMagnitude());
        inst.setValue(dataStructure.attribute("age"), req.getAge());
        inst.setValue(dataStructure.attribute("other_payment_plans"), req.getOtherPaymentPlans());
        inst.setValue(dataStructure.attribute("housing"), req.getHousing());
        inst.setValue(dataStructure.attribute("existing_credits"), req.getExistingCredits());
        inst.setValue(dataStructure.attribute("job"), req.getJob());
        inst.setValue(dataStructure.attribute("num_dependents"), req.getNumDependents());
        inst.setValue(dataStructure.attribute("own_telephone"), req.getOwnTelephone());
        inst.setValue(dataStructure.attribute("foreign_worker"), req.getForeignWorker());

        // 4) Predicción y retornas el modelo de salida
        double predIdx = model.classifyInstance(inst);
        String predClass = dataStructure.classAttribute().value((int) predIdx);
        double[] dist   = model.distributionForInstance(inst);

        CreditModel out = new CreditModel();
        out.setPredictedClass(predClass);
        out.setProbabilityGood(dist[dataStructure.classAttribute().indexOfValue("good")]);
        out.setProbabilityBad(dist[dataStructure.classAttribute().indexOfValue("bad")]);
        return out;
    }
}
