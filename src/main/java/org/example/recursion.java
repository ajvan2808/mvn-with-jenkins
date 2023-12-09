package org.example;

public class recursion {
    
    public String stripZeros(String text) {
        if (text.startsWith("0")) {
            String subString = text.substring(1);
            return stripZeros(subString);
            // return stripZeros(text.substring(1))
        }
        return text;
    }

    // public static void main(String[] args) {
    //     recursion Rec = new recursion();
    //     System.out.println(Rec.stripZeros("000098"));
    // }
}