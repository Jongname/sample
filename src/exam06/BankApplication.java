package exam06;

import java.util.Scanner;

public class BankApplication {
	
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		boolean run =true;
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.���»���|2.���¸��|3.����|4.���|5.����");
			System.out.println("-----------------------------------");
			System.out.println("Choice >");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo==1) {
				createAccount();
				
			}else if(selectNo==2) {
				accountList();
			}else if(selectNo==3) {
				deposit();
			}else if(selectNo==4) {
				withdraw();
			}else {
				run=false;
			}
			
		}
	}
		//���� ����
		private static void createAccount() {
			
			System.out.println("���� ��ȣ");
			String ano = scanner.next();
			System.out.println("������");
			String owner = scanner.next();
			System.out.println("�ݾ�");
			int balance = scanner.nextInt();
			
			Account newAccount = new Account(ano, owner, balance);
			for(int i=0; i<accountArray.length;i++) {
				if(accountArray[i]==null) {
					accountArray[i]=newAccount;
					break;
				}
			}
		}
		//���� ���
		private static void accountList() {
		for(int i =0; i<accountArray.length; i++) {
			
			Account account = accountArray[i];
			if(account!=null) {
				System.out.println(account.getAno());
				System.out.println(account.getOwner());
				System.out.println(account.getBalance());
			}
		}
		}
		//����
		private static void deposit() {
			String ano =scanner.next();
			int money = scanner.nextInt();
			
			Account account = findAccount(ano);
			if(account == null) {
				System.out.println("����");
			}
			account.setBalance(account.getBalance()+money);
		}	
			
		//���
		private static void withdraw() {
			String ano =scanner.next();
			int money = scanner.nextInt();
			Account account = findAccount(ano);
			if(account==null) {
				System.out.println("����");
			}
			account.setBalance(account.getBalance()-money);
		}
		
		//ã��
		private static Account findAccount(String ano) {
			Account account = null;
			for(int i =0; i<accountArray.length;i++) {
				if(accountArray[i]!=null) {
					String dbAno =accountArray[i].getAno();
					if(dbAno.equals(ano)) {
						account = accountArray[i];
						
					}
				}
			}
			return account;
		}
	
	
	}


