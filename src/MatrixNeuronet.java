public class MatrixNeuronet {

    public static float[] Activate(float...input){
        float[] out = new float[input.length];
        for(int i=0;i<input.length;i++){
            out[i] = Activate(input[i]);
        }
        return  out;
    }

    public static float[] Connect(float[] layer1Output, float[] weights){
        float[] layer2Input = new float[weights.length/layer1Output.length];
        for(int i=0;i<layer1Output.length;i++){
            for(int j=0;j<layer2Input.length;j++){
                layer2Input[j] += layer1Output[i] * weights[layer2Input.length*i+j];
            }
        }
        return layer2Input;
    }

    public static float[] GetAntiGradientForOutputLayer(float[] answer, float[] output){
        float[] antiGradient = new float[output.length];
        for(int i=0;i<output.length;i++){
            antiGradient[i] = (answer[i] - output[i]) * output[i] * (1-output[i]);
        }
        return antiGradient;
    }

    public static float[] Backpropagation(float[] weights, float[] layer1Output, float[] layer2Exception){
        float[] layer1AntiGradient = new float[layer1Output.length];

        for(int i=0;i<layer1Output.length;i++){
            for(int j=0;j<layer2Exception.length;j++){
                layer1AntiGradient[i] += weights[layer2Exception.length*i+j] * layer2Exception[j] * layer1Output[i] * (1-layer1Output[i]);
            }
        }
        return layer1AntiGradient;
    }


    public static float[] UpdateWeights(float[] weights,float[] layer1Output, float[] layer2Exception, float learningRate){
        for(int i=0;i<layer1Output.length;i++){
            for(int j=0;j<layer2Exception.length;j++){
                weights[layer2Exception.length*i+j] += layer1Output[i] * layer2Exception[j] * learningRate;
            }
        }
        return weights;
    }

    public static float[] Clear(float[]  in){
        for(int i=0;i<in.length;i++){
            in[i] = 0;
        }
        return in;
    }

    public static float Activate(float input){
        return (float) (1/(1+Math.exp(-input)));
    }


    public static void main(String[]args){
        int sizefirst = 2;
        int sizesecond = 2;
        int sizethird = 1;

        float weights1[] = new float[sizefirst*sizesecond];
        float weights2[] = new float[sizesecond*sizethird];

        for(int i=0;i<weights1.length;i++){
            weights1[i] = 1;
        }
        for(int i=0;i<weights2.length;i++){
            weights2[i] = 1;
        }


        float[] in1 = new float[]{1f,1f};
        float[] out1 = new float[sizefirst];
        //float[] exc1 = new float[sizefirst];

        float[] in2 = new float[sizesecond];
        float[] out2 = new float[sizesecond];
        float[] exc2 = new float[sizesecond];

        float[] in3 = new float[sizethird];
        float[] out3 = new float[sizethird];
        float[] exc3 = new float[sizethird];

        for(int x=0;x<100;x++){
            out1 = Activate(in1);
            in2 = Connect(out1,weights1);
            out2 = Activate(in2);
            in3 = Connect(out2,weights2);
            out3 = Activate(in3);
            System.out.println(out3[0]);

            exc3 = GetAntiGradientForOutputLayer(new float[]{1},out3);
            exc2 = Backpropagation(weights2, out2, exc3);
            weights2 = UpdateWeights(weights2, out2, exc3, 0.85f);
            weights1 = UpdateWeights(weights1, out1, exc2, 0.85f);

            in1 = new float[]{0f,0f};
            in2 = Clear(in2);
            in3 = Clear(in3);

            out1 = Clear(out1);
            out2 = Clear(out2);
            out3 = Clear(out3);

            //exc1 = Clear(exc1);
            exc2 = Clear(exc2);
            exc3 = Clear(exc3);

            out1 = Activate(in1);
            in2 = Connect(out1,weights1);
            out2 = Activate(in2);
            in3 = Connect(out2,weights2);
            out3 = Activate(in3);
            System.out.println(out3[0]);

            exc3 = GetAntiGradientForOutputLayer(new float[]{0},out3);
            exc2 = Backpropagation(weights2, out2, exc3);
            weights2 = UpdateWeights(weights2, out2, exc3, 0.85f);
            weights1 = UpdateWeights(weights1, out1, exc2, 0.85f);

            System.out.println();
            System.out.println();
            System.out.println();

        }
    }
}
