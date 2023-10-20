package model;

import java.util.Objects;

public class SubjectVO { // Subject Value Object
	private int no; // 학과 일련번호, 유일키, 자동증가
	private String s_num; // 학과 번호, 기본키
	private String s_name; // 학과명

	public SubjectVO() {
		super();
	}

	public SubjectVO(String s_num, String s_name) {
		this(0, s_num, s_name);
	}

	public SubjectVO(int no, String s_num, String s_name) {
		super();
		this.no = no;
		this.s_num = s_num;
		this.s_name = s_name;
	}

	public int getNo() {
		return no;
	}

	public String getS_num() {
		return s_num;
	}

	public String getS_name() {
		return s_name;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setS_num(String s_num) {
		this.s_num = s_num;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.no, this.s_num);
	}

	@Override
	public boolean equals(Object obj) {
		SubjectVO sub = null;
		if (!(obj instanceof SubjectVO)) {
			return false;
		}
		sub = (SubjectVO) obj;
		return this.no == sub.no && this.s_num.equals(sub.s_num);
	}

	@Override
	public String toString() {
		return no + "\t" + s_num + "\t" + s_name;
	}

}
