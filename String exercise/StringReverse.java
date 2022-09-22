import java.util.Scanner;
public class StringReverse {
    public static void main(String[] args) {
        String name;
        char ch;
        String reverse = " ";
        System.out.println("Enter the String: ");
        Scanner input = new Scanner(System.in);
        name = input.next();
        System.out.println("The String that you have Entered is: "+name);
        for(int i= name.length()-1 ;i>=0;i--){
                ch = name.charAt(i);
                reverse = reverse + ch;
        }
        System.out.println("The String after reverse is: "+reverse);
    }
}
