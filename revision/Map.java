package revision;

import java.util.*;
class Trie
{
   HashMap<Character,Trie> children;
   boolean end;
    public Trie()
    {
         this.children=new HashMap<>();
         this.end=false;
    }
}

public class Map 
{
    public static void insert(String a,Trie t)
    {
        for(int i=0;i<a.length();i++)
        {
            if(!t.children.containsKey(a.charAt(i)))
            {
                t.children.put(a.charAt(i),new Trie());
            }
            t=t.children.get(a.charAt(i));
        }
        t.end=true;
    }
    public static void search(String w,Trie t)
    {
        boolean ans=true;
        for(int i=0;i<w.length();i++)
        {
            if(!t.children.containsKey(w.charAt(i)))
                {
                    ans=false;
                    break;
              }
            t=t.children.get(w.charAt(i));
        }
        if(ans)
            System.out.println("is present");
            else
            System.out.println("not present");
    }
    public static boolean delete(String w,Trie t,int index)
    {
        if(index==w.length())
        {
                t.end=false;
                return t.children.size()==0;
        }
        t=t.children.get(w.charAt(index));
        boolean should=delete(w,t,++index);
        if(should)
        {
        t.children.remove(w.charAt(index));
        if(t.children.size()==0)
        {
            return true;
        }
    }
        return false;
    }
public static void main(String args[])
{
    Scanner in=new Scanner(System.in);
    ArrayList<String> a=new ArrayList<>();
    int len=in.nextInt();
    for(int i=0;i<len;i++ )
    {
        a.add(in.next());
    }
    Trie root=new Trie();
    for(int i=0;i<len;i++)
    {
        insert(a.get(i),root);
    }
    for(int i=0;i<len;i++)
    {
        String word=in.next();
        search(word,root);
    }
    System.out.println("enter the word to delete");
    String w=in.next();
    delete(w,root,0);
}
}
