public class ImprovedInputNeuron {

    public double learningRate;

    public InputNeuron[] inputLayer;
    public Neuron[] layer1;
    public Neuron[] layer2;
    public Neuron[] layer3;
    public Neuron[] layer4;
    public Neuron[] layer5;
    public Neuron[] layer6;
    public Neuron[] layer7;

    public double allInput;
    public double allOutput;
    public double outputLayerException;
    public double inputLayerException;

    public double[][] weights;

    public ImprovedInputNeuron(double LearningRate){
        learningRate = LearningRate;
        allInput = 0;
        outputLayerException = 0;
        inputLayerException = 0;
        allOutput = 0;
        inputLayer = new InputNeuron[1];
        layer1 = new Neuron[5];
        layer2 = new Neuron[7];
        layer3 = new Neuron[10];
        layer4 = new Neuron[15];
        layer5 = new Neuron[20];
        layer6 = new Neuron[30];
        layer7 = new Neuron[1];
        weights = new double[7][];

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



    public void Run(){

        inputLayer[0].input = this.allInput;

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

        allOutput = layer7[0].Activate();

    }

    public void Clear(){
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

        this.allOutput = 0;
        this.allInput = 0;
        this.outputLayerException = 0;
        this.inputLayerException = 0;

    }

    public void Train(){

        // Calculate layer's errors for getting delta weights with backpropagation algorithm;

        layer7[0].exception = this.outputLayerException * allOutput * (1 - allOutput);

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
                weights[1][layer2.length*i+j] += layer1[i].output * layer2[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer2.length;i++){
            for (int j=0;j<layer3.length;j++){
                weights[2][layer3.length*i+j] += layer2[i].output * layer3[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer3.length;i++){
            for (int j=0;j<layer4.length;j++){
                weights[3][layer4.length*i+j] += layer3[i].output * layer4[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer4.length;i++){
            for (int j=0;j<layer5.length;j++){
                weights[4][layer5.length*i+j] += layer4[i].output * layer5[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer5.length;i++){
            for (int j=0;j<layer6.length;j++){
                weights[5][layer6.length*i+j] += layer5[i].output * layer6[j].exception * learningRate;
            }
        }

        for (int i=0;i<layer6.length;i++){
            for (int j=0;j<layer7.length;j++){
                weights[6][layer7.length*i+j] += layer6[i].output * layer7[j].exception * learningRate;
            }
        }
    }

    public static void main(String[]args){
        ImprovedInputNeuron improvedInputNeuron = new ImprovedInputNeuron(0.25);
        for (int i=0;i<10000;i++){
            improvedInputNeuron.allInput = 1;
            improvedInputNeuron.Run();
            improvedInputNeuron.outputLayerException = 0-improvedInputNeuron.allOutput;
            System.out.println(improvedInputNeuron.allOutput);
            improvedInputNeuron.Train();
            improvedInputNeuron.Clear();
            improvedInputNeuron.allInput = 0;
            improvedInputNeuron.Run();
            improvedInputNeuron.outputLayerException = 1-improvedInputNeuron.allOutput;
            System.out.println(improvedInputNeuron.allOutput);
            improvedInputNeuron.Train();
            improvedInputNeuron.Clear();
            System.out.println();
            System.out.println();
        }

    }
}
