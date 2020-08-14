package com.design.analysis.ds.two.hashing.key3.node;

/*this node is used for double hashing mechanism*/
/*K1 and K2 will be the value of keys and V is the value need to store in tree like structure*/

/*public class T2HashNode<K1, K2, V> {
	public T2HashNode<K1, K2, V> next;
}


//Write your code here
boolean isPran[] = new boolean[26];

for(int i=0;i<strings.length();i++)
{
    String str=strings.get(i);
    String strArr[]=str.split(" ");
    for(int j=0;j<strArr.length;j++)
    {
        char charArr=str[j].toCharArray();
    
        for(int k=0;k<charArr.length;k++)
        {
         isPran[charArr[k]-48]=true;
        }
     
    }
 }
 
 for(int i=0;i<isPran.length;i++)
 {
     if(!isPran[i])
     return "0";
 }
return "1";

=================
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    
     * Complete the 'minCost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     

    
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     
    class LNode{
      public int wt;
      public int dest;
      public LNode  next;
      
      public LNode(int dest,int wt){
          this.dest=dest;
          this.next=null;
      }
     }
     class GNode
     {
        public LNode[] head;
        public LNode[] createGraph(int size)
        {
            head = new LNode[size];
            return  head;
        }
     }

//construct graph form given value



public static int minCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
 
 Set<Integer> size=new HashSet<>(gFrom);
 GNode g = createGraph(gFrom,gTo,gWeight);
 boolean visited[]=new boolean[size];
 visited[gNode-1]=true;
 int path[]=new path[20]; //just assume max path length is 20 //better to use ArrayList
return traverse(g, path, 0, gNodes-1, size-1, Integer.MAX_VAL,visited);
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            gFrom.add(Integer.parseInt(gFromToWeight[0]));
            gTo.add(Integer.parseInt(gFromToWeight[1]));
            gWeight.add(Integer.parseInt(gFromToWeight[2]));
        }

        int result = Result.minCost(gNodes, gFrom, gTo, gWeight);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


===============================
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    
     * Complete the 'isPangram' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY strings as parameter.
     

    public static String isPangram(List<String> strings) {
    // Write your code here
                boolean isPran[] = new boolean[26];
                
                for(int i=0;i<strings.length();i++)
                {
                    String str=strings.get(i);
                    String strArr[]=str.split(" ");
                    for(int j=0;j<strArr.length;j++)
                    {
                        char charArr=str[j].toCharArray();
                    
                        for(int k=0;k<charArr.length;k++)
                        {
                         isPran[charArr[k]-48]=true;
                        }
                     
                    }
                 }
                 
                 for(int i=0;i<isPran.length;i++)
                 {
                     if(!isPran[i])
                     return "0";
                 }
   return "1";
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String result = Result.isPangram(strings);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/