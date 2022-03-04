package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Testing\\TapanTest.xlsx");
	
	public String Firstname = d.getCellData("Data1", "Firstname", 2);
	public String Lastname = d.getCellData("Data1", "Lastname", 2);
	public String Password = d.getCellData("Data1", "Password", 2);
	public String Address = d.getCellData("Data1", "Address", 2);
	public String City = d.getCellData("Data1", "City", 2);
	public String Idstate = d.getCellData("Data1", "Idstate", 2);
	//public String PostalCode = d.getCellData("Data1", "PostalCode", 2);
	public String Idcountry = d.getCellData("Data1", "Idcountry", 2);
	//public String Contact = d.getCellData("Data1", "Contact", 2);

}
