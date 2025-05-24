package com.example.credit;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.net.URL;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.rules.ZeroR;
import weka.classifiers.rules.OneR;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;

@Service
public class CreditModelService {

    private Instances header;
    private Instances data;
    private Classifier zeroR, oneR, nb, j48;

    @PostConstruct
    public void init() throws Exception {
        // 1) Cargar ARFF completo
        URL res = getClass().getClassLoader().getResource("data/credit-g.arff");
        if (res == null) throw new IllegalStateException("ARFF no encontrado");
        String arffPath = res.getPath();

        // 2) Para rellenar instancias nuevas
        DataSource src = new DataSource(arffPath);
        header = src.getStructure();
        header.setClassIndex(header.numAttributes() - 1);

        // 3) Cargar data y entrenar
        data = src.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        zeroR = new ZeroR();    zeroR.buildClassifier(data);
        oneR  = new OneR();     oneR.buildClassifier(data);
        nb    = new NaiveBayes();nb.buildClassifier(data);
        j48   = new J48();      j48.buildClassifier(data);
    }

    /** Evalúa los cuatro modelos */
    public String getEvaluationReport() throws Exception {
        StringBuilder sb = new StringBuilder();
        Evaluation eval;
        for (Classifier cls : new Classifier[]{zeroR, oneR, nb, j48}) {
            eval = new Evaluation(data);
            eval.crossValidateModel(cls, data, 10, new java.util.Random(1));
            sb.append(String.format("%s: %.2f%%\n",
                    cls.getClass().getSimpleName(),
                    eval.pctCorrect()));
        }
        return sb.toString();
    }

    /** Predice con el modelo NaiveBayes */
    public String predictWithNaiveBayes(weka.core.Instance inst) throws Exception {
        inst.setDataset(header);
        double idx = nb.classifyInstance(inst);
        return header.classAttribute().value((int) idx);
    }

    /** Construye y devuelve un Instance a partir de un DTO */
    public weka.core.Instance buildInstance(CreditRequest req) {
        weka.core.Instance inst = new weka.core.DenseInstance(header.numAttributes());
        inst.setDataset(header);

        // Numéricos
        inst.setValue(header.attribute("duration"), req.getDuration());
        inst.setValue(header.attribute("credit_amount"), req.getCreditAmount());
        inst.setValue(header.attribute("residence_since"), req.getResidenceSince());
        inst.setValue(header.attribute("age"), req.getAge());
        inst.setValue(header.attribute("existing_credits"), req.getExistingCredits());
        inst.setValue(header.attribute("people_liable"), req.getPeopleLiable());

        // Nominales
        inst.setValue(header.attribute("checking_status"), req.getCheckingStatus());
        inst.setValue(header.attribute("credit_history"), req.getCreditHistory());
        inst.setValue(header.attribute("purpose"), req.getPurpose());
        inst.setValue(header.attribute("savings"), req.getSavings());
        inst.setValue(header.attribute("employment"), req.getEmployment());
        inst.setValue(header.attribute("personal_status"), req.getPersonalStatus());
        inst.setValue(header.attribute("other_debtors"), req.getOtherDebtors());
        inst.setValue(header.attribute("property"), req.getProperty());
        inst.setValue(header.attribute("other_installments"), req.getOtherInstallments());
        inst.setValue(header.attribute("housing"), req.getHousing());
        inst.setValue(header.attribute("job"), req.getJob());
        inst.setValue(header.attribute("telephone"), req.getTelephone());
        inst.setValue(header.attribute("foreign_worker"), req.getForeignWorker());

        // Clase missing
        inst.setMissing(header.classIndex());
        return inst;
    }
}
