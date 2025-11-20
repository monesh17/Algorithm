public class Nimber1Bits {
    public static int hammingWeight(int n) {
        int ans = 0;
        while(n>0){
            n = (n & (n-1));
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
