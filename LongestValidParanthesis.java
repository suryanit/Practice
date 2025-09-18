import java.util.*;

public class LongestValidParanthesis {

    public int len(String s) {
    	
        int longestValidLength = 0; // initialize the longest Valid Length to 0
        Stack<Integer> stack = new Stack<>();// stack to keep track of the indices
        stack.push(-1); // base sentinel = -1 (this marks the previous invalid string boundary)

        // iterate over all characters in the string
        for (int i = 0; i < s.length(); i++) {
        	
        	if (s.charAt(i) == '(') { // if current character is an opening bracket
        		stack.push(i); // push its index (start of new possible valid substring)
                
            } else { // if current character is a closing bracket
            	stack.pop(); // this will pop the earlier '(' index or the sentinel index
            	
            	if (stack.isEmpty()) { // if it pops the sentinel index
            		stack.push(i); // rebase the sentinel index to the current index
                    
                } else { // if it pops an opening bracket earlier
                    // update longest Valid Length: current index - (last unmatched '(' or sentinel)
                	longestValidLength = Math.max(longestValidLength, i - stack.peek());
                }
            }
        }
        return longestValidLength;
    }
    
    public static void main(String[] args) {
    	
    	// created object of the class
    	LongestValidParanthesis obj = new LongestValidParanthesis();
    	
    	// Each test checks if the output from len() matches the expected result for the given string
    	boolean bool1 = obj.len("(())") == 4;
    	boolean bool2 = obj.len(")()(") == 2;
    	boolean bool3 = obj.len("(") == 0;
    	boolean bool4 = obj.len(")()((())") == 4;
    	boolean bool5 = obj.len("") == 0;
    	boolean bool6 = obj.len("((((((((((((") == 0;
    	boolean bool7 = obj.len("))))))))))))") == 0;
    	boolean bool8 = obj.len(")()())") == 4;
    	boolean bool9 = obj.len("))))))(((((((") == 0;
    	boolean bool10 = obj.len("(()())())(()") == 8;

    	// printing the statuses of each test case
    	System.out.println("Test 1 Status --> "+ (bool1 == true ? "Passed": "Failed"));
    	System.out.println("Test 2 Status --> "+ (bool2 == true ? "Passed": "Failed"));
    	System.out.println("Test 3 Status --> "+ (bool3 == true ? "Passed": "Failed"));
    	System.out.println("Test 4 Status --> "+ (bool4 == true ? "Passed": "Failed"));
    	System.out.println("Test 5 Status --> "+ (bool5 == true ? "Passed": "Failed"));
    	System.out.println("Test 6 Status --> "+ (bool6 == true ? "Passed": "Failed"));
    	System.out.println("Test 7 Status --> "+ (bool7 == true ? "Passed": "Failed"));
    	System.out.println("Test 8 Status --> "+ (bool8 == true ? "Passed": "Failed"));
    	System.out.println("Test 9 Status --> "+ (bool9 == true ? "Passed": "Failed"));
    	System.out.println("Test 10 Status --> "+ (bool10 == true ? "Passed": "Failed"));
    }
}