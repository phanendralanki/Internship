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









// Another method without sorting
/*
import java.util.Scanner;
public class Trying {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str1;
        System.out.println("Enter String1: ");
        str1 = input.nextLine();
        String str2;
        System.out.println("Enter String2: ");
        str2 = input.nextLine();
//        Changing two Strings to lower Case
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        System.out.println("The String after changing to lower case is: "+str1);
        System.out.println("The String after changing to lower case is: "+str2);

        if(str1.length() != str2.length()){
            System.out.println("These two strings are not anagrams");
        }

        else {
            int len = str1.length();
            char[] string1 = str1.toCharArray();
            char[] string2 = str2.toCharArray();
            for(int i=0;i<len;i++){
                for(int j=i+1;j<len;j++){
                    if(string1[i] == string2[j]){
                        System.out.println("the string are anagrams");
                    }
                }
            }
        }
    }
}
*/
