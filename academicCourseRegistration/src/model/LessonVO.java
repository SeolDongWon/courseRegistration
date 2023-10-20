package model;

import java.util.Objects;

public class LessonVO {
	private int no; // 과목 일련번호, 유일키, 자동증가
	private String l_abbre; // 과목약어, 기본키
	private String l_name; // 과목명

	public LessonVO() {
		super();
	}

	public LessonVO(int no, String l_abbre, String l_name) {
		super();
		this.no = no;
		this.l_abbre = l_abbre;
		this.l_name = l_name;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setL_abbre(String l_abbre) {
		this.l_abbre = l_abbre;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getNo() {
		return no;
	}

	public String getL_abbre() {
		return l_abbre;
	}

	public String getL_name() {
		return l_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.no, this.l_abbre);
	}

	@Override
	public boolean equals(Object obj) {
		LessonVO les = null;
		if (!(obj instanceof LessonVO)) {
			return false;
		}
		les = (LessonVO) obj;
		return this.no == les.no && this.l_abbre.equals(les.l_abbre);
	}

	@Override
	public String toString() {
		return no + "\t" + l_abbre + "\t" + l_name;
	}

}
