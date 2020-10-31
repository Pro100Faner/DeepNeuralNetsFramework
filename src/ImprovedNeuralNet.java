import java.awt.*;

public class ImprovedNeuralNet {

    public static double learningRate = 0.25;

    public static InputNeuron[] inputLayer = new InputNeuron[3];
    public static Neuron[] layer1 = new Neuron[5];
    public static Neuron[] layer2 = new Neuron[7];
    public static Neuron[] layer3 = new Neuron[10];
    public static Neuron[] layer4 = new Neuron[15];
    public static Neuron[] layer5 = new Neuron[20];
    public static Neuron[] layer6 = new Neuron[30];
    public static Neuron[] layer7 = new Neuron[1];

    public static double[][] weights = new double[7][];

    static{

        for (int i=0;i<inputLayer.length;i++){
            inputLayer[i] = new InputNeuron();
        }

        for (int i=0;i<layer1.length;i++){
            layer1[i] = new Neuron();
        }

        for (int i=0;i<layer2.length;i++){
            layer2[i] = new Neuron();
        }

        for (int i=0;i<layer3.length;i++){
            layer3[i] = new Neuron();
        }

        for (int i=0;i<layer4.length;i++){
            layer4[i] = new Neuron();
        }

        for (int i=0;i<layer5.length;i++){
            layer5[i] = new Neuron();
        }

        for (int i=0;i<layer6.length;i++){
            layer6[i] = new Neuron();
        }

        for (int i=0;i<layer7.length;i++){
            layer7[i] = new Neuron();
        }

        weights[0] = new double[inputLayer.length*layer1.length];

        weights[1] = new double[layer1.length*layer2.length];

        weights[2] = new double[layer2.length*layer3.length];

        weights[3] = new double[layer3.length*layer4.length];

        weights[4] = new double[layer4.length*layer5.length];

        weights[5] = new double[layer5.length*layer6.length];

        weights[6] = new double[layer6.length*layer7.length];

        for (int i=0;i<weights[0].length;i++){
            weights[0][i] = Math.random()-0.5;
        }

        for (int i=0;i<weights[1].length;i++){
            weights[1][i] = Math.random()-0.5;
        }

        for (int i=0;i<weights[2].length;i++){
            weights[2][i] = Math.random()-0.5;
        }

        for (int i=0;i<weights[3].length;i++){
            weights[3][i] = Math.random()-0.5;
        }

        for (int i=0;i<weights[4].length;i++){
            weights[4][i] = Math.random()-0.5;
        }

        for (int i=0;i<weights[5].length;i++){
            weights[5][i] = Math.random()-0.5;
        }

        for (int i=0;i<weights[6].length;i++){
            weights[6][i] = Math.random()-0.5;
        }

    }

    public static void Run(double ... in){

        for (int i=0;i<inputLayer.length;i++){
            inputLayer[i].input = in[i];
        }

        for(int i=0;i<inputLayer.length;i++){
            for (int j=0;j<layer1.length;j++){
                layer1[j].input += inputLayer[i].input * weights[0][layer1.length*i+j];
            }
        }
        for (int i=0;i<layer1.length;i++){
            layer1[i].Activate();
        }

        for (int i=0;i<layer1.length;i++){
            for (int j=0;j<layer2.length;j++){
                layer2[j].input += layer1[i].output * weights[1][layer2.length*i+j];
            }
        }
        for (int i=0;i<layer2.length;i++){
           layer2[i].Activate();
        }

        for (int i=0;i<layer2.length;i++){
            for (int j=0;j<layer3.length;j++){
                layer3[j].input += layer2[i].output * weights[2][layer3.length*i+j];
            }
        }
        for (int i=0;i<layer3.length;i++){
            layer3[i].Activate();
        }

        for (int i=0;i<layer3.length;i++){
            for (int j=0;j<layer4.length;j++){
                layer4[j].input += layer3[i].output * weights[3][layer4.length*i+j];
            }
        }
        for (int i=0;i<layer4.length;i++){
            layer4[i].Activate();
        }

        for (int i=0;i<layer4.length;i++){
            for (int j=0;j<layer5.length;j++){
                layer5[j].input += layer4[i].output * weights[4][layer5.length*i+j];
            }
        }
        for (int i=0;i<layer5.length;i++){
            layer5[i].Activate();
        }

        for (int i=0;i<layer5.length;i++){
            for (int j=0;j<layer6.length;j++){
                layer6[j].input += layer5[i].output * weights[5][layer6.length*i+j];
            }
        }
        for (int i=0;i<layer6.length;i++){
            layer6[i].Activate();
        }

        for (int i=0;i<layer6.length;i++){
            for (int j=0;j<layer7.length;j++){
                layer7[j].input += layer6[i].output * weights[6][layer7.length*i+j];
            }
        }
        for (int i=0;i<layer7.length;i++){
            System.out.println(layer7[i].Activate()>0.5?1+"     "+layer7[i].Activate():0+"     "+layer7[i].Activate());
        }

    }

    public static void Clear(){
        for (int i=0;i<inputLayer.length;i++){
            inputLayer[i].input = 0;
        }

        for (int i=0;i<layer1.length;i++){
            layer1[i].Remove();
        }

        for (int i=0;i<layer2.length;i++){
            layer2[i].Remove();
        }

        for (int i=0;i<layer3.length;i++){
            layer3[i].Remove();
        }

        for (int i=0;i<layer4.length;i++){
            layer4[i].Remove();
        }

        for (int i=0;i<layer5.length;i++){
            layer5[i].Remove();
        }

        for (int i=0;i<layer6.length;i++){
            layer6[i].Remove();
        }

        for (int i=0;i<layer7.length;i++){
            layer7[i].Remove();
        }

    }

    public static void Train(double...out){

        // Calculate layer's errors for getting delta weights with backpropagation algorithm;

        for (int i=0;i<layer7.length;i++){
            layer7[i].exception = (out[i] - layer7[i].output) * layer7[i].output * (1 - layer7[i].output);
        }

        for (int i=0;i<layer6.length;i++){
            for (int j=0;j<layer7.length;j++){
                layer6[i].exception += weights[6][layer7.length*i+j] * layer7[j].exception * layer6[i].output * (1 - layer6[i].output);
            }
        }

        for (int i=0;i<layer5.length;i++){
            for (int j=0;j<layer6.length;j++){
                layer5[i].exception += weights[5][layer6.length*i+j] * layer6[j].exception * layer5[i].output * (1 - layer5[i].output);
            }
        }

        for (int i=0;i<layer4.length;i++){
            for (int j=0;j<layer5.length;j++){
                layer4[i].exception += weights[4][layer5.length*i+j] * layer5[j].exception * layer4[i].output * (1 - layer4[i].output);
            }
        }

        for (int i=0;i<layer3.length;i++){
            for (int j=0;j<layer4.length;j++){
                layer3[i].exception += weights[3][layer4.length*i+j] * layer4[j].exception * layer3[i].output * (1 - layer3[i].output);
            }
        }

        for (int i=0;i<layer2.length;i++){
            for (int j=0;j<layer3.length;j++){
                layer2[i].exception += weights[2][layer3.length*i+j] * layer3[j].exception * layer2[i].output * (1 - layer2[i].output);
            }
        }

        for (int i=0;i<layer1.length;i++){
            for (int j=0;j<layer2.length;j++){
                layer1[i].exception += weights[1][layer2.length*i+j] * layer2[j].exception * layer1[i].output * (1 - layer1[i].output);
            }
        }

        // calculate and adding delta weights to actual weights;

        for (int i=0;i<inputLayer.length;i++){
            for (int j=0;j<layer1.length;j++){
                weights[0][layer1.length*i+j] += inputLayer[i].input * layer1[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer1.length;i++){
            for (int j=0;j<layer2.length;j++){
                weights[1][layer2.length*i+j] += layer1[i].input * layer2[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer2.length;i++){
            for (int j=0;j<layer3.length;j++){
                weights[2][layer3.length*i+j] += layer2[i].input * layer3[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer3.length;i++){
            for (int j=0;j<layer4.length;j++){
                weights[3][layer4.length*i+j] += layer3[i].input * layer4[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer4.length;i++){
            for (int j=0;j<layer5.length;j++){
                weights[4][layer5.length*i+j] += layer4[i].input * layer5[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer5.length;i++){
            for (int j=0;j<layer6.length;j++){
                weights[5][layer6.length*i+j] += layer5[i].input * layer6[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer6.length;i++){
            for (int j=0;j<layer7.length;j++){
                weights[6][layer7.length*i+j] += layer6[i].input * layer7[j].exception * learningRate;
            }
        }

    }

    public static void main(String[]args){

        //System.out.println(Toolkit.getDefaultToolkit().getScreenSize().toString());
        for (int i=0;i<5000;i++){
            Run(0,0,0);
            Train(1);
            Clear();

            Run(1,1,1);
            Train(0);
            Clear();

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }


    }

}
