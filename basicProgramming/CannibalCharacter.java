package basicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CannibalCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();

            int out_ = Minimum_Operations(n, s);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static int Minimum_Operations(int n, String s){
        // Write your code here
        int result = 0;
        int[] frequency = new int[26];
         for(char c : s.toCharArray()){
             frequency[c-97]++;
         }
         for(int number: frequency){
             result+=(number/2);
         }
        return result;

    }
}
