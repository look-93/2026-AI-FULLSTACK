package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////
//1. 아이스크림정보 클래스
class IceCreamDTO2 {
	private String name;
	private int price;

// 생성자, 필요하다면 추가   , toString , getters/setters  ,  hashCode/equals
	public IceCreamDTO2() {
		super();
	}

	public IceCreamDTO2(String name) {
		super();
		this.name = name;
	} // ##

	public IceCreamDTO2(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "- " + name + " (" + price + ")";
	} // ##

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

//1. IceCreamDTO 확인   ##
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

//2. 값확인 ##
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IceCreamDTO2 other = (IceCreamDTO2) obj;
		return Objects.equals(name, other.name);
	}
}

////////////D////////////////////////////////////////////////////////////////
//2. List 사용클래스
public class ListEx003_v2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		int price = 0, choice = -1;
		List<IceCreamDTO2> list = new ArrayList<>();

		System.out.println("❄️🍦 Welcome to the Magical IceCream Land 🍦❄️");
		System.out.println("✨ 오늘도 달콤한 하루가 시작됩니다! ✨\n" + "🛎️ 손님~ 어떤 아이스크림을 원하시나요?\n");

		while (choice != 0) {
			System.out.print("\n\n\n📋 메뉴판 \n" + "🍧 IceCream Menu 🍧  \n" + "1️ 아이스크림 추가\n" + "2️ 아이스크림 목록 보기\n"
					+ "3️ 아이스크림 제거\n" + "4️ 아이스크림 존재 확인\n" + "5️ 총 아이스크림 개수\n" + "0️ 종료\n" + "👉 선택:");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("🍓 아이스크림 이름 : ");
				name = scanner.next();
				System.out.print("💰 가격          : ");
				price = scanner.nextInt();
				list.add(new IceCreamDTO2(name, price));
				System.out.println("✅ " + name + " 추가 완료!  ");
				break;
			case 2: // 2. 목록 아이스크림목록 list.get()
				if (list.size() == 0) {
					System.out.println("아직 등록된 아이스크림이 없습니다.");
					continue;
				}
				for (IceCreamDTO2 a : list) {
					System.out.println(a);
				}
				break;
			case 3: // 3. 제거 아이스크림 이름입력받아서 제거 list.remove()
				System.out.print("🍓 제거할 아이스크림 이름 : ");
				name = scanner.next();
				System.out.println(list.remove(new IceCreamDTO2(name)) ? " 제거완료" : "제거실패");
				break;
			case 4: // 4. 검색 내가 입력한 아이스크림이 있는지없는지 검색 contains
				System.out.print("🍓 검색할  아이스크림 이름 : ");
				name = scanner.next();
				System.out.println(list.contains(new IceCreamDTO2(name)) ? "존재합니다" : "존재하지 않습니다.");
				break;
			case 5:
				System.out.println("총 아이스크림 개수 : " + list.size());
				break; // 5. 갯수 아이스크림총갯수 size
			case 0:
				System.out.println("👋 아이스크림 가게를 닫습니다. 다음에 또 만나요!");
				break;
			}

		}

	}
}