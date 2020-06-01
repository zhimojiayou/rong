package com.wf.rong.controller;

/**
 * @author zhimo
 * @create 2019-10-16 9:20
 */
public class Person {

    public void resolve(final String name, final int age) {
        System.out.println("Person----who is this class : " + getClass());
        for(int index = 0; index < 5; ++index){
            System.out.println("Person name is : " + name + " ; age is : " + (age + index));
        }
    }

    //public static void main(String[] args) {
    //    String tmp = "68383639353035303430303338313333000102FD0B007100077A2A5100004F004B02002B00000000000100000000020000000003190922054030040000051909210000000601550700000800010B0307000A190922000000000F0300040008000001000201050005000201000000B716";
    //    StringBuilder sb = new StringBuilder(128);
    //    String str;
    //    char[] chars = tmp.toCharArray();
    //    for (int index = 0; index < chars.length; ++index) {
    //
    //        if(index > 0 && (index % 2 == 0)){
    //            sb.append(" ");
    //        }
    //        sb.append(chars[index]);
    //    }
    //    System.out.println(sb.toString());
    //}
}
