package com.jenkins.oj;

public class Test2 {

    public String replaceSpace(StringBuffer str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.replaceSpace(new StringBuffer("   ")));
    }
}
