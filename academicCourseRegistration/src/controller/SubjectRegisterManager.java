package controller;

import java.util.Scanner;
import model.SubjectVO;

public class SubjectRegisterManager {
	public static Scanner input = new Scanner(System.in);

	// 학과 목록
	public void subjectList() {
		SubjectDAO sd = new SubjectDAO();
		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList(); // select * from subject 를 실행하는 메서드
		System.out.println();
	}

	// 학과 등록
	public void subjectRegister() {
		String s_num = null; // 학과 번호
		String s_name = null; // 학과명

		SubjectDAO sd = new SubjectDAO();
		SubjectVO svo = new SubjectVO();

		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();

		System.out.printf("\n학과 정보 입력\n학과번호>>");
		s_num = input.nextLine();
		System.out.print("학과명>>");
		s_name = input.nextLine();
		svo.setS_num(s_num); // 입력한 학과번호와 학과명을 객체에 할당
		svo.setS_name(s_name);
		try { // 데이터를 객체에 넣고 객체째 매개변수로 전달
			sd.setSubjectRegiste(svo); // 입력한 데이터와 쿼리를 DB에 전송하는 메서드
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("학과 정보 입력 오류");
		}

		System.out.printf("\n학과 전체 리스트\n");
		sd.getSubjectTotalList();
		System.out.println();
	}

	// 학과 수정
	public void subjectUpdate() {
		int s_no = 0; // 학과 일련번호
		String s_num = null;
		String s_name = null;

		SubjectDAO sd = new SubjectDAO();
		SubjectVO svo = new SubjectVO();

		System.out.printf("\n학과 전체 리스트\n");

		sd.getSubjectTotalList();
		System.out.printf("\n수정할 학과 일련번호 입력\n일련번호>>");
		s_no = input.nextInt();
		input.nextLine(); // 입력 버퍼 클리어

		System.out.printf("\n새로운 정보 모두 입력\n학과번호>>");
		s_num = input.nextLine();
		System.out.print("학과명>>");
		s_name = input.nextLine();

		svo.setNo(s_no);
		svo.setS_num(s_num);
		svo.setS_name(s_name);
		sd.setSubjectUpdate(svo);

		System.out.printf("\n학과 전체 리스트\n");
		sd.getSubjectTotalList();
		System.out.println();
	}

	// 학과 삭제
	public void subjectDelete() {
		int s_no = 0;

		SubjectDAO sd = new SubjectDAO();

		System.out.println("학과 전체 리스트");
		sd.getSubjectTotalList();

		System.out.printf("\n삭제할 학과 일련번호 입력\n일련번호>>");
		s_no = input.nextInt();
		input.nextLine(); // 입력 버퍼 클리어

		sd.setSubjectDelete(s_no);

		System.out.printf("\n학과 전체 리스트\n");
		sd.getSubjectTotalList();
		System.out.println();
	}
}