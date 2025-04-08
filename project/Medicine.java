
package programming;

public class Medicine {

	private String medicineUniversalName ;
	private String medicineComName ;
	private double manufacYear;
	private double medicineQuantity;
	private double medicinePrice;
	private String reorderLimit;
	private static int medicineNo = 0;
	
	public Medicine() {}
	public Medicine (String medicineUniversalName , String medicineComName , double manufacYear , double medicineQuantity , double medicinePrice , String reorderLimit) {
		this.medicineUniversalName = medicineUniversalName;
		this.medicineComName = medicineComName;
		this.manufacYear = manufacYear ;
		this.medicineQuantity = medicineQuantity;
		this.medicinePrice = medicinePrice;
		this.reorderLimit = reorderLimit;
		
	}
	public void setMedicineUniversalName (String medicineUniversalName) {
		this.medicineUniversalName = medicineUniversalName;
	}
	public String getMedicineUniversalName () {
		return medicineUniversalName ;
	}
	public void setMedicineComName (String medicineComName) {
		this.medicineComName = medicineComName;
	}
	public String getMedicineComName () {
		return medicineComName ;
	}
	public void setManufacYear(double manufacYear) {
		this.manufacYear = manufacYear;
	}
	public double getManufacYear() {
		return manufacYear ;
	}
	public void setMedicineQuantity(double medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}
	public double getMedicineQuantity() {
		return medicineQuantity ;
	}
	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	public double getmedicinePrice() {
		return medicinePrice ;
	}
	public void setReorderLimit(String reorderLimit) {
		this.reorderLimit = reorderLimit;
	}
	public String getReorderLimit() {
		return reorderLimit ;
	}
	public String toString() {
		return "medicineNo: " + medicineNo++ + " |medicineUniversalName: "+ medicineUniversalName + " |medicineComName: "+ medicineComName +" |manufacYear: "+ manufacYear + " |medicineQuantity: "+ medicineQuantity + " |medicinePrice: "+ medicinePrice + " |reorderLimit: "+ reorderLimit;
	}
	
}
