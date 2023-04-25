package com.testingshastra.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.testingshastra.utilities.ExcelUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	int x, y, r = 0; // Instance Variables
	String s,uname,pass;
	@Given("I have numbers {int} and {int}")
	public void acceptTwoNumbers(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@When("I add them")
	public void addNumbers() {
		r = x + y;
	}
	
	@Then("Check if its addition is prime")
	public void isPrime() {
		int count = 0;
		for (int i = 1; i < 11; i++) {
			if(r%i==0) {
				count++;
			}
		}
		
		if(count>2) {
			System.out.println("Number is not prime");
		}else {
			System.out.println("Number is Prime");
		}
	}
	
	@Given("I have a string {string}")
	public void acceptString(String s) {
		this.s = s;
	}
	
	@Then("Print this string on console")
	public void printString() {
		System.out.println("String: "+s);
	}
	
	@Given("I have numbers as follow:")
	public void acceptListOfNumbers(DataTable table) {
		Map<Integer,List> map = table.asMap(Integer.class, List.class);
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			List<String> nums = map.get(key);
			for (String num : nums) {
				System.out.print(Integer.parseInt(num)+",");
			}
			System.out.println();
		}
	}
	
	@Given("I have {word} and {word}")
	public void acceptUserNameAndPassword(String uname, String pass) {
		this.uname = uname;
		this.pass = pass;
	}
	
	@Then("Print them")
	public void printunameAndPass() {
		System.out.println("Username: "+uname+"\t"+"Password: "+pass);
	}
	
	@Given("I have username and password from {int}")
	public void readUsernameAndPassFromExcel(int rowNum) {
		ExcelUtil excel = new ExcelUtil();
		List rowData = excel.getRowFromExcel("/Users/avinashpingale/Documents/Peony22A/UserData.xlsx", "credentials", rowNum);
		rowData.remove(0);
		this.uname = (String) rowData.get(0);
		this.pass = (String) rowData.get(1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
