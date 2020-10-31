import java.util.Arrays;

public class TestArchitectureNeuralNetwork {

    public double learningRate;

    public ImprovedInputNeuron[] inputLayer;
    public ImprovedNeuron[] layer1;
    public ImprovedNeuron[] layer2;
    public ImprovedNeuron[] layer3;
    public ImprovedNeuron[] layer4;
    public ImprovedNeuron[] layer5;
    public ImprovedNeuron[] layer6;
    public ImprovedNeuron[] layer7;

    public double[][] weights = new double[7][];


    public TestArchitectureNeuralNetwork(){

        learningRate = 0.15;
        inputLayer = new ImprovedInputNeuron[2];
        layer1 = new ImprovedNeuron[3];
        layer2 = new ImprovedNeuron[1];
        layer3 = new ImprovedNeuron[2];
        layer4 = new ImprovedNeuron[1];
        layer5 = new ImprovedNeuron[3];
        layer6 = new ImprovedNeuron[2];
        layer7 = new ImprovedNeuron[1];

        for (int i=0;i<inputLayer.length;i++){
            inputLayer[i] = new ImprovedInputNeuron(0.15);
        }
        for (int i=0;i<layer1.length;i++){
            layer1[i] = new ImprovedNeuron(0.15);
        }
        for (int i=0;i<layer2.length;i++){
            layer2[i] = new ImprovedNeuron(0.15);
        }
        for (int i=0;i<layer3.length;i++){
            layer3[i] = new ImprovedNeuron(0.15);
        }
        for (int i=0;i<layer4.length;i++){
            layer4[i] = new ImprovedNeuron(0.15);
        }
        for (int i=0;i<layer5.length;i++){
            layer5[i] = new ImprovedNeuron(0.15);
        }
        for (int i=0;i<layer6.length;i++){
            layer6[i] = new ImprovedNeuron(0.15);
        }
        for (int i=0;i<layer7.length;i++){
            layer7[i] = new ImprovedNeuron(0.15);
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



    public void Run(double ... in){

        for (int i=0;i<inputLayer.length;i++){
            inputLayer[i].allInput = in[i];
        }

        for (int i=0;i<inputLayer.length;i++){
            inputLayer[i].Run();
        }


        for(int i=0;i<inputLayer.length;i++){
            for (int j=0;j<layer1.length;j++){
                layer1[j].allInput += inputLayer[i].allOutput * weights[0][layer1.length*i+j];
            }
        }
        for (int i=0;i<layer1.length;i++){
            layer1[i].Run();
        }

        for (int i=0;i<layer1.length;i++){
            for (int j=0;j<layer2.length;j++){
                layer2[j].allInput += layer1[i].allOutput * weights[1][layer2.length*i+j];
            }
        }
        for (int i=0;i<layer2.length;i++){
            layer2[i].Run();
        }

        for (int i=0;i<layer2.length;i++){
            for (int j=0;j<layer3.length;j++){
                layer3[j].allInput += layer2[i].allOutput * weights[2][layer3.length*i+j];
            }
        }
        for (int i=0;i<layer3.length;i++){
            layer3[i].Run();
        }

        for (int i=0;i<layer3.length;i++){
            for (int j=0;j<layer4.length;j++){
                layer4[j].allInput += layer3[i].allOutput * weights[3][layer4.length*i+j];
            }
        }
        for (int i=0;i<layer4.length;i++){
            layer4[i].Run();
        }

        for (int i=0;i<layer4.length;i++){
            for (int j=0;j<layer5.length;j++){
                layer5[j].allInput += layer4[i].allOutput * weights[4][layer5.length*i+j];
            }
        }
        for (int i=0;i<layer5.length;i++){
            layer5[i].Run();
        }

        for (int i=0;i<layer5.length;i++){
            for (int j=0;j<layer6.length;j++){
                layer6[j].allInput += layer5[i].allOutput * weights[5][layer6.length*i+j];
            }
        }
        for (int i=0;i<layer6.length;i++){
            layer6[i].Run();
        }

        for (int i=0;i<layer6.length;i++){
            for (int j=0;j<layer7.length;j++){
                layer7[j].allInput += layer6[i].allOutput * weights[6][layer7.length*i+j];
            }
        }
        for (int i=0;i<layer7.length;i++){
            layer7[i].Run();
        }

    }


    public void Train(double...out){

        // Calculate layer's errors for getting delta weights with backpropagation algorithm;

        for (int i=0;i<layer7.length;i++){
            layer7[i].outputLayerException = (out[i] - layer7[i].allOutput) * layer7[i].allOutput * (1 - layer7[i].allOutput);


            System.out.print(layer7[i].allOutput);
            System.out.print("     ");
            System.out.println(layer7[i].allOutput>0.5?1:0);

            layer7[i].Train();
        }

        for (int i=0;i<layer6.length;i++){
            for (int j=0;j<layer7.length;j++){
                layer6[i].outputLayerException += weights[6][layer7.length*i+j] * layer7[j].inputLayerException * layer6[i].allOutput * (1 - layer6[i].allOutput);

            }
        }

        for (int i=0;i<layer6.length;i++){
            layer6[i].Train();
        }

        for (int i=0;i<layer5.length;i++){
            for (int j=0;j<layer6.length;j++){
                layer5[i].outputLayerException += weights[5][layer6.length*i+j] * layer6[j].inputLayerException * layer5[i].allOutput * (1 - layer5[i].allOutput);

            }
        }

        for (int i=0;i<layer5.length;i++){
            layer5[i].Train();
        }

        for (int i=0;i<layer4.length;i++){
            for (int j=0;j<layer5.length;j++){
                layer4[i].outputLayerException += weights[4][layer5.length*i+j] * layer5[j].inputLayerException * layer4[i].allOutput * (1 - layer4[i].allOutput);

            }
        }

        for (int i=0;i<layer4.length;i++){
            layer4[i].Train();
        }

        for (int i=0;i<layer3.length;i++){
            for (int j=0;j<layer4.length;j++){
                layer3[i].outputLayerException += weights[3][layer4.length*i+j] * layer4[j].inputLayerException * layer3[i].allOutput * (1 - layer3[i].allOutput);

            }
        }

        for (int i=0;i<layer3.length;i++){
            layer3[i].Train();
        }

        for (int i=0;i<layer2.length;i++){
            for (int j=0;j<layer3.length;j++){
                layer2[i].outputLayerException += weights[2][layer3.length*i+j] * layer3[j].inputLayerException * layer2[i].allOutput * (1 - layer2[i].allOutput);

            }
        }

        for (int i=0;i<layer2.length;i++){
            layer2[i].Train();
        }

        for (int i=0;i<layer1.length;i++){
            for (int j=0;j<layer2.length;j++){
                layer1[i].outputLayerException += weights[1][layer2.length*i+j] * layer2[j].inputLayerException * layer1[i].allOutput * (1 - layer1[i].allOutput);

            }
        }

        for(int i=0;i<layer1.length;i++){
            layer1[i].Train();
        }

        for (int i=0;i<inputLayer.length;i++){
            for (int j=0;j<layer1.length;j++){
               inputLayer[i].outputLayerException += weights[0][layer1.length*i+j] * layer1[j].inputLayerException * inputLayer[i].allOutput * (1 - inputLayer[i].allOutput);

            }
        }

        for(int i=0;i<inputLayer.length;i++){
            inputLayer[i].Train();
        }

        // calculate and adding delta weights to actual weights;

        for (int i=0;i<inputLayer.length;i++){
            for (int j=0;j<layer1.length;j++){
                weights[0][layer1.length*i+j] += inputLayer[i].allOutput * layer1[j].inputLayerException * learningRate;
            }
        }

        for (int i=0;i<layer1.length;i++){
            for (int j=0;j<layer2.length;j++){
                weights[1][layer2.length*i+j] += layer1[i].allOutput * layer2[j].inputLayerException * learningRate;
            }
        }

        for (int i=0;i<layer2.length;i++){
            for (int j=0;j<layer3.length;j++){
                weights[2][layer3.length*i+j] += layer2[i].allOutput * layer3[j].inputLayerException * learningRate;
            }
        }

        for (int i=0;i<layer3.length;i++){
            for (int j=0;j<layer4.length;j++){
                weights[3][layer4.length*i+j] += layer3[i].allOutput * layer4[j].inputLayerException * learningRate;
            }
        }

        for (int i=0;i<layer4.length;i++){
            for (int j=0;j<layer5.length;j++){
                weights[4][layer5.length*i+j] += layer4[i].allOutput * layer5[j].inputLayerException * learningRate;
            }
        }

        for (int i=0;i<layer5.length;i++){
            for (int j=0;j<layer6.length;j++){
                weights[5][layer6.length*i+j] += layer5[i].allOutput * layer6[j].inputLayerException * learningRate;
            }
        }

        for (int i=0;i<layer6.length;i++){
            for (int j=0;j<layer7.length;j++){
                weights[6][layer7.length*i+j] += layer6[i].allOutput * layer7[j].inputLayerException * learningRate;
            }
        }

    }



    public void Clear(){
        for (int i=0;i<inputLayer.length;i++){
            inputLayer[i].Clear();
        }

        for (int i=0;i<layer1.length;i++){
            layer1[i].Clear();
        }

        for (int i=0;i<layer2.length;i++){
            layer2[i].Clear();
        }

        for (int i=0;i<layer3.length;i++){
            layer3[i].Clear();
        }

        for (int i=0;i<layer4.length;i++){
            layer4[i].Clear();
        }

        for (int i=0;i<layer5.length;i++){
            layer5[i].Clear();
        }

        for (int i=0;i<layer6.length;i++){
            layer6[i].Clear();
        }

        for (int i=0;i<layer7.length;i++){
            layer7[i].Clear();
        }
    }



    public static void main(String[]args){
        TestArchitectureNeuralNetwork tann = new TestArchitectureNeuralNetwork();

        System.out.println("START");
        for (int i=0;i<2000;i++){
                //System.out.println(Arrays.deepToString(tann.weights));
            System.out.println();
            tann.Run(0,0);
            tann.Train(0);
            tann.Clear();

            tann.Run(1,1);
            tann.Train(1);
            tann.Clear();

            System.out.println();
            System.out.println();

        }

    }
}
