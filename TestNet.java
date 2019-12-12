public class TestNet{
    public static void main(String[] args){
	System.out.println("layer1");
	
	Net l1 = new Net(5);

	l1.setNeuronX(0,0.0);
	l1.setNeuronX_W(0, 0.10);
	l1.setNeuronY(0,0.1);
	l1.setNeuronY_W(0, 0.11);
	l1.setNeuronBias(0, 2);
	l1.fireNeuron(0);

	l1.setNeuronX(1,0.0);
	l1.setNeuronX_W(1, 0.12);
	l1.setNeuronY(1,0.1);
	l1.setNeuronY_W(1, 0.10);
	l1.setNeuronBias(1, 2);
	l1.fireNeuron(1);

	l1.setNeuronX(2,0.0);
	l1.setNeuronX_W(2, 0.10);
	l1.setNeuronY(2,0.1);
	l1.setNeuronY_W(2, 0.13);
	l1.setNeuronBias(2, 2);
	l1.fireNeuron(2);

	l1.setNeuronX(3,0.0);
	l1.setNeuronX_W(3, 0.10);
	l1.setNeuronY(3,0.1);
	l1.setNeuronY_W(3, 0.14);
	l1.setNeuronBias(3, 2);
	l1.fireNeuron(3);

	l1.setNeuronX(4,0.0);
	l1.setNeuronX_W(4, 0.10);
	l1.setNeuronY(4,0.1);
	l1.setNeuronY_W(4, 0.15);
	l1.setNeuronBias(4, 2);
	l1.fireNeuron(4);

	System.out.println(l1.getZ(0));
	System.out.println(l1.getZ(1));
	System.out.println(l1.getZ(2));
	System.out.println(l1.getZ(3));
	System.out.println(l1.getZ(4));

	System.out.println("layer2");
	
	Net l2 = new Net(5);

	l2.setNeuronX(0,0.0);
	l2.setNeuronX_W(0, 0.20);
	l2.setNeuronY(0,0.1);
	l2.setNeuronY_W(0, 0.21);
	l2.setNeuronBias(0, 2);
	l2.fireNeuron(0);

	l2.setNeuronX(1,0.0);
	l2.setNeuronX_W(1, 0.22);
	l2.setNeuronY(1,0.1);
	l2.setNeuronY_W(1, 0.20);
	l2.setNeuronBias(1, 2);
	l2.fireNeuron(1);

	l2.setNeuronX(2,0.0);
	l2.setNeuronX_W(2, 0.20);
	l2.setNeuronY(2,0.1);
	l2.setNeuronY_W(2, 0.23);
	l2.setNeuronBias(2, 2);
	l2.fireNeuron(2);

	l2.setNeuronX(3,0.0);
	l2.setNeuronX_W(3, 0.20);
	l2.setNeuronY(3,0.1);
	l2.setNeuronY_W(3, 0.24);
	l2.setNeuronBias(3, 2);
	l2.fireNeuron(3);

	l2.setNeuronX(4,0.0);
	l2.setNeuronX_W(4, 0.20);
	l2.setNeuronY(4,0.1);
	l2.setNeuronY_W(4, 0.25);
	l2.setNeuronBias(4, 2);
	l2.fireNeuron(4);

	System.out.println(l2.getZ(0));
	System.out.println(l2.getZ(1));
	System.out.println(l2.getZ(2));
	System.out.println(l2.getZ(3));
	System.out.println(l2.getZ(4));
	
    }
}
