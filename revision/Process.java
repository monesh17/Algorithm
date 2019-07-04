package revision;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
public class Process 
{
     public static Scanner in=new Scanner(System.in);
    public static void check(boolean[][] b)
    {
        int q=in.nextInt();
        while(q-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            if(b[var1][var2])
            System.out.println("YES");
            else
            System.out.println("NO");
            
        }
    }
    public static void input()
    {
        int n=in.nextInt();
        int m=in.nextInt();
        boolean[][] b=new boolean[n][n];
        while(m-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            b[var1][var2]=true;
            b[var2][var1]=true;
        }
        check(b);
    }
public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
{
        // File inputFile = new File("link.txt");
//         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//         Document doc = dBuilder.parse("link.xml");
//         doc.getDocumentElement().normalize();
//         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//         NodeList n=doc.getElementsByTagName("link");
//         System.out.println(n.getLength());
//         Node c=n.item(0);
//         String s=c.getTextContent();
//         BufferedReader buf=new BufferedReader(new InputStreamReader(new FileInputStream(s)));
//         while(buf.read()!=-1)
//         {
//             String re=buf.readLine();
//             System.out.println(re);
//         }
         input();
}
}
