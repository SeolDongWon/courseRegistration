package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.StudentVO;

public class StudentRegisterManager {
	public static Scanner input = new Scanner(System.in);

	// 학생 정보 등록
	public void studnetRegistr() {
		SubjectDAO sbDAO = new SubjectDAO();
		StudentDAO stDAO = new StudentDAO();
		StudentVO stVO = new StudentVO();

		String sd_num = null; // 학번
		String sd_name = null; // 이름
		String sd_id = null; // 아이디
		String sd_passwd = null; // 비밀번호
		String s_num = null; // 학과번호
		String sd_birthday = null; // 생년월일
		String sd_phone = null; // 핸드폰번호
		String sd_address = null; // 주소
		String sd_email = null; // 이메일
		boolean id_check = false; // 아이디 체크
		String year = null; // 년도

		System.out.printf("학생 정보 입력\n성명>>");
		sd_name = input.nextLine();

		do { // 아이디 중복 체크
			System.out.print("아이디(8자 이상 12자 이내)>>");
			sd_id = input.nextLine();
			id_check = stDAO.getStudentIdOverlap(sd_id);
			if (id_check) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요");
			}
		} while (id_check);

		System.out.print("비밀번호(12자 이내)>>");
		sd_passwd = input.nextLine();
		sbDAO.getSubjectTotalList();
		System.out.print("학과번호>>");
		s_num = input.nextLine();

		// 학생 번호는 8자리로 생성한다. (연도2자리+학과2자리+일련번호 - 예로06010001)
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		year = sdf.format(new Date());
		sd_num = year + s_num + stDAO.getStudentCount(s_num);

		System.out.print("생년월일(8자리)>>");
		sd_birthday = input.nextLine();
		System.out.print("전화번호>>");
		sd_phone = input.nextLine();
		System.out.print("도로명 주소>>");
		sd_address = input.nextLine();
		System.out.print("이메일>>");
		sd_email = input.nextLine();

		stVO.setSd_num(sd_num);
		stVO.setSd_name(sd_name);
		stVO.setSd_id(sd_id);
		stVO.setSd_passwd(sd_passwd);
		stVO.setS_num(s_num);
		stVO.setSd_birthday(sd_birthday);
		stVO.setSd_phone(sd_phone);
		stVO.setSd_address(sd_address);
		stVO.setSd_email(sd_email);
		stDAO.setStudentRegister(stVO);

		System.out.println();
		System.out.println("등록 학생 정보");
		stDAO.getStudent(stVO.getSd_id(), stVO.getSd_passwd());
		System.out.println();
	}

	// 학생 정보 수정
	public void studnetUpdate() {
		StudentDAO stDAO = new StudentDAO();
		StudentVO stVO = new StudentVO();

		String id = null; // 아이디
		String pw = null; // 입력 비밀번호
		String sd_num = null; // 학번
		String sd_passwd = null; // 수정 비밀번호
		String sd_phone = null; // 수정 전화번호
		String sd_address = null; // 수정 주소
		String sd_email = null; // 수정 이메일
		boolean success = false;

		System.out.println("학생 정보 수정");
		do {
			System.out.print("아이디>>");
			id = input.nextLine();
			System.out.print("비밀번호>>");
			pw = input.nextLine();
			success = stDAO.getStudentLogin(id, pw);

			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
			}

		} while (!success);

		sd_num = stDAO.getStudentNum(id, pw);
		System.out.printf("\n수정할 학생\n학생번호>>" + sd_num);
		System.out.printf("\n비밀번호(12자 이내)>>");
		sd_passwd = input.nextLine();
		System.out.print("전화번호>>");
		sd_phone = input.nextLine();
		System.out.print("도로명 주소>>");
		sd_address = input.nextLine();
		System.out.print("이메일>>");
		sd_email = input.nextLine();

		stVO.setSd_num(sd_num);
		stVO.setSd_passwd(sd_passwd);
		stVO.setSd_phone(sd_phone);
		stVO.setSd_address(sd_address);
		stVO.setSd_email(sd_email);
		stDAO.setStudentUpdate(stVO);

		System.out.println();
		System.out.println("학생 정보 수정 결과");
		stDAO.getStudent(id, stVO.getSd_passwd());
		System.out.println();
	}

	// 학생 전체 목록
	public void studnetTotalList() {
		StudentDAO stDAO = new StudentDAO();
		String pw = null;
		System.out.printf("\n학생 정보 전체 목록\n관리자 비밀번호>>");
		pw = input.nextLine();
		if (pw.equals("1234")) {
			stDAO.getStudentTotalList();
		} else {
			System.out.println("관리자 비밀번호가 틀립니다.");
		}
	}
}