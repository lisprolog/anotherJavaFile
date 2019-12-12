public class Net{
    
    private Neuron [] layer;

    public Net(int size){
	
	layer = new Neuron [size];

	for(int x = 0; x < size; x++){
	    layer[x] = new Neuron();
	}
    }

    public boolean setNeuronX(int neuronIndex, double x){
	this.layer[neuronIndex].setX(x);
	return true;
    }


    public boolean setNeuronX_W(int neuronIndex, double w){
	this.layer[neuronIndex].setX_W(w);
	return true;
    }

    public boolean setNeuronY(int neuronIndex, double y){
	this.layer[neuronIndex].setY(y);
	return true;
    }

    public boolean setNeuronY_W(int neuronIndex, double w){
	this.layer[neuronIndex].setY_W(w);
	return true;
    }

    public boolean setNeuronBias(int neuronIndex, int b){
	this.layer[neuronIndex].setBias(b);
	return true;
    }
    
    public boolean fireNeuron(int neuronIndex){
	this.layer[neuronIndex].fire();
	return true;
    }

    public double getZ(int neuronIndex){
	return this.layer[neuronIndex].getZ();
    }
}
