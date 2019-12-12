public class Neuron{

    private double x;   //input
    private double x_w;
    private double y;   //input
    private double y_w;
    private int bias;
    private double z;   //output
    
    public Neuron(){} 
    
    public void setX(double x){
        this.x = x;
    }

    public void setX_W(double w){
	this.x_w = w;
    }
    
    public void setY(double y){
        this.y = y;
    }

    public void setY_W(double w){
	this.y_w = w;
    }

    public void setBias(int b){
	this.bias = b;
    }
    
    public void fire(){ // x * weight + y* weight + bias
        this.z = this.x * this.x_w + this.y * this.y_w + this.bias;
    }
    
    public double getZ(){
        return this.z;
    }

}
