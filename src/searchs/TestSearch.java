package searchs;

import java.util.Arrays;

public class TestSearch {
    public static void main(String[] args) {
        int []a = {1,2,3,45,67,89,98};
        System.out.println(binSearch2(a,67));
    }

    /**
     * 二分查找，方式一
     * （有序序列）
     * @param a
     * @param desc
     * @return
     */
    public static int binarySearch(int []a,int desc){
        int low = 0;
        int high = a.length;
        while(low < high){
            //以中点为轴点
            int mid = (low + high) >> 1;
            //深入前半段[low,mid)继续查找
            if(desc < a[mid]){
                high = mid;
            }
            //深入后半段(mid,high)
            else if(a[mid] < desc){
                low = mid + 1;
            }else{
                //在mid处命中
                return mid;
            }
        }
        //查找失败
        return -1;
    }

    /**
     *二分查找，方式一的改进版
     * 相对于方式一，最好（坏）情况下更坏（好）；各种情况下的SL更加接近，整体性能更趋稳定
     * @param a
     * @param desc
     * @return
     */
    public static int binSearch2(int []a,int desc){
        int low = 0;
        int high = a.length;
        //有效查找区间的宽度缩短到1时，算法才会终止
        while(1 < (high-low)){
            //以中点为轴点，经比较后确定深入
            int mid = (low+high) >> 1;
            //[low,mid)或[mid,high)
            if(desc < a[mid]){
                high = mid;
            }else{
                low = mid;
            }
            //出口时high=low+1，查找区间只含有一个元素a[low]
        }
        return (desc == a[low]) ? low : -1;
    }
}
