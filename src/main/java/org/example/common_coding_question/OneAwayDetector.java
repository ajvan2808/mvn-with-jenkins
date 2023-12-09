package org.example.common_coding_question;

public class OneAwayDetector {
    // Find if any replacement btw original string and new string
    public boolean oneAway(String firstStr, String secondStr) {
        // If strings are in same length -> they're one replacement away
        // If string differ by one/ one less -> they may be edited or inserted

        if (firstStr.length() == secondStr.length()) {
            return oneEditReplace(firstStr, secondStr);
        } else if (firstStr.length() - 1 == secondStr.length()) {
            return oneEditInsert(secondStr, firstStr);

        } else if (firstStr.length() + 1 == secondStr.length()) {
            return oneEditInsert(firstStr, secondStr);
        }
        return false;
    }

    /*
    To find not more than one edit, insert or replacement
    Check if there inserting in s1 to make s2
    - By comparing characters and pointers, if you detected that one character doesn't match,
      compare the indexes. If they're same then it's OK -> It's the first check, and it doesn't match
      Increment the pointers, if a character don't match again and the pointer don't match
      then it more than one away.
    */
    public boolean oneEditReplace(String s1, String s2) {
        boolean foundReplacement = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                if (foundReplacement) {
                    return false;
                }
                foundReplacement = true;
            }
        }
        return true;
    }

    public boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            }
            else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
