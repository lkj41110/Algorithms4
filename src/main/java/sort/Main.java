package sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(a);
        int b[] = new int[a];
        for(int i=0;i<a;i++){
            int temp = in.nextInt();
            b[i] = temp;
        }
        for(int i=0;i<a;i++){
            System.out.print(" "+b[i]);
        }
        System.out.println();
        qsort(b,0,b.length-1);
        for(int i=0;i<a;i++){
            System.out.print(" "+b[i]);
        }
    }
    
    private static void qsort(int a[],int s,int e){
        if(s>=e){
            return ;
        }
        int partIndex = getPartIndex(a,s,e);
        qsort(a,s,partIndex-1);
        qsort(a,partIndex+1,e);
    }
    
    private static int getPartIndex(int a[],int s,int e){
        int temp = a[s];
        int i=s;
        int j=e+1;
        while(true){
            while(a[++i]<temp){
                if(i==e) break;
            }
            while(a[--j]>temp){
                if(j==s) break;
            }
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,s,j);
        return j;
    }
    
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    
    
}