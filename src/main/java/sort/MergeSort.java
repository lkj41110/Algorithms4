package sort;

/**
 * 归并排序
 *
 * @author luokai
 * @description:
 * @date: 2019-12-01
 * @version: 1.0
 */
public class MergeSort extends AbstractSort {

    public static void main(String[] args) {
        int a[]={1,2,4,3};
        int res;
        if(a.length==0){
            res=-1;
        }

        int temp[]=new int[a.length];
        int tempIndex=0;
        for(int i=a.length-1;i>=0;i--){
            if(i==a.length-1){
                temp[0]=a[i];
            }else{
                if(a[i]<temp[tempIndex-1]){
                    int nextIndex = sort(temp,0,tempIndex,a[i]);
                    int temp1 = temp[nextIndex];
                    temp[nextIndex] = a[i];
                    a[i]=temp1;
                    //替换后面的数字
                    for(int j=i+1;j<a.length;j++){
                        a[j]=temp[nextIndex++];
                    }
                    break;
                }else{
                    temp[tempIndex]=a[i];
                }
            }
            tempIndex++;
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    private static int sort(int []a,int s, int end,int temp){
        for(int i=s;i<end;i++){
            if(a[i]>temp){
                return i;
            }
        }
        return -1;
    }


}
