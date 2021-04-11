import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TollDelete
{
    public void DeleteRanker(List<Toll> tollArray, List<Toll> tollLinkedList, Map<Long, Toll> tollMap)
    {
        String [] types= {"Array","LinkedList","Hashmap"};
        Long [] durations= {this.ArrayListDeleteTimer(tollArray),this.LinkedListDeleteTimer(tollLinkedList),this.HashMapDeleteTimer(tollMap)};

        for (int i=0; i<durations.length-1;i++)
        {
            for (int j = 1; j < durations.length; j++)
            {
                if (durations[j]<durations[i])
                {
                    long temp=durations[i];
                    String hold=types[i];
                    durations[i]=durations[j];
                    durations[j]=temp;
                    types[i]=types[j];
                    types[j]=hold;

                }
            }
        }

        System.out.println();
        System.out.println("THE DELETION TIME FOR A RANDOM ELEMENT ARE SORTED BELOW IN LOW TO HIGH (TIME IN NANOSEC.)");
        for (int i=0; i<types.length;i++)
        {
            System.out.println(""+(i+1)+"."+types[i]+", "+"Time(ns): "+durations[i]);
        }
    }


    public long ArrayListDeleteTimer(List<Toll> tollArray)
    {
        System.out.println("## ARRAY LIST DELETION ##");
        Random random= new Random();
        long randomKey=tollArray.get(random.nextInt(tollArray.size())).timestamp;

        long start = System.nanoTime();
        this.DeleteList(tollArray,randomKey);
        long end= System.nanoTime();
        long duration= end-start;
        System.out.println("ArrayList took "+duration+ " nanoseconds to delete a randomly chosen element");
        return duration;
    }

    public long LinkedListDeleteTimer(List<Toll> tollLinkedList)
    {
        System.out.println("## LINKED LIST DELETION ##");
        Random random= new Random();
        long randomKey=tollLinkedList.get(random.nextInt(tollLinkedList.size())).timestamp;

        long start = System.nanoTime();
        this.DeleteList(tollLinkedList,randomKey);
        long end= System.nanoTime();
        long duration= end-start;
        System.out.println("LinkedList took "+duration+ " nanoseconds to delete a randomly chosen element");
        return duration;
    }

    public long HashMapDeleteTimer(Map<Long, Toll> tollMap)
    {
        System.out.println("## HASHTABLE KEY DELETION ##");
        ArrayList<Long> keys=new ArrayList<Long> (tollMap.keySet());
        Random random= new Random();
        long randomKey=keys.get(random.nextInt(keys.size()));

        long start = System.nanoTime();
        this.DeleteHashTable(tollMap, randomKey);
        long end= System.nanoTime();
        long duration= end-start;
        System.out.println("Hashtable took "+duration+ " nanoseconds to delete a randomly chosen element");
        return duration;
    }

    public Map<Long, Toll> DeleteHashTable(Map<Long, Toll> tollMap, long key)
    {
        if (tollMap.containsKey(key))
        {
            tollMap.remove(key);
            return  tollMap;
        }
        else
        {
            throw new NullPointerException("Key not found in hashtable");
        }
    }


    public List<Toll> DeleteList(List<Toll> GenericList, long key)
    {
        boolean found =false;

        for (Toll element:GenericList)
        {
            if (element.timestamp == key)
            {
                GenericList.remove(element);
                found = true;
                break;
            }
        }

        if (found)
        {
            return GenericList;
        }
        else
        {
            throw new NullPointerException("Key not found in List");
        }

    }


}
