package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestStack {
    public static Map<Character,Integer> priority = new HashMap<>();
    static{
        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);
        priority.put('/',2);
        priority.put('(',3);
        priority.put(')',3);
    }
    public static void main(String[] args) {
        String str = "0+1-2-3/4-(5-6/7+8)";
        System.out.println(inFix2PostFix(str));
    }

    public static String inFix2PostFix(String expression){
        char []chr = expression.toCharArray();
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for(int i = 0,len=chr.length;i < len;i++){
            System.out.println("char : " + chr[i]);
            //如果是数字，就直接入栈
            if(Character.isDigit(chr[i])){
                sb.append(chr[i] + " ");
            }else if(stack.empty()){
                stack.push(chr[i]);
                System.out.println("栈顶： "+stack.peek());
            }else{

                while(!stack.empty() && priority.get(chr[i]) <= priority.get(stack.peek())){
                    if(chr[i] == '(' || chr[i] == ')'){
                        stack.pop();
                        continue;
                    }
                    sb.append(stack.pop() + " ");
                }
                if(chr[i] == '(' || chr[i] == ')')
                    continue;
                stack.push(chr[i]);
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop() + " ");
        }
        return sb.toString();
    }


}
