public class TestNeuron{
    public static void main(String [] args){
        Neuron n1 = new Neuron();
        n1.setX(0.1);
        n1.setY(0.2);
        n1.fire();
        System.out.println(n1.getZ());
        
        Neuron n2 = new Neuron();
        n2.setX(0.1);
        n2.setY(0.3);
        n2.fire();
        System.out.println(n2.getZ());
        
        Neuron n3 = new Neuron();
        n3.setX(n1.getZ());
        n3.setY(n2.getZ());
        n3.fire();
        System.out.println(n3.getZ());
        
    }

}
