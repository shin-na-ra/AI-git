package com.prj.base;

import java.util.Scanner;

public class Menu {
	
	

	public static final int MAX = 10; // 메뉴 최대 갯수 15로 지정
	
	//전역변수 선언
	static String[] menu = new String[MAX];
	static int[] price = new int[MAX];
	static int [] stock = new int[MAX];
	static int count = 5;			//메뉴의 갯
	static int admin = 1111;		//관리자 메뉴 비밀번
	static int profit = 0;			//총수익
	static Scanner sc = new Scanner(System.in);
	
	// 처음 키오스크 초기화 함수
	public static void init() {
		menu[0] = "국밥";
		price[0] = 10000;
		stock[0] = 5;
		
		menu[1] = "돈까스";
		price[1] = 11000;
		stock[1] = 6;
		
		menu[2] = "쫄면";
		price[2] = 8000;
		stock[2] = 4;
		
		menu[3] = "짜장면";
		price[3] = 8000;
		stock[3] = 7;
		
		menu[4] = "마라탕";
		price[4] = 13000;
		stock[4] = 6;
	
	}
	
	//관리자 페이지 담당 함수
	public static void admin() {
		while (true) {
			System.out.println("=====================================================");
			System.out.println("관리자 페이지 입니다.");
			System.out.println("[1]메뉴변경 | [2]가격변경 | [3]재고추가 | [4]메뉴추가 | (종료 : -1)");
			System.out.print("번호를 입력하세요 : ");
			int num = sc.nextInt();
			System.out.println("=====================================================");
			
			//1. 메뉴변경
			if(num == 1) {
				System.out.print("변경할 메뉴의 번호를 입력하세요(1~"+count+") : ");
				int i = sc.nextInt();
				System.out.print(menu[i-1] + "를 무엇으로 바꾸시겠습니까? : ");
				sc.nextLine();
				String name = sc.next();
				System.out.print(name+"의 가격은 얼마입니까?");
				int v = sc.nextInt();
				System.out.print(name + "의 재고를 몇 개 등록하시겠습니까? : ");
				int n = sc.nextInt();
				
				menu[i-1] = name;
				price[v-1] = v;
				stock[n-1] = n;
				System.out.println("메뉴 변경이 완료되었습니다.");
				
			}
			//2. 가격 변경
			else if(num == 2){
				System.out.print("변경할 메뉴의 번호를 입력하세요(1~"+count+") : ");
				int i = sc.nextInt();
				System.out.print(menu[i-1]+ "의 가격을 얼마로 바꾸시겠습니까? :");
				int j = sc.nextInt();
				price[j-1] = j;
				System.out.println("가격이 변경되었습니다.");
			}
			//3. 재고추가
			else if(num == 3) {
				System.out.print("재고를 추가할 메뉴 번호를 입력하세요. 1~"+count+") :");
				int i = sc.nextInt();
				System.out.print(menu[i-1] + "를 몇개 추가 하시겠습니까?");
				int j = sc.nextInt();
				stock[i-1] +=j;
				System.out.println("재고가 추가되었습니다.");
			} 
			//4. 메뉴추가
			else if(num == 4) {
				if(count >= MAX - 1) {
					System.out.println("더 이상 메뉴를 추가할 수 없습니다.");
					continue;
				}
				else {
					System.out.print("추가할 메뉴의 가격을 입력하세요 : ");
					int i = sc.nextInt();
					System.out.print("추가할 메뉴의 이름을 입력하세요 : ");
					sc.nextLine();
					String name = sc.next();
					System.out.print(name +"의 재고는 몇 개 입니까? : ");
					int j = sc.nextInt();
					
					menu[count] = name;
					price[count] = i;
					stock[count] = j;
					count++;
					System.out.println("메뉴 추가가 되었습니다");
				}
			}
			
			//-1 입력
			else if(num == -1) {
				//user();
				return;
			}
		}
	}
			
	public static void main(String[] args) {
		init();
		admin();
		return;
		//user();
	}
}
