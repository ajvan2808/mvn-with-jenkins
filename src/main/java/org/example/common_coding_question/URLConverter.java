package org.example.common_coding_question;

public class URLConverter {
    public String urlify(String url, int length) {
        // Create a bucket to hold the result
        char[] result = new char[length];

        // Strip off space beginning and the end
        url = url.trim();

        // Loop through the url and insert an ASCII '%20' whenever we hit a space
        char[] urlChars = url.toCharArray();
        // A pointer to keep track
        int pointer = 0;

        for (int i = 0; i < urlChars.length; i++) {
            if (urlChars[i] != ' ') {
                result[pointer] = urlChars[i];
                pointer++;
            }
            else {
                result[pointer] = '%';
                result[pointer+1] = '2';
                result[pointer+2] = '0';
                pointer = pointer+3;
            }
            prettyPrint(result);
            System.out.println("...");
        }
        return String.valueOf(result);
    }

    private void prettyPrint(char[] chars) {
        for (char aChar : chars) {
            System.out.println("c[" + aChar + "]");
        }
    }
}
