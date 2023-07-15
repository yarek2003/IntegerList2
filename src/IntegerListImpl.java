import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private final Integer[] arrayStorage;
    private int arraySize;


    public  IntegerListImpl (int size)  {
        this.arrayStorage = new Integer[size];

    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateSize();
        arrayStorage[arraySize++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateItem(item);
        validateSize();
        validateIndex(index);
        if (index == arraySize) {
            arrayStorage[arraySize++] = item;
            return item;
        }
        System.arraycopy(arrayStorage, index, arrayStorage, index + 1, arraySize - index);
        arrayStorage[index] = item;
        arraySize++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        validateSize();
        validateIndex(index);
        arrayStorage[arraySize++] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = arrayStorage[index];
        if(index != arraySize){
            System.arraycopy(arrayStorage, index + 1, arrayStorage, index, arraySize - index);
        }
        arraySize--;
        return item;
    }

    @Override
    public boolean contains(Integer item, String Inspection_Selection_Bubbles) {
        switch (Inspection_Selection_Bubbles) {
            case "Inspection":
                sortInsertion(arrayStorage);
                break;
            case "Selection":
                sortSelection(arrayStorage);
                break;
            case "Bubbles":
                sortBubbles(arrayStorage);
                break;
        }

        int min = 0;
        int max = arrayStorage.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arrayStorage[mid]) {
                return true;
            }

            if (item < arrayStorage[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < arraySize; i++) {
            if (item.equals(arrayStorage[i])) return i ;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = arraySize-1; i >=  0; i--) {
            if (item.equals(arrayStorage[i])) return i ;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return arrayStorage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public boolean isEmpty() {
        return arraySize == 0;
    }

    @Override
    public void clear() {
        arraySize = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arrayStorage, arraySize);
    }

    @Override
    public IntegerList integerListCopy(IntegerList list) {
        return null;
    }

    @Override
    public Integer[] getStorage() {
        return new Integer[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Integer el : arrayStorage) {
            if (el != null) {
                sb.append(el + " ");
            }
        }
        return sb.toString();
    }

    private static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private void sortBubbles(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new ItemNotFoundException();
        }
    }

    private void validateIndex(int index) {
        if (index > arraySize || index < 0) {
            throw new InvalidIndexException();
        }
    }

    private void validateSize() {
        if (arraySize >= arrayStorage.length) {
            throw new StorageIsFullException();
        }
    }
}
