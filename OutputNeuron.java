public class OutputNeuron{

    public OutputNeuron(){
	this.value = 0;
    }

    double value;

    public void increaseBy(double v){
	value += v;
    }

    public void bias(){
	value -= 0.5;
    }
    
    public double toPrint(){
	return this.value;
    }
}


    
