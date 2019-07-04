package revision;

import java.io.*;

public class Solution {
	
	private static int[] createSA(String input, int letters, int maxsize){
		
	int[] first = new int[maxsize];
	int[] second = new int[maxsize];
	int[] third = new int[maxsize];
	int[] count = new int[maxsize];
	int[] suffarr = new int[maxsize];
		
	int size = input.length();
	char[] arr = input.toCharArray();
	for (int i = 0; i < size; i++) count[arr[i]]++;
        for (int j = 1; j < letters; j++) count[j] += count[j-1];
        for (int k = 0; k < size; k++) first[--count[arr[k]]] = k;
        int sum = 1;
        suffarr[first[0]] = 0;
        for (int i = 1; i < size; i++) {
            if (arr[first[i]] != arr[first[i-1]]) sum++;
            suffarr[first[i]] = sum - 1;
        }
        for (int m = 0; (1<<m) < size; m++) 
        {
            System.out.println("m is"+m);
            for (int i = 0; i < size; i++)
            {
                                System.out.println("1<< m is"+(1<<m));
                System.out.println("i is"+i);
                second[i] = first[i] - (1<<m);
                System.out.println("second of i is"+second[i]);
                if (second[i] < 0)
                {
                 second[i] += size;
                                System.out.println(" after plus size second of i is"+second[i]);
                }
            }
            System.out.println("value of first and second array is");
            for(int j=0;j<size;j++)
                System.out.println("j is"+"  "+j+"first is"+"  "+first[j]+"second is"+"  "+second[j]);
            count = new int[maxsize];
            for (int i = 0; i < size; i++)
            {
                System.out.println("sufarr[i] is"+" "+i+"  "+suffarr[i]);
                count[suffarr[i]]++;
                System.out.println("count is"+count[suffarr[i]]);
                  
            }
            for (int j = 1; j < sum; j++)
            {
                count[j] += count[j-1];
                System.out.println("count[j] is"+"  "+j+"   "+count[j]);
            }
            for (int k = size-1; k >= 0; k--) 
            {
                System.out.println("came to k loop k is"+"   "+k);
                System.out.println("second[k] is"+"   "+second[k]);
                System.out.println("suffarr[second[k]] is"+"   "+suffarr[second[k]]);
                System.out.println("count[suffarr[second]] is"+"   "+count[suffarr[second[k]]]);
                int var=--count[suffarr[second[k]]];
                first[var] = second[k];
                System.out.println("first[var] is var is"+"  "+var+"  "+first[var]);
            }
             for(int j=0;j<size;j++)
                System.out.println("j is"+"  "+j+"first is"+"  "+first[j]+"second is"+"  "+second[j]);
            count = new int[maxsize];
            for (int i = 0; i < size; i++)
            sum = 1;
            third[first[0]] = 0;
            for (int i = 1; i < size; i++)
            {
                System.out.println("final loop i is"+"   "+i);
                int pos1 = (first[i] + (1<<m))%size;
                                System.out.println("final loop pos1 is"+"   "+pos1);
                int pos2 = (first[i-1] + (1<<m))%size;
                                System.out.println("final loop pos2 is"+"   "+pos2);
                if (suffarr[first[i]] != suffarr[first[i-1]] || suffarr[pos1] != suffarr[pos2]) 
                {
                   System.out.println("final loop inside if suff[first[i]] is"+"   "+suffarr[first[i]]);
                   System.out.println("final loop inside if suff[first[i-1]] is"+"   "+suffarr[first[i-1]]);
                   System.out.println("final loop inside if suff[pos1] is"+"   "+suffarr[pos1]);
                   System.out.println("final loop inside if suff[pos2] is"+"   "+suffarr[pos2]);
                    sum++;
                    System.out.println("final loop inside if sum is"+"   "+sum);
                }
                third[first[i]] = sum - 1;
                System.out.println("final loop inside if third[first[i]] and first[i] is"+"   "+first[i]+"   "+third[first[i]]);
            }
            for (int i = 0; i < size; i++)
            {
                suffarr[i] = third[i];
                System.out.println("assignment is suffarr"+"   "+suffarr[i]);
                
            }
        }
		return suffarr;
	}
	
	private static void compute(String first, String second){
		
		StringBuilder result = new StringBuilder();
		String process = first.concat("y").concat(second).concat("z");
		int[] suffarr = createSA(process,128,200005);
		int indexf = 0;
		int fsize = first.length();
		int psize = process.length();
		int indexs = fsize+1;
		
		for(int i = 0; i < process.length(); i++){
			if(indexs > psize-1 && indexf > fsize-1) break;
			if(indexs > psize-1){
				result.append(process.substring(indexf, fsize-1));
				break;
			}
			if(indexf > fsize-1){
				result.append(process.substring(indexs, psize-1));
				break;
			}
			if(suffarr[indexf] < suffarr[indexs]){
				result.append(process.charAt(indexf));
				indexf++;
			}
			else{
				result.append(process.charAt(indexs));
				indexs++;
			}
		}
		
		System.out.println(result.toString());
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String first;
		String second;
		int T;
		
		line = br.readLine();
		T = Integer.parseInt(line);
		for(int i = 0; i < T; i++){
		  first = br.readLine();
		  second = br.readLine();
		  compute(first,second); 
		}
	}
}