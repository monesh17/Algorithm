package revision;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Filecheck
{
public static void main(String args[]) throws FileNotFoundException, IOException
{
    DataOutputStream fil=new DataOutputStream(new FileOutputStream("check.txt"));
    //System.out.println(fil.getChannel());
    fil.writeInt(65);
    fil.close();
    
}
}
