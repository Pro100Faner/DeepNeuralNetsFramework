package NeuronsVectors;

public class Neurolib {

    public static float[] Multiple(float[] previousLayerOutput, float[] weightsBetweenLayers) {                                                                               //work
        float[] res = new float[weightsBetweenLayers.length / previousLayerOutput.length];                                                                               //work
                                                                               //work
        int weightsIndexer = 0;                                                                               //work
        for (int i = 0; i < previousLayerOutput.length; i++) {                                                                               //work
            for (int j = 0; j < res.length; j++) {                                                                               //work
                res[j] += previousLayerOutput[i] * weightsBetweenLayers[weightsIndexer];                                                                               //work
                weightsIndexer++;                                                                               //work
            }                                                                               //work
        }                                                                               //work
                                                                               //work
        return res;                                                                               //work
    }                                                                               //work
                                                                               //work
                                                                               //work
    public static double[] Multiple(double[] previousLayerOutput, double[] weightsBetweenLayers) {                                                                               //work
        double[] res = new double[weightsBetweenLayers.length / previousLayerOutput.length];                                                                               //work
                                                                               //work
        int weightsIndexer = 0;                                                                               //work
        for (int i = 0; i < previousLayerOutput.length; i++) {                                                                               //work
            for (int j = 0; j < res.length; j++) {                                                                               //work
                res[j] += previousLayerOutput[i] * weightsBetweenLayers[weightsIndexer];                                                                               //work
                weightsIndexer++;                                                                               //work
            }                                                                               //work
        }                                                                               //work
                                                                               //work
        return res;                                                                               //work
    }                                                                               //work


                                                                               // Work
    public static float[] Activate(float[] input) {                                                                               // Work
        float[] res = new float[input.length];                                                                               // Work
        for (int i = 0; i < input.length; i++) {                                                                               // Work
            res[i] = (float) (1f / (1f + Math.exp(-input[i])));                                                                               // Work
        }                                                                               // Work
        return res;                                                                               // Work
    }                                                                               // Work
                                                                               // Work
    public static double[] Activate(double[] input) {                                                                               // Work
        double[] res = new double[input.length];                                                                               // Work
        for (int i = 0; i < input.length; i++) {                                                                               // Work
            res[i] = (1f / (1f + Math.exp(-input[i])));                                                                               // Work
        }                                                                               // Work
        return res;                                                                               // Work
    }

    public static float[] GetOutputLayerException(float[] trueAns, float[] currentOutput) {                                             //work
                                             //work
        float[] res = new float[currentOutput.length];                                             //work
        for (int i = 0; i < currentOutput.length; i++) {                                             //work
            res[i] = (trueAns[i] - currentOutput[i]) * currentOutput[i] * (1f - currentOutput[i]);                                             //work
        }                                             //work
        return res;                                             //work
    }                                             //work
                                             //work
    public static double[] GetOutputLayerException(double[] trueAns, double[] currentOutput) {                                             //work
                                             //work
        double[] res = new double[currentOutput.length];                                             //work
        for (int i = 0; i < currentOutput.length; i++) {                                             //work
            res[i] = (trueAns[i] - currentOutput[i]) * currentOutput[i] * (1f - currentOutput[i]);                                             //work
        }                                             //work
        return res;                                             //work
    }                                             //work

    public static float[] Backprop(float[] nextLayerException, float[] weightsBetweenLayers, float[] thisLayerOutput) {                                            //Work
                                            //Work
        float[] res = new float[thisLayerOutput.length];                                            //Work
                                            //Work
        int indexer = 0;                                            //Work
        for (int i = 0; i < thisLayerOutput.length; i++) {                                            //Work
            for (int j = 0; j < nextLayerException.length; j++) {                                            //Work
                res[i] += weightsBetweenLayers[indexer] * nextLayerException[j] * thisLayerOutput[i] * (1 - thisLayerOutput[i]);                                                    //Work
                indexer++;                                                    //Work
            }                                                    //Work
        }                                                    //Work
        return res;                                                    //Work
    }                                                    //Work
                                                    //Work
    public static double[] Backprop(double[] nextLayerException, double[] weightsBetweenLayers, double[] thisLayerOutput) {                                                    //Work
                                                    //Work
        double[] res = new double[thisLayerOutput.length];                                                    //Work
                                                    //Work
        int indexer = 0;                                                    //Work
        for (int i = 0; i < thisLayerOutput.length; i++) {                                                    //Work
            for (int j = 0; j < nextLayerException.length; j++) {                                                    //Work
                res[i] += weightsBetweenLayers[indexer] * nextLayerException[j] * thisLayerOutput[i] * (1 - thisLayerOutput[i]);                                                    //Work
                indexer++;                                                    //Work
            }                                                    //Work
        }                                                    //Work
        return res;                                                    //Work
    }                                                    //Work







    public static float[] UpdateWeights(float[] weightsForUpdate, float LR, float[] beforeWeightsLayerOutput, float[] afterWeightsLayerException) {

        int indexer = 0;
        for(int i=0;i<beforeWeightsLayerOutput.length;i++){
            for(int j=0;j<afterWeightsLayerException.length;j++){
                weightsForUpdate[indexer] += beforeWeightsLayerOutput[i] * afterWeightsLayerException[j] * LR;
                indexer++;
            }
        }

        return weightsForUpdate;
    }

    public static double[] UpdateWeights(double[] weightsForUpdate, double LR, double[] beforeWeightsLayerOutput, double[] afterWeightsLayerException) {

        int indexer = 0;
        for(int i=0;i<beforeWeightsLayerOutput.length;i++){
            for(int j=0;j<afterWeightsLayerException.length;j++){
                weightsForUpdate[indexer] += beforeWeightsLayerOutput[i] * afterWeightsLayerException[j] * LR;
                indexer++;
            }
        }

        return weightsForUpdate;
    }


    public static void main(String[] args) {

    }

}

