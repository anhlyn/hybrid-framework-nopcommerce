package com.nopcommerce.frontend;

import java.util.HashMap;

import com.github.javafaker.Faker;

public class DataTest {
	
	public String orderNumber = "";
	
	public class RegisteredAccount{
		
		Faker faker = new Faker();
		public String firstName = this.faker.name().firstName();
		public String lastName = this.faker.name().lastName();
		public String email = this.faker.bothify("????####@????.com");
		public String password = this.faker.bothify("????????");
		public String confirmPassword = password;
		
	}
	
	public class CustomerInfo{
		public String gender = "F";
		public String firstName = "Automation";
		public String lastName = "FC";
		public String birthDay = "1";
		public String birthMonth = "January";
		public String birthYear = "1999";
		public String email = "automationfc.vn@gmail.com";
		public String company = "Automation FC";
	}
	
	public class Address{
		public String firstName = "Automation";
		public String lastName = "FC";
		public String email = "automationfc.vn@gmail.com";
		public String company = "Automation FC";
		public String country = "Viet Nam";
		public String city = "Da Nang";
		public String address1 = "123/04 Le Lai";
		public String address2 = "234/05 Hai Phong";
		public String zip = "550000";
		public String phone = "0123456789";
		public String fax = "0987654321";
		
	}
	
	public class Billing{
		Faker faker = new Faker();
		public String firstName = this.faker.name().firstName();
		public String lastName = this.faker.name().lastName();
		public String email = this.faker.bothify("????####@????.com");
		public String country = "Viet Nam";
		public String city = "HCM";
		public String address1 = this.faker.address().fullAddress();
		public String zip = "700000";
		public String phone = this.faker.phoneNumber().cellPhone();
		
		public HashMap<String, String> convertToHashMap(){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("firstname", this.firstName);
			map.put("lastname", this.lastName);
			map.put("email", this.email);
			map.put("country", this.country);
			map.put("city", this.city);
			map.put("address1", this.address1);
			map.put("zip", this.zip);
			map.put("phone", this.phone);
			return map;
		}
	}
	
	public class Shipping{
		Faker faker = new Faker();
		public String firstName = this.faker.name().firstName();
		public String lastName = this.faker.name().lastName();
		public String email = this.faker.bothify("????####@????.com");
		public String country = "Viet Nam";
		public String city = "HCM";
		public String address1 = this.faker.address().fullAddress();
		public String zip = "700000";
		public String phone = this.faker.phoneNumber().cellPhone();
		public String method = "Next Day Air ($0.00)";
		
		public HashMap<String, String> convertToHashMap(){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("firstname", this.firstName);
			map.put("lastname", this.lastName);
			map.put("email", this.email);
			map.put("country", this.country);
			map.put("city", this.city);
			map.put("address1", this.address1);
			map.put("zip", this.zip);
			map.put("phone", this.phone);
			return map;
		}
	}
	
	public class Payment{
		Faker faker = new Faker();
		public String method = "Check / Money Order";
		public String creditType = "Master card";
		public String creditHolderName = "LUNAR NEWYEAR";
		public String creditNumber = "5437224343719934";
		public String creditExpiredMonth = "01";
		public String creditExpiredYear = "2023";
		public String creditCode = "123";
		public HashMap<String, String> convertToHashMap(){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("credittype", this.creditType);
			map.put("holdername", this.creditHolderName);
			map.put("cardnumber", this.creditNumber);
			map.put("expiredmonth", this.creditExpiredMonth);
			map.put("expiredyear", this.creditExpiredYear);
			map.put("cardcode", this.creditCode);
			return map;
		}
	}
	
}
