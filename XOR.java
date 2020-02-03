public class XOR{
    
    public static void main(String[] args){

	InputNeuron i1 = new InputNeuron(1);
	InputNeuron i2 = new InputNeuron(0);

	HiddenNeuron h1 = new HiddenNeuron();
	HiddenNeuron h2 = new HiddenNeuron();

	i1.add(h1);
	i1.sub(h2);
	i2.add(h2);
	i2.sub(h1);
	h1.bias();
	h2.bias();
	
	OutputNeuron o1 = new OutputNeuron();

	o1.increaseBy(h1.getValue());
	o1.increaseBy(h2.getValue());
	o1.bias();

	System.out.println("OutputNeuron: "+ o1.toPrint());

    }
}
