public class HiddenNeuron{

    public HiddenNeuron(){
	
    }

    double value;

    //plus one
    public void add(){
        this.value++;
    }

    //minus one
    public void sub(){
	this.value--;
    }

    //bias
    public void bias(){
	this.value -= 0.5;
    }

    public double getValue(){
	return this.value;
    }
}
