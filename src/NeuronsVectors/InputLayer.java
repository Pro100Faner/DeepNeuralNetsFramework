package NeuronsVectors;

public class InputLayer {

    public float[] input;
    public float[] weightsBetweenThisAndNext;

    public InputLayer(int sizeOfNext, int sizeOfThis){
        input = new float[sizeOfThis];
        weightsBetweenThisAndNext = new float[sizeOfNext*sizeOfThis];
        for(int i=0;i<weightsBetweenThisAndNext.length;i++){
            weightsBetweenThisAndNext[i] = (float)Math.random();
        }
    }


    public void SetInput(float... inp){
        input = inp;
    }

    public void Run(Layer nextLayer){
        nextLayer.input = Neurolib.Multiple(this.input, weightsBetweenThisAndNext);
        nextLayer.output = Neurolib.Activate(nextLayer.input);
    }

    public void Train(Layer nextLayer){

        Neurolib.UpdateWeights(weightsBetweenThisAndNext,0.25f, this.input, nextLayer.exception);


    }

}
