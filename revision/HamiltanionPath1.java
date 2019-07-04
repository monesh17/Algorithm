package revision;

import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class HamiltanionPath1 {
    public static boolean hamiltanion(boolean[][] adj,int n){
        boolean[][] dp=new boolean[n][1<<n];
        for(int i=0;i<n;i++)
            dp[i][1<<i]=true;
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    System.out.println("came here");
                    for(int k=0;k<n;k++){
                        System.out.println("operation" +" "+i+"  "+ "k is "+" "+k+" "+"anser"+" "+(i&(1<<k)));
                        if((i&(1<<k))!=0){ 
                            System.out.println("came here2");
                            System.out.println("k is"+" "+k);
                            System.out.println("j is" +" "+ j);
                            System.out.println("i is "+" "+ i);
                            if(adj[k][j]&&j!=k&&dp[k][i^(1<<j)]){
                                System.out.println("j is" +" "+ j);
                                System.out.println("i is "+" "+ i);
                                dp[j][i]=true;
                                break;
                            }
                    }
                    
                }
            }
        }
    }
     for(int i=0;i<n;i++){
         if(dp[i][(1<<n)-1])
             return true;
     }
     return false;
    }
    public static void input(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        boolean[][] adj=new boolean[n][n];
        while(m-->0){
            int var1=in.nextInt();
            int var2=in.nextInt();
            adj[var1][var2]=true;
            adj[var2][var1]=true;
        }
        if(hamiltanion(adj,n))
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }
    public static void main(String[] args){
        input();
    }
    
}
