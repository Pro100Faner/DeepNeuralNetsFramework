import java.util.ArrayList;

public class MachineVision {

    public static ArrayList<InputNeuron> inputLayer = new ArrayList<>();
    public static ArrayList<Neuron> layer1 = new ArrayList<>();
    public static ArrayList<Neuron> layer2 = new ArrayList<>();

    public static int inputLayerSize=2;
    public static int layer1Size=3;
    public static int layer2Size=1;

    public static final int NUMBEROFLAYERS = 3;

    public static double learningRate = 0.25;

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

        for (int i=0;i<inputLayerSize;i++){
            inputLayer.add(new InputNeuron());
        }
        for (int i=0;i<layer1Size;i++){
            layer1.add(new Neuron());
        }
        for (int i=0;i<layer2Size;i++){
            layer2.add(new Neuron());
        }
    }


    public static void Start(double... in){
        for (int i=0;i<inputLayerSize;i++){
            inputLayer.get(i).input=in[i];
        }
        for (int i=0;i<inputLayerSize;i++){
            for (int j=0;j<layer1Size;j++){
                layer1.get(j).input += inputLayer.get(i).input * weights[0][layer1Size*i+j];
            }
        }
        for (int i=0;i<layer1Size;i++){
            layer1.get(i).Activate();
        }
        for (int i=0;i<layer1Size;i++){
            for (int j=0;j<layer2Size;j++){
                layer2.get(j).input += layer1.get(i).output * weights[1][layer2Size*i+j];
            }
        }
        for (int i=0;i<layer2Size;i++){
            System.out.println(layer2.get(i).Activate());
        }
    }

    public static void Training(double ... out){
        for (int i=0;i<layer2Size;i++){
            layer2.get(i).exception = (out[i] - layer2.get(i).output) * layer2.get(i).output * (1-layer2.get(i).output);
        }
        for (int i=0;i<layer1Size;i++){
            for(int j=0;j<layer2Size;j++){
                layer1.get(i).exception += weights[1][layer2Size*i+j] * layer2.get(j).exception * layer1.get(i).output * (1-layer1.get(i).output);
            }
        }
        for (int i=0;i<layer1Size;i++){
            for(int j=0;j<layer2Size;j++) {
                weights[1][layer2Size*i+j] += layer1.get(i).output * learningRate * layer2.get(j).exception;
            }
        }
        for(int i=0;i<inputLayerSize;i++){
            for(int j=0;j<layer1Size;j++){
                weights[0][layer1Size*i+j] += inputLayer.get(i).input * layer1.get(j).exception * learningRate;
            }
        }
    }

    public static void Clear(){
        for (int i=0;i<layer1Size;i++){
            layer1.get(i).Remove();
        }
        for(int i=0;i<layer2Size;i++){
            layer2.get(i).Remove();
        }
    }

    public static void main(String[]args){
        for (int i=0;i<100000;i++){
            Start(0,0);
            Training(0);
            Clear();

            Start(0,1);
            Training(1);
            Clear();

            Start(1,0);
            Training(1);
            Clear();

            Start(1,1);
            Training(0);
            Clear();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
