import java.util.*;

public class TollSearch
{
    public void SearchRankerAlternate(List<Toll> tollArray, List<Toll> tollLinkedList, Map<Long, Toll> tollMap)
    {
        String [] types= {"Array","LinkedList","Hashmap"};
        Long [] durations= {this.ArraySearchTimer(tollArray),this.LinkedListSearchTimer(tollLinkedList),this.HashSearchTimer(tollMap)};

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

    public void SearchRanker(List<Toll> tollArray, List<Toll> tollLinkedList, Map<Long, Toll> tollMap)
    {
        TreeMap<Long,String> rankTree= new TreeMap<>();
        rankTree.put(ArraySearchTimer(tollArray),"Array");
        rankTree.put(LinkedListSearchTimer(tollLinkedList),"LinkedList");
        rankTree.put(HashSearchTimer(tollMap),"HashMap");

        System.out.println();
        System.out.println("THE SEARCH TIME FOR A RANDOM ELEMENT ARE SORTED BELOW IN LOW TO HIGH (TIME IN NANOSEC.)");
        Set set=rankTree.entrySet();
        Iterator it= set.iterator();

        int i=1;
        while (it.hasNext())
        {
            Map.Entry element=(Map.Entry) it.next();
            System.out.println(""+i+". "+element.getValue()+", Time (ns): "+element.getKey());
            i++;
        }
    }

    public long ArraySearchTimer(List<Toll> tollArray)
    {
        System.out.println("## ARRAY LIST SEARCH ##");
        Random random= new Random();
        long randomKey=tollArray.get(random.nextInt(tollArray.size())).timestamp;

        long start = System.nanoTime();
        this.SearchList(tollArray,randomKey);
        long end= System.nanoTime();
        long duration= end-start;
        System.out.println("ArrayList took "+duration+ " nanoseconds to find the element");
        return duration;

    }

    public long LinkedListSearchTimer(List<Toll> tollLinkedList)
    {
        System.out.println("## LINKED LIST SEARCH ##");
        Random random= new Random();
        long randomKey=tollLinkedList.get(random.nextInt(tollLinkedList.size())).timestamp;

        long start = System.nanoTime();
        this.SearchList(tollLinkedList,randomKey);
        long end= System.nanoTime();
        long duration= end-start;
        System.out.println("LinkedList took "+duration+ " nanoseconds to find the elements");
        return duration;

    }

    public long HashSearchTimer(Map<Long, Toll> tollMap)
    {
        System.out.println("## HASHTABLE SEARCH ##");
        ArrayList<Long> keys=new ArrayList<Long> (tollMap.keySet());
        Random random= new Random();
        long randomKey=keys.get(random.nextInt(keys.size()));


        long start = System.nanoTime();
        this.SearchHashTable(tollMap, randomKey);
        long end= System.nanoTime();
        long duration= end-start;
        System.out.println("Hashtable took "+duration+ " nanoseconds to find the elements");
        return duration;



    }

    public Toll SearchHashTable(Map<Long, Toll> tollMap, long key)
    {
        if (tollMap.containsKey(key))
        {
            System.out.println("Searched Timestamp: "+key+", Associated LicensePlate: " +tollMap.get(key).licensePlate);
            return  tollMap.get(key);
        }
        else
        {
            throw new NullPointerException("Key not found in hashtable");
        }
    }

    public Toll SearchList(List<Toll> GenericList, long key)
    {
        Toll targetElement= new Toll();
        boolean found =false;

        for (Toll element:GenericList)
        {
            if (element.timestamp==key)
            {
                targetElement = element;
                System.out.println("Searched Timestamp: " + key + ", Associated LicensePlate: " + element.licensePlate);
                found=true;
                break;
            }
        }

        if (found==true)
        {
            return targetElement;
        }
        else
        {
            throw new NullPointerException("Key not found in List");
        }
    }
}
