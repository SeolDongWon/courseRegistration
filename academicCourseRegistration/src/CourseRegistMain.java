import view.LESSON_CHOICE;
import view.MENU_CHOICE;
import view.MenuViewer;
import view.STUDENT_CHOICE;
import view.SUBJECT_CHOICE;
import view.TRAINEE_CHOICE;

public class CourseRegistMain {

	public static void main(String[] args) {
		mainMenu();
	}

	private static void mainMenu() {
		int choiceNum = 0;
		boolean stopFlag = false;

		while (!stopFlag) {
			try {
				// 메인메뉴 출력
				MenuViewer.mainMenuView();
				// 키보드 입력
				choiceNum = MenuViewer.choice.nextInt();
				// 입력버퍼 클리어
				MenuViewer.choice.nextLine();

				switch (choiceNum) {
				case MENU_CHOICE.SUBJECT: // MENU_CHOICE의 상수 정수 1
					subjectMenu(); // 학과 메뉴
					break;
				case MENU_CHOICE.STUDENT: // MENU_CHOICE의 상수 정수 2
					studentMenu(); // 학생 메뉴
					break;
				case MENU_CHOICE.LESSON: // MENU_CHOICE의 상수 정수 3
					lessonMenu(); // 과목 메뉴
					break;
				case MENU_CHOICE.TRAINEE: // MENU_CHOICE의 상수 정수 4
					traineeMenu(); // 수강 메뉴
					break;
				case MENU_CHOICE.EXIT: // MENU_CHOICE의 상수 정수 5
					System.out.println("프로그램을 종료합니다.");
					stopFlag = true;
					break;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을다시 시작하세요.");
				stopFlag = true;
			}
		}
	}

	private static void traineeMenu() { // 수강 메뉴
		int choice = 0;
		// 객체 // 수강 CRUD 컨트롤러
		MenuViewer.traineeMenuView(); // 수강 메뉴 출력
		choice = MenuViewer.choice.nextInt(); // 수강 메뉴 입력
		MenuViewer.choice.nextLine();
		switch (choice) {
		case TRAINEE_CHOICE.LIST: // TRAINEE_CHOICE의 상수 정수 1
			System.out.println("");
			// 수강매니저.목록 // 수강 목록
			break;
		case TRAINEE_CHOICE.INSERT: // TRAINEE_CHOICE의 상수 정수 2
			System.out.println("");
			// 수강매니저.등록 // 수강 등록
			break;
		case TRAINEE_CHOICE.UPDATE: // TRAINEE_CHOICE의 상수 정수 3
			System.out.println("");
			// 수강매니저.삭제 // 수강 삭제
			break;
		case TRAINEE_CHOICE.MAIN: // TRAINEE_CHOICE의 상수 정수 4
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

	private static void subjectMenu() { // 학과메뉴
		int choice = 0;
		// 객체 // 학과 CRUD 컨트롤러
		MenuViewer.subjectMenuView(); // 학과 메뉴 출력
		choice = MenuViewer.choice.nextInt(); // 학과 메뉴 입력
		MenuViewer.choice.nextLine();
		switch (choice) {
		case SUBJECT_CHOICE.LIST: // SUBJECT_CHOICE의 상수 정수 1
			System.out.println("");
			// 학과매니저.목록 // 학과 목록
			break;
		case SUBJECT_CHOICE.INSERT: // SUBJECT_CHOICE의 상수 정수 2
			System.out.println("");
			// 학과매니저.생성 // 학과 생성
			break;
		case SUBJECT_CHOICE.UPDATE: // SUBJECT_CHOICE의 상수 정수 3
			System.out.println("");
			// 학과매니저.수정 // 학과 수정
			break;
		case SUBJECT_CHOICE.DELETE: // SUBJECT_CHOICE의 상수 정수 4
			System.out.println("");
			// 학과매니저.삭제 // 학과 삭제
			break;
		case SUBJECT_CHOICE.MAIN: // SUBJECT_CHOICE의 상수 정수 5
			return; // 나가기
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	private static void studentMenu() { // 학생 메뉴
		int choice = 0;
		// 객체 // 학생 CRUD 컨트롤러
		MenuViewer.studentMenuView(); // 학생 메뉴 출력
		choice = MenuViewer.choice.nextInt(); // 학생 메뉴 입력
		MenuViewer.choice.nextLine();
		switch (choice) {
		case STUDENT_CHOICE.LIST: // STUDENT_CHOICE의 상수 정수 1
			System.out.println("");
			// 학생매니저.목록 // 학생 목록
			break;
		case STUDENT_CHOICE.INSERT: // STUDENT_CHOICE의 상수 정수 2
			System.out.println("");
			// 학생매니저.등록 // 학생 등록
			break;
		case STUDENT_CHOICE.UPDATE: // STUDENT_CHOICE의 상수 정수 3
			System.out.println("");
			// 학생매니저.수정 // 학생 수정
			break;
		case STUDENT_CHOICE.DELETE: // STUDENT_CHOICE의 상수 정수 4
			System.out.println("");
			// 학생매니저.삭제 // 학생 삭제
			break;
		case STUDENT_CHOICE.MAIN: // STUDENT_CHOICE의 상수 정수 5
			return; // 나가기
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	private static void lessonMenu() { // 과목 메뉴
		int choice = 0;
		// 객체 // 과목 CRUD 컨트롤러
		MenuViewer.lessonMenuView();
		choice = MenuViewer.choice.nextInt(); // 과목 메뉴 출력
		MenuViewer.choice.nextLine(); // 과목 메뉴 입력
		switch (choice) {
		case LESSON_CHOICE.LIST: // LESSON_CHOICE의 상수 정수 1
			System.out.println("");
			// 과목매니저.목록 // 과목 목록
			break;
		case LESSON_CHOICE.INSERT: // LESSON_CHOICE의 상수 정수 2
			System.out.println("");
			// 과목매니저.등록 // 과목 등록
			break;
		case LESSON_CHOICE.UPDATE: // LESSON_CHOICE의 상수 정수 3
			System.out.println("");
			// 과목매니저.수정 // 과목 수정
			break;
		case LESSON_CHOICE.DELETE: // LESSON_CHOICE의 상수 정수 4
			System.out.println("");
			// 과목매니저.삭제 // 과목 삭제
			break;
		case LESSON_CHOICE.MAIN: // LESSON_CHOICE의 상수 정수 5
			return; // 나가기
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

}
