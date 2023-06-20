package basicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UpdateArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            int K = Integer.parseInt(br.readLine().trim());

            int out_ = minUpdates(N, A, K);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    static int minUpdates(int N, int[] A, int K){
        int result = 0;
        if(N%2 != 0){
            return -1;
        }
        int availableEven = K/2;
        int availableOdd = (K/2) + (K%2);
        Map<Integer,Integer> presence = new HashMap<>();
        int even = 0, odd = 0;

        for(int number : A) {
            if(!presence.containsKey(number)){
                if(number%2 == 0){
                  even++;
                  if(number<=K){
                      availableEven--;
                  }
                }
                else{
                    odd++;
                    if(number<=K){
                        availableOdd--;
                    }
                }
                presence.put(number,1);
            }
        }

        int mid = N/2;
        if(odd<mid){
            if((mid-odd)<=availableOdd){
                result += (mid-odd);
            }
            else{
                return -1;
            }
        }
        if(even<mid){
            if((mid-even)<=availableEven){
                result += (mid-even);
            }
            else{
                return -1;
            }
        }

        return result;

    }
}
