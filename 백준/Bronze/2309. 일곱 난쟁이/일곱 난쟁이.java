import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            l.add(scanner.nextInt());
        }

        List<Integer> result = null;

        for (List<Integer> combination : combinations(l, 7)) {
            int sum = 0;
            for (int num : combination) {
                sum += num;
            }
            if (sum == 100) {
                result = combination;
                break;
            }
        }


        if (result != null) {
            Collections.sort(result);

            for (int num : result) {
                System.out.println(num);
            }
        }
    }

    public static List<List<Integer>> combinations(List<Integer> list, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationsHelper(list, new ArrayList<>(), n, 0, result);
        return result;
    }

    private static void combinationsHelper(List<Integer> list, List<Integer> temp, int n, int start, List<List<Integer>> result) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            temp.add(list.get(i));
            combinationsHelper(list, temp, n, i + 1, result);
            temp.remove(temp.size() - 1);
        }
    }
}