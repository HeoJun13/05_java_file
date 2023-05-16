package step5_02.file;


import java.util.Scanner;

//# 파일 컨트롤러[2단계] : ATM

// 17:06 ~ 

public class FileEx07_필기 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int atmSize = 5;
		int accsCnt = 0;
		int identifier = -1;
		
		String[] accs = new String[atmSize];
		String[]  pws = new String[atmSize];
		int[]  moneys = new int[atmSize];
		
		String fileName = "atm.txt";
		
		while(true) {
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				System.out.print("가입할 계좌번호 입력 : ");
				String account = scan.next();
				
				int check = 1;
				
				for (int i = 0; i < accsCnt; i++) {
					if (accs[i].equals(account)) {
						check = -1;
					}
					
				}
				if (check == 1) {
					if(accsCnt == 5) {
						System.out.println("[메세지]더이상 가입할 수 없습니다.");
						continue;
					}
					System.out.print("[가입]비밀번호 입력 : ");
					String pw = scan.next();
					
					accs[accsCnt] = account;
					pws[accsCnt] = pw;
					moneys[accsCnt] = 1000;
					
					accsCnt++;
					System.out.println("[메세지] 회원가입을 축하합니다");
					
				}else {System.out.println("[메세지] 계좌번호가 중복입니다");}
				
			} 
			
			else if (sel == 2) {
				if (identifier != -1) {
					for (int i = identifier; i < accsCnt-1; i++) {
						accs[i] = accs[i+1];
						pws[i] = pws[i +1];
						moneys[i] = moneys[i+1];
					}
					accsCnt--;
					identifier = -1;
					System.out.println("[메세지] 탈퇴되었습니다. ");
				}
				else {
					System.out.println("[메세지] 로그인 후 이용가능합니다 ");
				}
			}
			else if (sel == 3) {
				
				if(identifier == -1) {
					System.out.println("[로그인]계좌번호 입력 : ");
					String account = scan.next();
					
					System.out.println("[비밀번호]비밀번호 입력 : ");
					String pw = scan.next();
					
					for (int i = 0; i < accsCnt; i++) {
						if (accs[i].equals(account) && pws[i].equals(pw)) {
							identifier = i;
						}
					}
					
					if (identifier == -1) {
						System.out.println("[메세지] 계좌번호와 비밀번호를 확인해주세요");
					}
				}
				else {
					System.out.println("[메세지]" + accs[identifier] + "님 로그인 중...");
				}
			}
			else if (sel == 4) {
				
				if(identifier == +1) {
					System.out.println("[메세지] 로드인 후 이용가능합니다. ");
				}
				else {
					identifier = -1;
					System.out.println("[메세지] 로그아웃 되었습니다. ");
				}
			}
			else if (sel == 5) {
				
				if(identifier != -1) {
					System.out.print("[입금] 금액 입력 : ");
					int money = scan.nextInt();
					moneys[identifier] += money;
					System.out.println("[메세지] 입금을 완료되었습니다. ");
					}
				else {
					System.out.println("[메세지] 로그인 후 이용가능합니다.");
				}
				
			}
			else if (sel == 6) {}
			else if (sel == 7) {}
			else if (sel == 8) {}
			else if (sel == 9) {}
			else if (sel == 10) {}
			else if (sel == 0) {
				break;
			}
			
		}
		
	}
}
