package revision;

import java.util.HashMap;
import java.util.Scanner;

public class SuffixTree 
{
    public static HashMap<Integer,String> suffix(char[] t)
    { 
        HashMap<Integer,String> m= new HashMap<Integer,String> ();
        String s="";
        for(int i=t.length-1;i>0;i--)
        {
            s=t[i]+s;
            m.put(i,s);
        }
        return m;
    }
public static void main(String args[])
{
    Scanner in=new Scanner(System.in);
    String text=in.next();
    char[] t=text.toCharArray();
    HashMap<Integer,String> m=suffix(t);
    m.put(0, text);
    for(int i=0;i<t.length;i++)
        System.out.println(m.get(i));
}
}
