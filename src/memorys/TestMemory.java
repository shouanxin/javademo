package memorys;

public class TestMemory {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        //默认情况下分配给JVM的最大内存空间为总内存的1/4.
        /**
         * 输出结果（本机内存：4G）
         * MAX_MEMORY = 922746880 (880.0)兆
         * TOTAL_MEMORY = 62390272 (59.5)兆
         * FREE_MEMORY = 59783360 (57.01385498046875)兆
         */
        System.out.println("MAX_MEMORY = " + run.maxMemory() + " ("+(double)run.maxMemory()/1024/1024+")兆");
        //默认情况下，除了伸缩区之外的内存空间
        System.out.println("TOTAL_MEMORY = " + run.totalMemory() + " ("+(double)run.totalMemory()/1024/1024+")兆");
        System.out.println("FREE_MEMORY = " + run.freeMemory()+ " ("+(double)run.freeMemory()/1024/1024+")兆");
    }
}
