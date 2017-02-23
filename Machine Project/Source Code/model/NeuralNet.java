package model;

import java.util.ArrayList;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.mathutil.randomize.ConsistentRandomizer;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.back.Backpropagation;

public class NeuralNet {
    public double INPUT[][];
    public double IDEAL[][];
            
    public NeuralNet(ArrayList<Double[]> input){
        INPUT = new double[input.size()][1];
        IDEAL = new double[input.size()][1];
        
        for(int i = 0; i < input.size(); i++){
            INPUT[i][0] = 1.00;
            if(input.get(i)[0] > input.get(i)[1] ){
                IDEAL[i][0] = 0.00;
            }else
            {
                IDEAL[i][0] = 1.00;
            }
            
            System.out.println("input:" + input.get(i)[0] + ", output:" + input.get(i)[1]);
        }
            
    }
    
    public ArrayList<Double> predict(){
        ArrayList<Double> result = new ArrayList<Double>();
        int i;
        
        // create a neural network, without using a factory
	BasicNetwork network = new BasicNetwork();
	network.addLayer(new BasicLayer(null,true,1));
	network.addLayer(new BasicLayer(new ActivationSigmoid(),true,1));
	network.addLayer(new BasicLayer(new ActivationSigmoid(),false,1));
	network.getStructure().finalizeStructure();
	network.reset();
	new ConsistentRandomizer(-1,1,500).randomize(network);
	System.out.println(network.dumpWeights());
 
	// create training data
	MLDataSet trainingSet = new BasicMLDataSet(INPUT, IDEAL);
 
	// train the neural network
	final Backpropagation train = new Backpropagation(network, trainingSet, 0.7, 0.3);
	train.fixFlatSpot(false);
 
	int epoch = 1;
        
        double lastError = 0; int countError = 5;
        
	do {
            train.iteration();
            System.out.println("Epoch #" + epoch + " Error:" + train.getError());
            epoch++;
            if(train.getError() == lastError)
                countError--;
            
            lastError = train.getError();
	} while(train.getError() > 0.1 && countError != 0);
 
	// test the neural network
	System.out.println("Neural Network Results:");
	
        for(i = 0; i < trainingSet.size(); i++ ) {
            final MLData output = network.compute(trainingSet.get(i).getInput());
            System.out.println(trainingSet.get(i).getInput().getData(0)
					+ ", actual=" + output.getData(0) + ",ideal=" + trainingSet.get(i).getIdeal().getData(0));
            
            if(i == trainingSet.size() - 1){
                result.add(trainingSet.get(i).getIdeal().getData(0));
                result.add(output.getData(0));
            }
        }
                
        Encog.getInstance().shutdown();
        return result;
    }
}
