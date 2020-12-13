import java.util.Scanner;

public class e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();

        int qian = in / 1000;
        int bai = in % 1000 / 100;
        int shi = in % 100 / 10;
        int ge = in % 10;
        if ((qian * qian * qian * qian) + (bai * bai * bai * bai) + (shi * shi * shi * shi) + (ge * ge * ge * ge) == in) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }

}
