package NeuronsVectors;

public class Layer {

    public float[] input;
    public float[] output;
    public float[] exception;
    public float[] weightsBetweenThisAndNext;

    public Layer(int sizeOfNext, int sizeOfThis){
        input = new float[sizeOfThis];
        output = new float[sizeOfThis];
        exception = new float[sizeOfThis];
        weightsBetweenThisAndNext = new float[sizeOfNext*sizeOfThis];
        for(int i=0;i<weightsBetweenThisAndNext.length;i++){
            weightsBetweenThisAndNext[i] = (float)Math.random();
        }
    }


    public void Run(Layer nextLayer){
        nextLayer.input = Neurolib.Multiple(this.output,weightsBetweenThisAndNext);
        nextLayer.output = Neurolib.Activate(nextLayer.input);
    }

    public void Run(OutputLayer nextLayer){
        nextLayer.input = Neurolib.Multiple(this.output,weightsBetweenThisAndNext);
        nextLayer.output = Neurolib.Activate(nextLayer.input);
    }


    public void Train(Layer nextLayer){
        this.exception = Neurolib.Backprop(nextLayer.exception, weightsBetweenThisAndNext, this.output);
        Neurolib.UpdateWeights(weightsBetweenThisAndNext,0.25f, this.output, nextLayer.exception);
    }

    public void Train(OutputLayer nextLayer){
        this.exception = Neurolib.Backprop(nextLayer.exception, weightsBetweenThisAndNext, this.output);
        Neurolib.UpdateWeights(weightsBetweenThisAndNext,0.25f, this.output, nextLayer.exception);
    }



}
