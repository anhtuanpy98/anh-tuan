package org.o7planning.model;

import org.o7planning.model.DSTruyen;

public class CTTruyens {
	private	String		MACT, MATRUYEN, MACHUONG;
	private String	TENCHUONG, NOIDUNG, DeleteFlag;
	
	private DSTruyen		DSTruyen;
	
	public CTTruyens() {
		
	}

	public CTTruyens(String mACT, String mATRUYEN, String mACHUONG, String tENCHUONG, String nOIDUNG,
			String deleteFlag, DSTruyen dsTruyen) {
		super();
		MACT = mACT;
		MATRUYEN = mATRUYEN;
		MACHUONG = mACHUONG;
		TENCHUONG = tENCHUONG;
		NOIDUNG = nOIDUNG;
		DeleteFlag = deleteFlag;
		DSTruyen = dsTruyen;
	}

	public String getMACT() {
		return MACT;
	}

	public void setMACT(String mACT) {
		MACT = mACT;
	}

	public String getMATRUYEN() {
		return MATRUYEN;
	}

	public void setMATRUYEN(String mATRUYEN) {
		MATRUYEN = mATRUYEN;
	}

	public String getMACHUONG() {
		return MACHUONG;
	}

	public void setMACHUONG(String mACHUONG) {
		MACHUONG = mACHUONG;
	}

	public String getTENCHUONG() {
		return TENCHUONG;
	}

	public void setTENCHUONG(String tENCHUONG) {
		TENCHUONG = tENCHUONG;
	}

	public String getNOIDUNG() {
		return NOIDUNG;
	}

	public void setNOIDUNG(String nOIDUNG) {
		NOIDUNG = nOIDUNG;
	}

	public String getDeleteFlag() {
		return DeleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		DeleteFlag = deleteFlag;
	}
	
	

	public DSTruyen getDSTruyen() {
		return DSTruyen;
	}

	public void setDSTruyen(DSTruyen dSTruyen) {
		DSTruyen = dSTruyen;
	}

	@Override
	public String toString() {
		return "CTTruyens [MACT=" + MACT + ", MATRUYEN=" + MATRUYEN + ", MACHUONG=" + MACHUONG + ", TENCHUONG="
				+ TENCHUONG + ", NOIDUNG=" + NOIDUNG + ", DeleteFlag=" + DeleteFlag + ", DSTruyen=" + DSTruyen + "]";
	}

	
}
