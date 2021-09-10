


public class LinkedIntList {
    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static LinkedIntList insert(LinkedIntList list, int data)
    {
        Node node = new Node(data);
        node.next = null;
        if(list.head == null)
        {
            list.head = node;
        }
        else
        {
            Node last = list.head;
            while(last.next != null)
            {
                last = last.next;
            }
            last.next = node;
        }
        return list;
    }

    public static void toString(LinkedIntList list)
    {
        Node currentNode = list.head;
        System.out.print("LinkedIntList: ");
        while(currentNode != null)
        {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }
    public static int size(LinkedIntList list)
    {
        Node temp = list.head;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static boolean isEmpty(LinkedIntList list)
    {
        if(list.head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void clear(LinkedIntList list)
    {
        list.head.next = null;
        list.head = null;
    }
    public static int indexOf(LinkedIntList list, int number)
    {
        int index = -1;
        Node currentNode = list.head;
        while(currentNode != null)
        {
            index++;
            if(currentNode.data == number)
            {
                return index;
            }
            currentNode = currentNode.next;

        }
        return -1;
    }
    public static boolean contains(LinkedIntList list, int number)
    {
        boolean flag = false;
        Node currentNode = list.head;
        while(currentNode != null)
        {
            if(currentNode.data == number)
            {
                flag = true;
                break;
            }
            currentNode = currentNode.next;
        }
        return flag;
    }
    public static void main(String args[])
    {
        LinkedIntList list = new LinkedIntList();
        System.out.println("Size : "+ size(list));
        System.out.println("is empty: "+ isEmpty(list));
        list = insert(list,1);
        list = insert(list,3);
        list = insert(list,5);
        list = insert(list,4);
        list = insert(list,2);
        System.out.println("-------------------");

        System.out.println("ToString() ");
        toString(list);
        System.out.println("Size : " + size(list));
        System.out.println("is empty: " + isEmpty(list));
        System.out.println("index of 5 is: "+ indexOf(list,5));
        System.out.println("List Contains: " + contains(list,2));

        System.out.println("-------------------");
        System.out.println("Clear the list ");
        clear(list);
        System.out.println("Size : " + size(list));
        System.out.println("is empty: " + isEmpty(list));
    }
}