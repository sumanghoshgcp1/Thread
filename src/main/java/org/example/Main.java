package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //\

        MyInventory myInventory = new MyInventory();

        IncrementingThread incrementingThread = new IncrementingThread(myInventory);

        DecrementingThread decrementingThread = new DecrementingThread(myInventory);

        incrementingThread.start();



        decrementingThread.start();
        incrementingThread.join();
        decrementingThread.join();

        System.out.println(myInventory.getItemcount());







    }


    /*

        this is my decrementing thread
     */
    private static class DecrementingThread extends Thread
    {
        private MyInventory myInventory;

        public DecrementingThread(MyInventory myInventory)
        {
            this.myInventory=myInventory;

        }

        @Override
        public void run()
        {
            for(int i=0;i<1000;i++)
            {
                myInventory.decrementCount();
            }

        }
    }


    /*
    this is my incrementing thread

     */


    private static class IncrementingThread extends Thread
    {
        private MyInventory myInventory;

        public IncrementingThread(MyInventory myInventory)
        {
            this.myInventory=myInventory;

        }

        @Override
        public void run()
        {
            for(int i=0;i<1000;i++)
            {
                myInventory.incrementCount();
            }

        }
    }


    /*
    this is my inventory class which stores the count variable
     */

    private static class  MyInventory
    {
         private  int itemcount=0;

         public void incrementCount()
         {
             itemcount++;

         }


         public void decrementCount()
         {
             itemcount--;

         }

        public int getItemcount() {
            return itemcount;
        }
    }
}