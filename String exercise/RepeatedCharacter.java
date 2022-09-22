public class RepeatedCharacter {
    public static void main(String[] args) {
        String str = "phanendra";
        int length = str.length();
        char[] ch = str.toCharArray();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++){
                if (ch[i] == ch[j]) {
                    System.out.println("Repeated Character is: " + ch[j]);
                    break;
                }
            }
        }
    }
}
