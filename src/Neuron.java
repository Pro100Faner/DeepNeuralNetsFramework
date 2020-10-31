public class Neuron {
    public double input;
    public double output;
    public double exception;

    public Neuron(){
        input=0;
        output=0;
        exception=0;
    }

    public double Activate(){
     return this.output=1/(1+Math.exp(-input));
    }

    public void Remove(){
        this.input=0;
        this.exception=0;
        this.output=0;
    }
}
