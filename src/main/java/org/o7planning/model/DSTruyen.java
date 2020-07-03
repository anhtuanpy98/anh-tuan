package org.o7planning.model;

import java.util.Arrays;

import org.o7planning.model.CTTruyens;


public class DSTruyen {
	private String		TENTRUYEN, TENTACGIA, HINH, DeleteFlag;
	private String			MATRUYEN;
	private CTTruyens[]		CTTruyens;
	
	public DSTruyen() {
		
	}

	public DSTruyen(String tENTRUYEN, String tENTACGIA, String hINH, String deleteFlag, String mATRUYEN,
			org.o7planning.model.CTTruyens[] cTTruyens) {
		super();
		TENTRUYEN = tENTRUYEN;
		TENTACGIA = tENTACGIA;
		HINH = hINH;
		DeleteFlag = deleteFlag;
		MATRUYEN = mATRUYEN;
		CTTruyens = cTTruyens;
	}

	public String getTENTRUYEN() {
		return TENTRUYEN;
	}

	public void setTENTRUYEN(String tENTRUYEN) {
		TENTRUYEN = tENTRUYEN;
	}

	public String getTENTACGIA() {
		return TENTACGIA;
	}

	public void setTENTACGIA(String tENTACGIA) {
		TENTACGIA = tENTACGIA;
	}

	public String getHINH() {
		return HINH;
	}

	public void setHINH(String hINH) {
		HINH = hINH;
	}

	public String getDeleteFlag() {
		return DeleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		DeleteFlag = deleteFlag;
	}

	public String getMATRUYEN() {
		return MATRUYEN;
	}

	public void setMATRUYEN(String mATRUYEN) {
		MATRUYEN = mATRUYEN;
	}

	public CTTruyens[] getCTTruyens() {
		return CTTruyens;
	}

	public void setCTTruyens(CTTruyens[] cTTruyens) {
		CTTruyens = cTTruyens;
	}

	@Override
	public String toString() {
		return "DSTruyen [TENTRUYEN=" + TENTRUYEN + ", TENTACGIA=" + TENTACGIA + ", HINH=" + HINH + ", DeleteFlag="
				+ DeleteFlag + ", MATRUYEN=" + MATRUYEN + ", CTTruyens=" + Arrays.toString(CTTruyens) + "]";
	}

}
