package jp.co.drm.ccp.web.presentation.domain;

import com.orangesignal.csv.annotation.CsvColumn;
import com.orangesignal.csv.annotation.CsvEntity;

@CsvEntity(header = true)
public class SubsidiaryDomain {

	@CsvColumn(name = "category")
    private String category;

	@CsvColumn(name = "key")
	private String key;

	@CsvColumn(name = "US")
	private String US;

	@CsvColumn(name = "KR")
	private String KR;

	@CsvColumn(name = "DE")
	private String DE;

	@CsvColumn(name = "TW")
	private String TW;

	@CsvColumn(name = "SG")
	private String SG;

	@CsvColumn(name = "TH")
	private String TH;

	@CsvColumn(name = "IN")
	private String IN;

	@CsvColumn(name = "MY")
	private String MY;

	@CsvColumn(name = "ID")
	private String ID;

	@CsvColumn(name = "CN")
	private String CN;

	@CsvColumn(name = "VN")
	private String VN;

	@CsvColumn(name = "JP")
	private String JP;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUS() {
		return US;
	}

	public void setUS(String uS) {
		US = uS;
	}

	public String getKR() {
		return KR;
	}

	public void setKR(String kR) {
		KR = kR;
	}

	public String getDE() {
		return DE;
	}

	public void setDE(String dE) {
		DE = dE;
	}

	public String getTW() {
		return TW;
	}

	public void setTW(String tW) {
		TW = tW;
	}

	public String getSG() {
		return SG;
	}

	public void setSG(String sG) {
		SG = sG;
	}

	public String getTH() {
		return TH;
	}

	public void setTH(String tH) {
		TH = tH;
	}

	public String getIN() {
		return IN;
	}

	public void setIN(String iN) {
		IN = iN;
	}

	public String getMY() {
		return MY;
	}

	public void setMY(String mY) {
		MY = mY;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCN() {
		return CN;
	}

	public void setCN(String cN) {
		CN = cN;
	}

	public String getVN() {
		return VN;
	}

	public void setVN(String vN) {
		VN = vN;
	}

	public String getJP() {
		return JP;
	}

	public void setJP(String jP) {
		JP = jP;
	}




}
