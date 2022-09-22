import java.util.Arrays;
import java.util.Scanner;
public class Anagram {
    public static void main(String[] args){
        String str1;
        System.out.println("Enter String1: ");
        Scanner sc = new Scanner(System.in);
        str1 = sc.nextLine();
        String str2;
        System.out.println("Enter String2: ");
        str2 = sc.nextLine();
        str1 = str1.toLowerCase();       //grab
        str2 = str2.toLowerCase();        //brag

        System.out.println("str1 in lower case is: "+str1);
        System.out.println("str2 in lower case is: "+str2);

        if(str1.length()!= str2.length()){
            System.out.println("The two strings are not anagrams");
        }
        else {
            char[] string1 = str1.toCharArray();
            char[] string2 = str2.toCharArray();

            Arrays.sort(string1);   //a b g r
            Arrays.sort(string2);     //a b g r

            if(Arrays.equals(string1 , string2)== true){
                System.out.println("Both are Anagram");
            }
            else{
                System.out.println("Both are not Anagrams");
            }
        }

    }
}
