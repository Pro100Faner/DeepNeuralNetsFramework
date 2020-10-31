package NeuronsVectors;

public class LayersTest {

    public static InputLayer inputLayer = new InputLayer(5,2);
    public static Layer layer1 = new Layer(3, 5);
    public static Layer layer2 = new Layer(2, 3);
    public static OutputLayer outputLayer = new OutputLayer(2);

    public  static void Start(float... inp){
        inputLayer.SetInput(inp);
        inputLayer.Run(layer1);
        layer1.Run(layer2);
        layer2.Run(outputLayer);
    }

    public static void Train(float... ans){
        outputLayer.Train(ans);
        layer2.Train(outputLayer);
        layer1.Train(layer2);
        inputLayer.Train(layer1);
    }

    public static void main(String[]args){


        for (int i=0;i<100000;i++){
            Start(0,0);
            Train(0,1);
            System.out.println(outputLayer.output[0] + "    " + outputLayer.output[1]);

            Start(0,1);
            Train(1,1);
            System.out.println(outputLayer.output[0] + "    " + outputLayer.output[1]);
//
            Start(1,0);
            Train(1,0);
            System.out.println(outputLayer.output[0] + "    " + outputLayer.output[1]);

            Start(1,1);
            Train(0,0);
            System.out.println(outputLayer.output[0] + "    " + outputLayer.output[1]);


            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }


    }

}
