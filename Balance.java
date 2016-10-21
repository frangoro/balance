package balance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Balance {
	
	public static void main(String[] args) {
		boolean bwc, bws;
        String s1 = ")(";
        String s2 = "(a)";
        String s3 = "a((a)())";
        String s4 = "a[(a)]";
        String s5 = "a[(a[)]]";
        List<String> l = new ArrayList<String>();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        l.add(s5);
        Iterator<String> it = l.iterator();
        while (it.hasNext()) {
        	String s = it.next();
        	bwc = blancedWithCounters(s);
        	bws = balanceWithStack(s);
        	System.out.println(s + " is balanced? bwc: " + bwc);
        	System.out.println(s + " is balanced? bws: " + bws);
        }
    }
	
	public static boolean balanceWithStack (String s) {
		Stack<String> stack = new Stack<String>();
		String st;
		String c;
		for (int i = 0; i < s.length(); i++) {
			c = String.valueOf(s.charAt(i));
			if ("(".equals(c) || "[".equals(c)) {
				stack.push(c);
			} else if (")".equals(c) || "]".equals(c)) {
				if (stack.isEmpty()) {
					return false;
				}
				st = stack.pop();
				//TODO Use a map for matching the symbols
				if (")".equals(c) && !"(".equals(st)) {
					return false;
				} else if ("]".equals(c) && !"[".equals(st)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
    
	// If there are more than one symbol then It need
	// to match every symbol type in the right way therefore 
	// a stack is needed.
    public static boolean blancedWithCounters (String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (counter < 0) {
               return false;
            }
            if ('(' == (s.charAt(i))) {
                counter ++;
            } else if (')' == (s.charAt(i))) {
                counter --;
            }
        }
        return true;
    }
}
