package com.example.credit;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.rules.ZeroR;
import weka.classifiers.rules.OneR;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;

public class CreditModel {

    Instances data;
    Classifier zeroR, oneR, nb, j48;

    public void loadData(String arffPath) throws Exception {
        DataSource source = new DataSource(arffPath);
        data = source.getDataSet();
        if (data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);
    }


    public void trainAll() throws Exception {
        zeroR = new ZeroR();    zeroR.buildClassifier(data);
        oneR  = new OneR();     oneR.buildClassifier(data);
        nb    = new NaiveBayes();nb.buildClassifier(data);
        j48   = new J48();      j48.buildClassifier(data);
    }


    public void evaluate() throws Exception {
        Evaluation eval;
        for (Classifier cls : new Classifier[]{zeroR, oneR, nb, j48}) {
            eval = new Evaluation(data);
            eval.crossValidateModel(cls, data, 10, new java.util.Random(1));
            System.out.printf("%s: Accuracy=%.2f%%%n",
                    cls.getClass().getSimpleName(), eval.pctCorrect());
        }
    }


    public double predict(Classifier model, weka.core.Instance inst) throws Exception {
        inst.setDataset(data);
        return model.classifyInstance(inst);
    }
}
