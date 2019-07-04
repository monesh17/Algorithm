package revision;

import java.util.Scanner;

public class WalshHadamardTransform {
	public static int max = 65536;
	
	public static void walsh(int[] data) {
		for(int len =1;2*len<=data.length;len<<=1) {
			for(int i=0;i<data.length;i+=2*len) {
				for(int j=0;j<len;j++) {
					int a = data[i+j];
					int b = data[i+j+len];
					data[i+j]=a+b;
					data[i+j+len] = a-b;
				}
			}
		}
	}
  public static void main(String[] args) {
	  Scanner in =new Scanner(System.in);
	  int[] poly = {1,2,3,4,5,6,7,8};
	  walsh(poly);
	  for(int i=0;i<poly.length;i++)
		  System.out.println(poly[i]);
  }
}
