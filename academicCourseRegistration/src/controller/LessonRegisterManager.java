package controller;

import java.util.Scanner;
import model.LessonVO;

public class LessonRegisterManager {
	public static Scanner input = new Scanner(System.in);

	// 과목 목록
	public void lessonList() {
		LessonDAO lsDAO = new LessonDAO();

		System.out.println("과목 전체 리스트");
		lsDAO.getLessonTotalList();
		System.out.println();
	}

	// 과목 등록 관리
	public void lessonRegistr() {
		LessonDAO lsDAO = new LessonDAO();
		LessonVO lsVO = new LessonVO();

		String l_abbre = null; // 과목약어
		String l_name = null; // 과목명

		System.out.println("과목 전체 리스트");
		lsDAO.getLessonTotalList();

		System.out.println();
		System.out.println("과목 정보 입력");
		System.out.print("과목약어 : ");
		l_abbre = input.nextLine();
		System.out.print("과목명 : ");
		l_name = input.nextLine();

		lsVO.setL_abbre(l_abbre);
		lsVO.setL_name(l_name);
		lsDAO.setLessonRegiste(lsVO);

		System.out.println();
		System.out.println("과목 전체 리스트");
		lsDAO.getLessonTotalList();
		System.out.println();
	}

	// 과목 수정 관리
	public void lessonUpdate() {
		LessonDAO lsDAO = new LessonDAO();
		LessonVO lsVO = new LessonVO();

		int l_no = 0; // 수정할 과목 일련번호

		String l_abbre = null; // 수정할 과목약어
		String l_name = null; // 수정할 과목명

		System.out.println("과목 전체 리스트(사용중인 과목 변경 불가)");
		lsDAO.getLessonTotalList();

		System.out.println();
		System.out.println("수정할 과목 일련번호 입력");
		System.out.print("일련번호 : ");
		l_no = input.nextInt();
		input.nextLine();

		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("과목약어 : ");
		l_abbre = input.nextLine();
		System.out.print("과목명 : ");
		l_name = input.nextLine();

		lsVO.setNo(l_no);
		lsVO.setL_abbre(l_abbre);
		lsVO.setL_name(l_name);
		lsDAO.setLessonUpdate(lsVO);

		System.out.println();
		System.out.println("과목 전체 리스트");
		lsDAO.getLessonTotalList();
		System.out.println();
	}

	// 과목 삭제 관리
	public void lessonDelete() {
		LessonDAO lsDAO = new LessonDAO();
		int l_no = 0; // 삭제할 과목 번호

		System.out.println("과목 전체 리스트(사용중인 과목 삭제 불가)");
		lsDAO.getLessonTotalList();

		System.out.println();
		System.out.println("삭제할 과목 일련번호 입력");
		System.out.print("일련번호 : ");
		l_no = input.nextInt();
		input.nextLine();

		lsDAO.setLessonDelete(l_no);

		System.out.println();
		System.out.println("학과 전체 리스트");
		lsDAO.getLessonTotalList();
		System.out.println();
	}
}