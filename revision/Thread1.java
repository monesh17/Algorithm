
package revision;

import java.io.IOException;

public class Thread1 extends Thread
{
//    public void run()
//    {
//        System.out.println("came2");
//        for(int i=1;i<5;i++)
//        {
//            try{
//                Thread.sleep(500);
//            }catch(InterruptedException e)
//            {
//               System.out.println(e.getMessage()); 
//        }
//            System.out.println(i);
//    }
//    }
    public static void main(String args[]) throws InterruptedException, IOException
    {
//       Thread1 t1=new Thread1();
//       Thread1 t2=new Thread1();
//       t1.start();
//       t2.start();
//       Thread.sleep(500);
//       System.out.println("came");
//       t1.run();
//       t2.run();
//        for(int i=0;i<=16;i++)
//        {
//            System.out.println("i is"+i);
//            System.out.println(1<<i);
//        }
        Runtime rt = Runtime.getRuntime();
             rt.exec("cmd.exe /c  wordpad.exe");

    }

   
}
