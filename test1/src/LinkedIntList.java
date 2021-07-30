import java.util.*;

//import com.sun.xml.internal.bind.v2.model.core.ID;

//Class definition
public class LinkedList
{
    // create a Linked List class object
    LinkedList list = new LinkedList();
    //Method to return size
    int size()
    {
        //Initialize the counter to zero
        int count = 0;
        //Creates an iterator
        Iterator<String> itr = list.iterator();
        //Moves till data available
        while(itr.hasNext())
        {
            //Increase the counter by one
            count++;
            //Moves to next data
            itr.next();
        }//End of while
        //Returns the counter
        return count;
    }//End of method

    //Method to clear the list
    void createList()
    {
        //To store data entered by the user
        String data;
        //Scanner class object created to accept data from the user
        Scanner sc = new Scanner(System.in);
        //Accept data till end entered by the user
        System.out.println("Enter string data to add to the list. Enter end to stop.");
        do
        {
            //Accept data
            data = sc.next();
            //Checks for end
            if(data.equalsIgnoreCase("end"))
                //Come out of the loop
                break;
            else
                //If not end then add it to the list
                list.add(data);
        }while(true);//End of while
    }//End of method

    //Method to return true if list is empty
    boolean isEmpty()
    {
        //Initialize the counter to zero
        int count = 0;
        //Calls the size method and store the size in counter
        count = size();
        //Checks if the count is zero then return true
        if(count == 0)
            return true;
            //Otherwise return false
        else
            return false;
    }//End of method

    //Method to clear all the data in the list
    void clear()
    {
        //Calls the size method and store the size in c
        int c = size();
        //Loops till c
        for(int i = 0; i < c; i++)
        {
            //removes the first element till condition becomes false
            list.removeFirst();
        }//End of for
    }//End of method

    //Overrides the toString method
    public String toString()
    {
        //Initializes the result string to null
        String result = "";
        //Creates an iterator class object
        Iterator<String> itr = list.iterator();
        //Moves till data available
        while(itr.hasNext())
        {
            //Concatenates the data available in the list with the result
            result += itr.next() + ", ";
        }//End of while
        //Return the result
        return result;
    }//End of method

    //Returns the index position of the string given as parameter
    int indexOf(String str)
    {
        //Initially ind is -1
        int ind = -1;
        //To store current string of the list
        String current;
        //Initializes the flag to -1 and counter to zero
        int flag = -1, counter = 0;
        //Creates an iterator class object
        Iterator<String> itr = list.iterator();
        //Moves till data available
        while(itr.hasNext())
        {
            //Stores the current data from the list
            current = itr.next();
            //Increase the counter by one
            counter++;
            //Checks if the current item is equal to the string given as parameter (without considering the case)
            if(current.equalsIgnoreCase(str))
            {
                //Set the flag value to the counter value
                flag = counter;
                //Come out of the loop
                break;
            }//End of if
        }//End of while
        //Returns the flag value
        return flag;
    }//End of method

    //Return true if string is available otherwise false
    boolean contains(String str)
    {
        //To store current string
        String current;
        //Initializes the flag to -1
        int flag = -1;
        //Creates an iterator class object
        Iterator<String> itr = list.iterator();
        //Moves till data available
        while(itr.hasNext())
        {
            //Stores the current data from the list
            current = itr.next();
            //Checks if the current item is equal to the string given as parameter (without considering the case)
            if(current.equalsIgnoreCase(str))
            {
                //Sets the flag to zero
                flag = 0;
                //Come out of the loop
                break;
            }//End of if
        }//End of while
        //Checks if the flag value is -1 return false
        if(flag == -1)
            return false;
            //Otherwise return true
        else
            return true;
    }//End of method

    //Driver method
    public static void main(String args[])
    {
        //To store string entered by the user
        String data;
        //Scanner class object created to accept data
        Scanner sc = new Scanner(System.in);
        //Creates LinkedListDemo class object
        LinkedListDemo ld = new LinkedListDemo();
        //Calls the method to add string to the list
        ld.createList();
        //Display the list using toString()
        System.out.println("List contents: " + ld);
        //Displays the size of the list
        System.out.println("Size: " + ld.size());
        //Displays the empty status
        System.out.println("Empty Status: " + ld.isEmpty());

        //Accepts a string to check the availability
        System.out.println("Enter a string to check exist or not: ");
        data = sc.next();
        //If returns true display available
        if(ld.contains(data))
            System.out.println(data + " is available");
            //Otherwise display not available
        else
            System.out.println(data + " is not available");
        //Accepts a string to display the index position
        System.out.println("Enter a string to find index position: ");
        data = sc.next();
        //Calls the method and stores the index position
        int position =ld.indexOf(data);
        //If the position is -1 display not available
        if(position == -1)
            System.out.println(data + " is not available");
            //Otherwise display its index position
        else
            System.out.println(data + " is available at " + position);
        //Clear the contents of the list
        ld.clear();
        //Display the size after clear
        System.out.println("After clear Size: " + ld.size());
    }//End of main
}//End of class