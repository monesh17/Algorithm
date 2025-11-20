public class Palindrome {
    public static void main(String[] args) {
        String s = "A".toLowerCase();
        String result = checkPlindrome(s)? "true": "false";
        System.out.println(result);
    }

    private static boolean checkPlindrome(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length/2;
        int endPos = arr.length-1;
        for(int i=0;i<length;i++) {
            if(arr[i] != arr[endPos-i])
                return false;
        }
        return true;
    }
}
