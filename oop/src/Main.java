import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = scanner.nextLine();
        str = str.trim();
        boolean flag = false;
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                flag = false;
                break;
            }
            start++;
            end--;
            flag = true;
        }
        StringBuilder string = new StringBuilder(str);
        if (str.equals(string.reverse().toString())) {
            System.out.println("String is palindrome");
        }
        if (flag) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}