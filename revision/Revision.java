
package revision;

import java.util.Iterator;
import java.util.TreeSet;

class Book implements Comparable<Book>
{
    int id;
    String name;
    Book(String a,int id)
    {
        this.name=a;
        this.id=id;
    }
    public int compareTo(Book o) 
    {
        if(id>o.id)
            return 1;
        else if(id<o.id)
            return -1;
        else
            return 0;
    }
}
public class Revision {
    public static void main(String[] args) 
   {
//      TreeSet<Book> t=new TreeSet<Book>(); 
//      Book b1=new Book("monesh",2);
//      Book b2=new Book("ashin",1);
//      t.add(b1);
//      t.add(b2);
//      Iterator itr=t.iterator();
//      while(itr.hasNext())
//      {
//          Book b=(Book)itr.next();
//          System.out.println(b.name+"  "+b.id);
//      }
       int[][] a=new int[6][7];
       System.out.println(a.length);
    }
    
}
