package p1s2.selectionSort;

import p1s2.sortByInsertion.InsertionSort;

public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i -1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>>  void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        //此处可用 反射
        if (sortName.equals("SelectionSort")) {
            SelectionSort.sort(arr);
        } else if (sortName.equals("InsertionSort")) {
            InsertionSort.sort(arr);
        } else if (sortName.equals("InsertionSort2")) {
            InsertionSort.sort2(arr);
        }else if (sortName.equals("InsertionSort3")) {
            InsertionSort.sort3(arr);
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(arr.getClass().getName() + "failed");
        }
        System.out.println(String.format("%s, n = %d : %f s", sortName, arr.length, time));
    }

    //Java 反射
    /*public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr){

        try{
            Class sortClass = Class.forName(sortname);
            Method sortMethod = sortClass.getMethod("sort", Comparable[].class);
            Object[] params = new Object[]{arr};

            long startTime = System.nanoTime();
            sortMethod.invoke(null, params);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            if(!SortingHelper.isSorted(arr))
                throw new RuntimeException(sortname + " failed");
            System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Error in SortingHelper.sortTest!");
        }
    }*/
}
