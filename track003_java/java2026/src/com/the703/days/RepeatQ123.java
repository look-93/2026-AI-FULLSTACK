package com.the703.days;
class A11 {
    int a; // (1)

    A11() { }                          //기본생성자

    A11(int a) { this.a = a; } // (2) 필드있는생성자

    //(3) void show()
    void show() { 
        this.a = 11; 
        System.out.println(this.a); 
    }

    //(4) static void classMethod()
//    static void classMethod() { this.a = 12; }

    //(5) int showZ()
//    int showZ() { 
//        int a; 
//        return a; 
//    }
}
public class RepeatQ123 {

	public static void main(String[] args) {
        A11 a1 = new A11(); 

	}

}
