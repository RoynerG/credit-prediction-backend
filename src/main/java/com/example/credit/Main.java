package com.example.credit;

import java.net.URL;

import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Main {
    public static void main(String[] args) {
        try {
            URL res = Main.class
                    .getClassLoader()
                    .getResource("data/credit-g.arff");
            if (res == null) {
                System.err.println("ERROR: no encontré credit-g.arff en classpath");
                System.exit(1);
            }
            String arffPath = res.getPath();

            DataSource src = new DataSource(arffPath);
            Instances header = src.getStructure();
            header.setClassIndex(header.numAttributes() - 1);

            CreditModel model = new CreditModel();
            model.loadData(arffPath);
            model.trainAll();

            System.out.println("=== Evaluación de modelos (10-fold CV) ===");
            model.evaluate();

            Instance inst = new DenseInstance(header.numAttributes());
            inst.setDataset(header);

            inst.setValue(header.attribute("duration"), 24);
            inst.setValue(header.attribute("credit_amount"), 2000);

            inst.setValue(header.attribute("checking_status"), "A11");
            inst.setValue(header.attribute("credit_history"), "A34");
            inst.setValue(header.attribute("purpose"), "A43");
            inst.setValue(header.attribute("savings"), "A65");
            inst.setValue(header.attribute("employment"), "A75");
            inst.setValue(header.attribute("personal_status"), "A93");
            inst.setValue(header.attribute("other_debtors"), "A101");
            inst.setValue(header.attribute("residence_since"), 2);
            inst.setValue(header.attribute("property"), "A121");
            inst.setValue(header.attribute("age"), 35);
            inst.setValue(header.attribute("other_installments"), "A141");
            inst.setValue(header.attribute("housing"), "A151");
            inst.setValue(header.attribute("existing_credits"), 1);
            inst.setValue(header.attribute("job"), "A172");
            inst.setValue(header.attribute("people_liable"), 1);
            inst.setValue(header.attribute("telephone"), "A191");
            inst.setValue(header.attribute("foreign_worker"), "A201");

            inst.setMissing(header.classIndex());

            double idx = model.predict(model.nb, inst);
            String clase = header.classAttribute().value((int) idx);
            System.out.println("Predicción NaiveBayes → " + clase);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
