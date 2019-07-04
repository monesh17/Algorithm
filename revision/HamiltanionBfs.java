/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author monesh
 */
public class HamiltanionBfs {
    public static boolean dfs(boolean[][] adj,int start,int n,int nodecount,boolean[] present){
        if(nodecount==n){
            System.out.println("size is"+" "+nodecount);
            return true;
        }
        for(int i=0;i<n;i++){
            if(adj[start][i]&&!present[i]){
                System.out.println("i is"+" "+i);
                present[i]=true;
                if(dfs(adj,i,n,nodecount+1,present)){
                    System.out.println("start is"+" "+start);
                    return true;
                }
                present[i]=false;
            }
        }
       return false;
    }
    public static boolean check(boolean[][] adj,int n){
       boolean[] present =new boolean[n];
       int nodecount=0;
        for(int i=0;i<n;i++){
            present[i]=true;
        if(dfs(adj,i,n,nodecount+1,present)){
            System.out.println("value is"+"  "+i);
            return true;
        }
        present[i]=false;
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
        if(check(adj,n))
            System.out.println("YES");
        else
            System.out.println("NO");
        
    }

     public static void main(String[] args){
        input();
    }
    
}
