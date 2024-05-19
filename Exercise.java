import java.util.Scanner;
class MyThread1 extends Thread{
    private int[] numbers;
    private int start, end, res = 0;
    public MyThread1(int[] numbers, int start, int end)
    {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run(){
        for(int i = start; i <= end; i++){
            res = res + numbers[i];
        }
    }
    public int getSum(){
        return res;
    }
}
class MyThread2 extends Thread{
    private int[] numbers;
    private int start, end, res = 0;
    public MyThread2(int[] numbers, int start, int end)
    {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run(){
        for(int i = start; i <= end; i++){
            res = res + numbers[i];
        }
    }
    public int getSum(){
        return res;
    }
}

public class Exercise {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        int mid = (n / 2);
        MyThread1 t1 = new MyThread1(arr, 0, mid);
        MyThread2 t2 = new MyThread2(arr, mid + 1, n - 1);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        int final_answer = t1.getSum();
        final_answer += t2.getSum();
        System.out.println(final_answer);
    }
}
