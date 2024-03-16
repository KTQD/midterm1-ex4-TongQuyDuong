public class Main {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3,
                2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4,
                6, 7, 9, 5, 3, 2, 1, 0 };

        ArrayProcessor processor = new ArrayProcessor(numbers);

        Thread sumThread = new Thread(processor::calculateSum);
        Thread maxThread = new Thread(processor::findMax);

        sumThread.start();
        maxThread.start();

        try {
            sumThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ArrayProcessor{
    private int[] array;
    private int sum;
    private int max;

    public ArrayProcessor(int[] array) {
        this.array = array;
        this.sum = 0;
        this.max = Integer.MIN_VALUE;
    }

    public void calculateSum() {
        for (int num : array) {
            sum += num;
        }
        System.out.println("Tổng của các phần tử trong mảng: " + sum);
    }

    public void findMax() {
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng: " + max);
    }
}
