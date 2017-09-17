package sort;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Sort{
    public static void main(String []args){
        int []a = {3,56,12,5,89,96,12,14};

        //插入排序
        //insertSort(a);

        //折半插入排序
        //bInsertSort(a);

        //希尔排序
        //shellSort(a);

        //选择排序
       // selectSort(a);

        //堆排序
       // heapSort(a);

        //快速排序
        quick(a);

        //归并排序
       // mergeSort(a,0,a.length-1);

        //基数排序
       // radixSort(a);

        //冒泡排序
       // bubbleSort(a);
        System.out.println("已完成排序，如下：");
        printArray(a);
    }

    /**
     * 冒泡排序
     * 检查逆序对
     * @param a
     */
    public static void bubbleSort(int []a){
        int len = a.length;
        while(!bubble(a,0,len--));
    }

    private static boolean bubble(int[] a, int low, int high) {
        boolean sorted = true;
        while(++low < high){
            if(a[low-1] > a[low]){
                sorted = false;
                //交换
                swap(a,low,low-1);
            }
        }
        return sorted;
    }

    /**
     * 打印数组
     * @param a
     */
    public static void printArray(int[]a){
        for(int i = 0,len = a.length;i<len;i++){
            System.out.print(a[i]+",");
        }
        System.out.println();
    }

    /**
     * 交换数组中的两个数
     **/
    public static void swap(int []data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //插入排序
    public static void insertSort(int [] a){
        int len = a.length;
        int j ;
        for(int i = 1;i<len;i++){
            int temp = a[i];
            for(j=i;j>0&&temp<a[j-1];j--){
                a[j] = a[j-1];
            }
            a[j]=temp;
        }
    }

    /**
     * 二分插入排序
     * @param a
     */
    public static void bInsertSort(int []a){
        for(int i=1,len=a.length;i<len;i++){
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left <= right){
                mid = (left+right)/2;
                if(temp<a[mid]){
                    right = mid-1;
                }else{
                    left = mid + 1;
                }
            }
            for(int j = i-1;j>=left;j--){
                a[j+1] = a[j];
            }
            if(left != i){
                a[left] = temp;
            }
            System.out.println("----------"+i+"--------");
            printArray(a);
        }
    }

    /**
     * 希尔排序
     * @param a
     */
    public static void shellSort(int []a){
        int len = a.length;

        int j;
        for(int gap = len/2;gap>0;gap /= 2){
            for(int i = gap;i<len;i++){
                int temp = a[i];
                for(j = i;j>= gap&&temp<a[j-gap];j -= gap){
                    a[j] = a[j-gap];
                }
                a[j] = temp;
            }
            System.out.println("-----"+gap+"-----");
            printArray(a);
        }
    }

    /**
     * 选择排序
     * @param a
     */
    public static void selectSort(int []a){
        int len = a.length;

        for(int i = 0;i < len;i++){
            int min = a[i];
            int index = i;

            for(int j = i+1;j<len;j++){
                if(a[j] < min){
                    min = a[j];
                    index = j;
                }
            }
            a[index] = a[i];
            a[i] = min;
        }
    }

    /**
     * 堆排序
     * @param a
     */
    public static void heapSort(int []a){
        int len = a.length;

        for(int i = len/2-1;i>=0;i--){
            //新建堆
            percDowmn(a,i,len);

            System.out.println("建堆-------"+i+" to "+len+"-------");
            printArray(a);
        }
        for(int i = len-1;i>0;i--){
            //删除堆
            swap(a,0,i);
            percDowmn(a,0,i);

            System.out.println("删除堆-------"+0+" to "+i+"-------");
            printArray(a);
        }

    }

    /**
     * 建堆与删堆
     * @param a
     * @param i
     * @param n
     */
    public static void percDowmn(int []a,int i,int n){
        int child;
        int temp;
        for(temp = a[i];leftChild(i)<n;i=child){
            child = leftChild(i);
            if(child != n-1&&a[child]<a[child+1]){
                child++;
            }
            if(temp < a[child]){
                a[i] = a[child];
            }else{
                break;
            }
        }
        a[i] = temp;
    }

    /**
     * 堆排序的函数
     * @param i
     * @return
     */
    public static int leftChild(int i){
        return 2*i+1;
    }

    public static void quick(int []a){
        quickSort(a,0,a.length-1);
    }
    public static void quickSort(int []a,int low,int high){
        if(low<high) {
            int mid = getMiddle(a,low,high);
            quickSort(a,0,mid-1);
            quickSort(a,mid+1,high);
        }
    }

    public static int getMiddle(int[]a,int low,int high){
        //基准元素
        int temp = a[low];

        while(low<high){
            //找到比基准元素小的元素位置
            while(low<high && a[high] >= temp){
                high--;
            }
            a[low] = a[high];
            while(low<high && a[low] <= temp){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    /**
     * 归并排序
     * @param a
     * @param left
     * @param right
     */
    public static void mergeSort(int []a,int left,int right){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int []temoArr = new int[a.length];
        //右边的起始位置
        int mid = middle+1;
        int temp = left;
        int third = left;

        while(left <= middle && mid < right){
            //从两个数组中选取较小的数放入中间数组
            if(a[left] <= a[mid]){
                temoArr[third++] = a[left++];
            }else{
                temoArr[third++] = a[mid++];
            }
        }
        //将剩余部分放入中间数组
        while(left <= middle){
            temoArr[third++] = a[left++];
        }
        while(mid <= right){
            temoArr[third++] = a[mid++];
        }
        //将中间数组复制回原数组
        while(temp <= right){
            a[temp] = temoArr[temp++];
        }
    }

    public static void radixSort(int []a){
        int len = a.length;
        //找到最大数，确定要排序几趟
        int max = 0;
        for(int i = 0;i<len;i++){
            if(max < a[i]){
                max = a[i];
            }
        }

        //判断位数
        int times = 0;
        while(max > 0){
            max = max/10;
            times++;
        }

        //建立十个队列
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for(int i = 0;i<10;i++){
            ArrayList queue1 = new ArrayList();
            queue.add(queue1);
        }
        //进行time次分配和收集
        for(int i = 0;i < times;i++){
            //分配
            for(int j = 0;j < len;j++){
                int x = a[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10,i);
                ArrayList queue2 = queue.get(x);
                queue2.add(a[j]);
                queue.set(x,queue2);
            }
            //收集
            int count = 0;
            for(int j = 0;j < 10;j++){
                while(queue.get(j).size()>0){
                    ArrayList<Integer> queue3 = queue.get(j);
                    a[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }
}
