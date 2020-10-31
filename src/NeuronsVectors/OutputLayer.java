package NeuronsVectors;

public class OutputLayer {

    public float[] input;
    public float[] output;
    public float[] exception;

    public OutputLayer(int sizeOfThis){
        input = new float[sizeOfThis];
        output = new float[sizeOfThis];
        exception = new float[sizeOfThis];
    }


    public void Train(float... ans){
        this.exception = Neurolib.GetOutputLayerException(ans, this.output);


    }

}
