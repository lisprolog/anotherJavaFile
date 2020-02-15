public class XOR{

    /*
      A  B | XOR
      ------------
      0  0 | 0
      0  1 | 1
      1  0 | 1   <- this example
      1  1 | 0

     */
    
    public static void main(String[] args){

	InputNeuron i1 = new InputNeuron(1);
	InputNeuron i2 = new InputNeuron(0);

	HiddenNeuron h1 = new HiddenNeuron();
	HiddenNeuron h2 = new HiddenNeuron();

	OutputNeuron o1 = new OutputNeuron();
	OutputNeuron o2 = new OutputNeuron();

	System.out.println(i1.getValue());
	System.out.println(i2.getValue());

	h1.add();
	h1.bias();
	h1.heaviside();
	h2.sub();
	h2.bias();
	h2.heaviside();

	System.out.println(h1.getValue());
	System.out.println(h2.getValue());

	o1.increaseBy(h1.getValue());
	o1.increaseBy(h2.getValue());
	o1.bias();
	o1.heaviside();

	System.out.println(o1.getValue());
    }
}
