package NeuronsVectors;


public class Test {

    public static int inputLayerSize=2;
    public static int layer1Size=3;
    public static int layer2Size=2;

    public static double[] inputLayer_in = new double[inputLayerSize];
    public static double[] layer1_in = new double[layer1Size];
    public static double[] layer2_in = new double[layer2Size];

    //public static double[] inputLayer_out = new double[inputLayerSize];
    public static double[] layer1_out = new double[layer1Size];
    public static double[] layer2_out = new double[layer2Size];

    //public static double[] inputLayer_exc = new double[inputLayerSize];
    public static double[] layer1_exc = new double[layer1Size];
    public static double[] layer2_exc = new double[layer2Size];


    public static final int NUMBEROFLAYERS = 3;

    public static double learningRate = 0.85;

    public static double weights[][] = new double[NUMBEROFLAYERS-1][];

    static {

        weights[0] = new double[inputLayerSize*layer1Size];
        for (int i=0;i<weights[0].length;i++){
            weights[0][i] = Math.random();
        }
        weights[1] = new double[layer1Size*layer2Size];
        for (int i=0;i<weights[1].length;i++){
            weights[1][i] = Math.random();
        }

    }


    public static void Start(double... in){
        for (int i=0;i<inputLayerSize;i++){
            inputLayer_in[i] = in[i];
        }

        layer1_in = Neurolib.Multiple(inputLayer_in,weights[0]);

        layer1_out = Neurolib.Activate(layer1_in);

        layer2_in = Neurolib.Multiple(layer1_out, weights[1]);

        layer2_out = Neurolib.Activate(layer2_in);

        for (int i=0;i<layer2Size;i++){
            System.out.println(layer2_out[i]+"   output");
        }
    }

    public static void Training(double ... out){
        layer2_exc = Neurolib.GetOutputLayerException(out,layer2_out);
        layer1_exc = Neurolib.Backprop(layer2_exc, weights[1], layer1_out);
        Neurolib.UpdateWeights(weights[1], learningRate, layer1_out, layer2_exc);
        Neurolib.UpdateWeights(weights[0], learningRate, inputLayer_in, layer1_exc);
    }

    public static void main(String[]args){
        for (int i=0;i<100000;i++){
            Start(0,0);
            Training(0,1);

            Start(0,1);
            Training(1,0);

            Start(1,0);
            Training(1,0);

            Start(1,1);
            Training(0,0);


            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }

        for (int i=0;i<weights[0].length;i++){
            System.out.println(weights[0][i]);
        }
        System.out.println();
        for (int i=0;i<weights[1].length;i++){
            System.out.println(weights[1][i]);
        }
    }



}
