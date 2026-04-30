package com.the703.basic013_ex;

/*	Animal5{Company / sound()}

	  ↑		    ↑		   ↑
	 Dog5      Cat5	     Bird5
	{@sound()}{@sound()}{@sound()}
  playFetch() scratch()   fly()
 
*/

// 설계목적
interface Animal5 {
   String Company="(주) Thejoa 703";  
   public void sound();
} 
class Dog5 implements Animal5 {
   @Override
   public void sound() {
      System.out.println("멍멍!");
   }
   public void playFetch() {
      System.out.println("강아지가 공을 물어옵니다.");
   }
}
class Cat5 implements Animal5 {
   @Override
   public void sound() {
      System.out.println("야옹~");
   }
   public void scratch() {
      System.out.println("고양이가 발톱을 세웁니다.");
   }
}
class Bird5 implements Animal5 {
   @Override
   public void sound() {
      System.out.println("짹짹!");
   }
   public void fly() {
      System.out.println("새가 하늘을 납니다.");
   }
}

class ZooKeeper5{
	void show(Animal5 a) {
		if(a instanceof Dog5) {
			((Dog5)a).playFetch();
		}else if(a instanceof Cat5) {
			((Cat5)a).scratch();
		}else if(a instanceof Bird5) {
			((Bird5)a).fly();
		}
		a.sound();
	}
}
 
public class Repeat005_oop {

	public static void main(String[] args) {
      java.util.Scanner sc = new java.util.Scanner(System.in);

      //Animal5 ani = new Animal1(); 1) 설계목적, new x
      //Animal5.Company = "(주)네이버"; 2) 상수, 수정x
//      System.out.println(Animal5.Company);
      
      // Animal 배열에 미리 객체를 담아둠
      Animal5[] animals = { new Dog5(), new Cat5(), new Bird5() };

      while (true) {
         System.out.println("=== 동물원 메뉴판 ===");
         System.out.println("1. 강아지");
         System.out.println("2. 고양이");
         System.out.println("3. 새");
         System.out.println("0. 종료");
         System.out.print("선택: ");
         int choice = sc.nextInt();

         if (choice == 0) {
            System.out.println("동물원 관람을 종료합니다.");
            break;
         }

         if (choice < 1 || choice > animals.length) {
            System.out.println("잘못된 선택입니다.");
            continue;
         }

         // 배열에서 바로 꺼내오기
         Animal5 animal = animals[choice - 1];

         // ZooKeeper 클래스의 show() 메서드 호출
         ZooKeeper5 keeper = new ZooKeeper5();
         //리턴값 메서드명(파라미터)
         //void show(Animal5 ani)
         keeper.show(animal);
         System.out.println();
      }
      sc.close();
	}

}


/*

Q1.  다음코드를 확인하고 오류나는 부분을 체크하시오 
- Animal5 ani = new Animal1(); 1) 설계목적, new x
- Animal5.Company = "(주)네이버"; 2) 상수, 수정x
Q2. interface의 멤버변수에 자동으로 붙는 속성은? sf :static final
Q3. interface의 멤버함수에 자동으로 붙는 속성은?  a :abstract
Q4. ZooKeeper 클래스를 작성하시오. (조건: Animal의 sound()와 각 클래스의 고유 메서드를 모두 호출할 것) √
 
조건:
- interface Animal { String Company="(주) Thejoa 703"; public void sound(); }
- Dog, Cat, Bird 클래스는 각각 Animal을 구현하고, 고유 메서드를 가진다.
- ZooKeeper 클래스의 show() 메서드에서 Animal의 sound()와 각 클래스의 고유 메서드를 호출한다.

1. 주어진조건
interface Animal {
   String Company="(주) Thejoa 703";  sf : static final
   public void sound();				  a : abstract
} 
class Dog implements Animal {
   @Override
   public void sound() {
      System.out.println("멍멍!");
   }
   public void playFetch() {
      System.out.println("강아지가 공을 물어옵니다.");
   }
}
class Cat implements Animal {
   @Override
   public void sound() {
      System.out.println("야옹~");
   }
   public void scratch() {
      System.out.println("고양이가 발톱을 세웁니다.");
   }
}
class Bird implements Animal {
   @Override
   public void sound() {
      System.out.println("짹짹!");
   }
   public void fly() {
      System.out.println("새가 하늘을 납니다.");
   }
}

2. 메인화면
public class Repeat005_oop {
   public static void main(String[] args) {
      java.util.Scanner sc = new java.util.Scanner(System.in);

      // Animal 배열에 미리 객체를 담아둠
      Animal[] animals = { new Dog(), new Cat(), new Bird() };

      while (true) {
         System.out.println("=== 동물원 메뉴판 ===");
         System.out.println("1. 강아지");
         System.out.println("2. 고양이");
         System.out.println("3. 새");
         System.out.println("0. 종료");
         System.out.print("선택: ");
         int choice = sc.nextInt();

         if (choice == 0) {
            System.out.println("동물원 관람을 종료합니다.");
            break;
         }

         if (choice < 1 || choice > animals.length) {
            System.out.println("잘못된 선택입니다.");
            continue;
         }

         // 배열에서 바로 꺼내오기
         Animal animal = animals[choice - 1];

         // ZooKeeper 클래스의 show() 메서드 호출
         ZooKeeper keeper = new ZooKeeper();
         keeper.show(animal);
         System.out.println();
      }
      sc.close();
   }
}

3. 실행화면
=== 동물원 메뉴판 ===
1. 강아지
2. 고양이
3. 새
0. 종료
선택: 1
멍멍!
강아지가 공을 물어옵니다.

선택: 2
야옹~
고양이가 발톱을 세웁니다.

선택: 3
짹짹!
새가 하늘을 납니다.

선택: 0
동물원 관람을 종료합니다.
 

*/