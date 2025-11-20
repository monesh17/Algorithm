public class MaximumPlaindrome {
    public static void main(String[] args) {
        String s = "abbcccddeee";
        int[] frequency = new int[26];

        for(char c: s.toCharArray()){
            frequency[c-'a']++;
        }
        int result=0;
        boolean odd=false;
        for(int i: frequency){
            if(i%2==0){
                result+=i;
            }else {
                if(i>1){
                    result+=(i-1);
                }
                odd = true;
            }
        }
        System.out.println(result+(odd?1:0));
    }
}
