//this code converts the postfix values to exact value

import java.util.*;

public class Main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            String str = sc.next();
          //  System.out.print(str+" ");
            int res = exp(str);
            System.out.println(res);
        }
    }

    static int exp(String str) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                st.push(c - '0');
            } else {
                int sec = st.pop();
                int fir = st.pop();
                if (c == '+') {
                    st.push(fir + sec);
                } else if (c == '-') {
                    st.push(fir - sec);
                } else if (c == '*') {
                    st.push(fir * sec);
                } else if (c == '/') {
                    st.push(fir / sec);
                }
            }
        }
        return st.pop();
    }
}
