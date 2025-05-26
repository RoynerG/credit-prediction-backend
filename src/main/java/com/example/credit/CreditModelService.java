package com.example.credit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Service
public class CreditModelService {

    private Classifier model;
    private Instances dataStructure;

    @PostConstruct
    public void init() throws Exception {
        // Carga el modelo desde classpath: /models/credit-model.model
        ClassPathResource modelRes = new ClassPathResource("models/credit-model.model");
        try (InputStream is = modelRes.getInputStream()) {
            this.model = (Classifier) SerializationHelper.read(is);
        }

        // Carga la estructura de datos desde classpath: /data/credit-g.arff
        ClassPathResource arffRes = new ClassPathResource("data/credit-g.arff");
        try (InputStream is = arffRes.getInputStream()) {
            DataSource src = new DataSource(is);
            this.dataStructure = src.getDataSet();
        }
        this.dataStructure.setClassIndex(this.dataStructure.numAttributes() - 1);
    }

    public CreditModel predict(CreditRequest req) throws Exception {
        Instance inst = new weka.core.DenseInstance(dataStructure.numAttributes());
        inst.setDataset(dataStructure);
        inst.setValue(dataStructure.attribute("checking_status"), req.getCheckingStatus());
        // … y el resto de atributos …
        inst.setValue(dataStructure.attribute("foreign_worker"), req.getForeignWorker());

        double predIdx = model.classifyInstance(inst);
        String predClass = dataStructure.classAttribute().value((int) predIdx);
        double[] dist = model.distributionForInstance(inst);

        CreditModel out = new CreditModel();
        out.setPredictedClass(predClass);
        out.setProbabilityGood(dist[dataStructure.classAttribute().indexOfValue("good")]);
        out.setProbabilityBad(dist[dataStructure.classAttribute().indexOfValue("bad")]);
        return out;
    }
}
