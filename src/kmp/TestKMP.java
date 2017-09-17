package kmp;

public class TestKMP {
    public static void main(String[] args) {

        String s = "bbc abcdab abcdabcdabde";
        String d = "abcdabd1";
        int []next = buildNext(d.toCharArray());
        System.out.println(kmp(s.toCharArray(),d.toCharArray(),next));
    }
    public static  int kmp(char [] s,char [] desc,int []next){
        int i = 0;//s index
        int j = 0;//desc index
        int s_len = s.length;
        int desc_len = desc.length;
        while(i < s_len && j < desc_len){
            if(j == -1 || s[i] == desc[j]){
                i ++;
                j ++;
            }else{
                j = next[j];
            }
        }
        if(j == desc_len)
            return i-j;
        return -1;
    }
    public static int[] buildNext(char[] str){
        int len = str.length;
        int [] next = new int[len];
        //i：后缀；j：前缀
        int i = 0;
        int j = -1;
        next[0] = -1;

        while(i < len-1){
            if(j == -1 || str[i] == str[j]){
                i ++;
                j ++;
                next[i] = j;
                System.out.println("str["+j+"] = "+str[j]+",str["+i+"] = " + str[i]);
                System.out.println("next["+i+"] = " +next[i]);
            }else{
                j = next[j];
                System.out.println("j = " + j);
            }
        }
        return next;
    }
}
