public interface IntegerList {
    Integer add(Integer item);


    Integer add(int index, Integer item);


    Integer set(int index, Integer item);

    Integer remove(Integer item);


    Integer remove(int index);

    boolean contains(Integer item, String Inspection_Selection_Bubbles);

    int indexOf(Integer item);


    int lastIndexOf(Integer item);

    Integer get(int index);


    boolean equals(IntegerList otherList);


    int size();

    boolean isEmpty();


    void clear();


    Integer[] toArray();

    public IntegerList integerListCopy(IntegerList list);

    Integer[] getStorage();

}
