import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

/**
 * First test task from Yandex.
 * Input: file witch have first number meaning count of numbers.
 * Output: file with sum of all non-repeating numbers.
 * @author Konstantin
 */
public class main {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        BigInteger sum = new BigInteger("0");
        try (Scanner in = new Scanner(new File("input.txt"))) {
            int n = in.nextInt();
            Integer j;
            for(int i=0; i<n; i++) {
                j = Integer.parseInt(in.next());
                if (!(set.contains(j))) {
                    set.add(j);
                    sum = sum.add(new BigInteger("" + j));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
            System.exit(1);
        }
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(sum.toString());
        } catch(IOException ex) {
            System.out.println(ex.toString());
            System.exit(1);}
    }
}