import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

static PriorityQueue<Integer> max = new PriorityQueue<Integer>();
static PriorityQueue<Integer> min = new PriorityQueue<Integer>(30,
             new Comparator<Integer>(){
                 public int compare(Integer a, Integer b){
                     return -1*a.compareTo(b);
                     
                 }
             }
             
         );

static void adding(int num)
{
    if(min.size()<=max.size())
    {
        min.add(num);
    }
    else
    max.add(num);
    balance();
    median();
}
static void balance() {
        while(!min.isEmpty() && !max.isEmpty() && min.peek() > max.peek()) {
            Integer minPeek= min.poll();
            Integer maxPeek = max.poll();
            min.add(maxPeek);
            max.add(minPeek);
        }
    }
static void median(){
    double median=(min.size()==max.size()) ?(double)(min.peek()+max.peek())/2:min.peek();
    System.out.println(median);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            adding(aItem);
        }
        
        scanner.close();
    }
}

