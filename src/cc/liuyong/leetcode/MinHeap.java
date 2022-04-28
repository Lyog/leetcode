package cc.liuyong.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinHeap<T> {
    T[] arr;
    private static int capacity = Integer.MAX_VALUE;
    private Comparator<T> comparator;

    private int currentIndex = 0;

    public MinHeap(int capacity, Comparator<T> comparator) {
        if (capacity < 1) {
            throw new RuntimeException("error");
        }

        arr = (T[]) new Object[capacity];
        MinHeap.capacity = capacity;
        this.comparator = comparator;
    }

    public MinHeap(Comparator<T> comparator) {
        this(capacity, comparator);
    }

    public void add(T t) {
        if (currentIndex >= capacity) {
            // 超出容量更新
            update(t);
            return;
        }
        // 插入节点
        doAdd(t);
    }

    private void update(T add) {
        removeMin();
        doAdd(add);
    }

    private void doAdd(T t) {
        // 第一个节点
        if (currentIndex < 1) {
            arr[0] = t;
            currentIndex++;
            return;
        }
        // 插入到尾部，然后平衡
        arr[currentIndex] = t;
        addBalance(currentIndex);
        currentIndex++;
    }

    private void addBalance(int index) {
        // 获取父节点
        int parentIndex = getParentIndex(index);
        if (parentIndex < 0) {
            return;
        }
        // 比较父节点和和自己，小于就替换
        if (comparator.compare(arr[parentIndex], arr[index]) > 0) {
            replace(parentIndex, index);
        }
        // 再次炒父节点平衡
        addBalance(parentIndex);

    }

    public static void main(String[] args) {
        MinHeap<Integer> m = new MinHeap<>(9, Comparator.comparingInt(o -> o));
        m.add(4);
        m.add(7);
        m.add(2);
        m.add(5);
        m.add(6);
        m.add(1);
        m.add(0);
        m.add(3);
        m.add(8);
        m.removeMin();
    }

    private void replace(int index, int index1) {
        T t = arr[index];
        arr[index] = arr[index1];
        arr[index1] = t;
    }

    /**
     * 删除首节点 把尾节点放到首节点，然后平衡
     *
     * @return
     */
    public T removeMin() {
        if (currentIndex < 1) {
            throw new RuntimeException();
        }
        T t = arr[0];
        // 把尾节点放到首节点
        arr[0] = arr[currentIndex - 1];
        // 平衡
        removeMinBalance(0);
        currentIndex--;
        System.err.println(Arrays.toString(arr));
        return t;
    }

    private void removeMinBalance(int index) {
        // 获取子节点
        int childIndex = getChildIndex(index);
        if (childIndex >= currentIndex) {
            return;
        }
        int minIndex = 0;
        // 找出最小的子节点
        if (childIndex + 1 < currentIndex) {
            if (comparator.compare(arr[childIndex], arr[childIndex + 1]) > 0) {
                minIndex = childIndex + 1;
            }
        } else {
            minIndex = childIndex;
        }
        // 最小的子节点和父节点比较，大于子节点就替换
        if (comparator.compare(arr[index], arr[minIndex]) > 0) {
            replace(minIndex, index);
        } else {
            return;
        }
        // 再次平衡
        removeMinBalance(minIndex);
    }

    private int getParentIndex(int index) {
        if (index == 0) {
            return -1;
        }
        return (index - 1) / 2;
    }

    private int getChildIndex(int index) {
        return index * 2 + 1;
    }

}
