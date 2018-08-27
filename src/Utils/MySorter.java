package Utils;

public class MySorter {

    private double[] data = null;
    private int[] index = null;
    int tmpSize = 0;

    /**
     * The constructor
     *
     * @param data
     */
    public MySorter(double[] data) {
        this.data = data;
        index = new int[data.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        tmpSize = data.length;
    }

    /**
     * Utility method used for the Heap sort algorithm
     *
     * @param i
     * @return 2*i
     */
    private int Left(int i) {
        return (i << 1) + 1; // 2*i;
    }

    /**
     * Utility method used for the Heap sort algorithm
     *
     * @param i
     * @return (2*i)+1
     */
    private int Right(int i) {
        return ((i << 1) | 1) + 1; // (2*i)+1;
    }

    /**
     * Utility method used for the Heap sort algorithm
     *
     * @param i
     * @return floor(i);
     */
    private int Parent(int i) {
        return i >> 1; // floor(i);
    }

    /**
     * Utility method used for the Heap sort algorithm
     *
     * @param i
     */
    private void HeapifyRecursive(int i) {
        int left = Left(i);
        int right = Right(i);
        int largest = 0;
        double tempo;
        int tmpIndex = 0;
        if ((left < tmpSize) && getData()[left] > getData()[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < tmpSize && getData()[right] > getData()[largest]) {
            largest = right;
        }
        if (largest != i) {
            tempo = getData()[i];
            getData()[i] = getData()[largest];
            getData()[largest] = tempo;

            tmpIndex = getIndex()[i];
            index[i] = getIndex()[largest];
            index[largest] = tmpIndex;
            HeapifyRecursive(largest);
        }
    }

    /**
     * Utility method used for the Heap sort algorithm
     *
     * @param A
     */
    private void BuildHeap() {
        int i = 0;
        for (i = (this.tmpSize >> 1) - 1; i >= 0; i = i - 1) {
            HeapifyRecursive(i);
        }
    }

    /**
     * A utility method which implements the heap sort algorithm.
     *
     * @param A
     */
    private void HeapSort() {
        BuildHeap();
        int i = 0;
        double tmp = 0;
        int tmpIndex = 0;
        //int tmpSize = A.size;

        for (i = tmpSize - 1; i > 0; i--) {
            tmp = getData()[i];
            getData()[i] = getData()[0];
            getData()[0] = tmp;
            tmpIndex = getIndex()[i];
            index[i] = getIndex()[0];
            index[0] = tmpIndex;
            tmpSize -= 1;
            HeapifyRecursive(0);
        }
    }

    public void sortIt() {
        HeapSort();
    }

    /**
     * @return the data
     */
    public double[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(double[] data) {
        this.data = data;
    }

    /**
     * @return the index
     */
    public int[] getIndex() {
        return index;
    }
}
