package BitwiseOperators;

public class Operator {
    public static void main(String[] args) {
        //bit manipulaton
        // 1. get bit operation

        int num = 5; //0101
        int pos = 1;
        //int bitMask = 1<<pos;
        // if((bitMask & num) == 0) System.out.println("bit is zero");
        // else{
        //     System.out.println("bit is one");
        // }

        // 2.set bit

        int bitMask = 1<<pos;
        System.out.println(bitMask | num);

        //3.clear bit
        

    }
}
