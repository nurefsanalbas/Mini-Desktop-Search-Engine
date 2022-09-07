package nurefsanalbas_;

/**
 *
 * @author nurefsanalbas
 */
public class MinHeap<T extends Comparable<T>> {

    MyFile heap[];//I created the heap as <MyFile because I keep a file in it.
    public int size;

    public MinHeap(int N) {
        heap = new MyFile[N];
        size = 0;
    }

    int parent(int index) {
        return (index - 1) / 2;
    }

    void swap(int i, int j) {
        MyFile temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void insert(MyFile data) {//I insert file into the heap with this method.
        if (size < heap.length) {
            heap[size] = data;
            int current = size;
            int parent = parent(current);

            while (heap[current].compareTo(heap[parent]) > 0) {
                swap(current, parent);
                current = parent;
                parent = parent(current);
            }
            size++;
        } else {
            System.out.println("Heap is full!");
        }
    }

    void SortAndPrintHeap() {//I sorted relevance value higher to lower and I printed heap.
        //For sorting I made this algorithm.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (heap[i] != null && heap[j] != null) {
                    if (heap[i].rv > heap[j].rv) {
                        swap(i, j);
                    }
                }
            }
        }
        //For printing the heap
        for (int i = 0; i < size; i++) {
            if (heap[i] != null) {
                System.out.println(heap[i].filename + ":" + (heap[i].rv));
            }
        }

    }

}
