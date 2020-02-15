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
    
    public double getValue(){
	return this.value;
    }

    public void heaviside(){
	if(this.value < 0){
	    this.value = 0;
	}else{
	    this.value = 1;
	}
    }
}


    
