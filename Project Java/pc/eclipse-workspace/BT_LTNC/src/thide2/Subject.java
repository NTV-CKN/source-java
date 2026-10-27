package thide2;

import java.util.Objects;

public class Subject {
	private String idMH, nameMH;
	private int soTinChi;

	public Subject(String idMH, String nameMH, int soTinChi) {
		super();
		this.idMH = idMH;
		this.nameMH = nameMH;
		this.soTinChi = soTinChi;
	}

	@Override
	public String toString() {
		return "Subject: Ma mon hoc " + idMH + ", ten mon hoc " + nameMH + ", so tin " + soTinChi;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(idMH, other.idMH) || Objects.equals(nameMH, other.nameMH) || soTinChi == other.soTinChi;
	}

	public String getIdMH() {
		return idMH;
	}

	public String getNameMH() {
		return nameMH;
	}

	public int getSoTinChi() {
		return soTinChi;
	}
}
