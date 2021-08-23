package p1s3;

public class MainArray {
    public static void main(String[] args) {
        //lazy method, avoid shock
        Array<Integer> arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.removeElement(2);
        System.out.println(arr);
    }
}
