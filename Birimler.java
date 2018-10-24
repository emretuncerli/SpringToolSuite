package com.example.vaad;

public class Birimler {
	public Birimler()
	{

		this.BOLUMKODU=BOLUMKODU;
		this.BIRIMKODU=BIRIMKODU;
		this.BIRIMADI=BIRIMADI;
	}
	private String BOLUMKODU="";
	private String BIRIMKODU="";
	private String BIRIMADI="";
	public String getBOLUMKODU() {
		return BOLUMKODU;
	}
	public void setBOLUMKODU(String BOLUMKODU) {
		this.BOLUMKODU = BOLUMKODU;
	}
	public String getBIRIMKODU() {
		return BIRIMKODU;
	}
	public void setBIRIMKODU(String BIRIMKODU) {
		this.BIRIMKODU = BIRIMKODU;
	}
	public String getBIRIMADI() {
		return BIRIMADI;
	}
	public void setBIRIMADI(String BIRIMADI) {
		this.BIRIMADI = BIRIMADI;
	}

	public Birimler clone() throws CloneNotSupportedException {
		return (Birimler ) super.clone();
	}

}
