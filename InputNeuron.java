public class InputNeuron{

    public InputNeuron(int v){
	this.value = v;
    }

    int value;
    
    public void add(HiddenNeuron hn){
	hn.add();
    }

    public void sub(HiddenNeuron hn){
	hn.sub();
    }

}
