package org.jsp.hospital.controller;
import java.util.List;
import java.util.Scanner;

import org.jsp.hospital.dao.AdminDao;
import org.jsp.hospital.dao.HospitalDao;
import org.jsp.hospital.dto.Admin;
import org.jsp.hospital.dto.Hospital;

public class AdminHospitalController {
	static AdminDao adminDao = new AdminDao();
	static HospitalDao hospitalDao = new HospitalDao();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("1.Save Admin");
		System.out.println("2.Update Admin");
		System.out.println("3.Find Admin By Id");
		System.out.println("4.Verify Admin by phone and password");
		System.out.println("5.Verify Admin by email and password");
		System.out.println("6.Add Hospital");
		System.out.println("7.Update Hospital");
		System.out.println("8.Find Hospitals By Admin Id");
		System.out.println("9.Find Hospitals By Admin Phone and password");
		System.out.println("10.Find Hospitals By Admin email and password");
		switch (s.nextInt()) {
		case 1: {
			save();
			break;
		}
		case 2: {
			update();
			break;
		}
		case 3: {
			findById();
			break;
		}
		case 4: {
			verifyByPhone();
			break;
		}
		case 5: {
			verifyByEmail();
			break;
		}
		case 6: {
			saveHospital();
			break;
		}
		case 7: {
			updateHospital();
			break;
		}
		case 8: {
			findHospitalsByAdminId();
			break;
		}
		case 9: {
			findHospitalsByAdminPhonePassword();
			break;
		}
		case 10: {
			findHospitalsByAdminEmailPassword();
			break;
		}
		default: {
			System.err.println("Invalid Choice");
		}
		}
	}

	public static void save() {
		System.out.println("Enter the name,phone,email and password to register");
		Admin admin = new Admin();
		admin.setName(s.next());
		admin.setPhone(s.nextLong());
		admin.setEmail(s.next());
		admin.setPassword(s.next());
		admin = adminDao.saveAmin(admin);
		System.out.println("Admin registered with Id:" + admin.getId());

	}

	public static void update() {
		System.out.println("Enter the Admin Id to update");
		int id = s.nextInt();
		System.out.println("Enter the name,phone,email and password to register");
		Admin admin = new Admin();
		admin.setId(id);
		admin.setName(s.next());
		admin.setPhone(s.nextLong());
		admin.setEmail(s.next());
		admin.setPassword(s.next());
		admin = adminDao.updateAdmin(admin);
		if (admin != null)
			System.out.println("Admin  with Id:" + admin.getId() + " is updated");
		else
			System.err.println("Cannot Update Admin as the entered Id is Invalid");
	}

	public static void findById() {
		System.out.println("Enter the Admin Id to display details");
		int id = s.nextInt();
		Admin admin = adminDao.findById(id);
		if (admin != null) {
			System.out.println("Verification Succesfull");
			System.out.println("Admin Id:" + admin.getId());
			System.out.println("Name:" + admin.getName());
			System.out.println("Phone Number:" + admin.getPhone());
			System.out.println("Email Id:" + admin.getEmail());
		} else {
			System.err.println("Invalid Id");
		}
	}

	public static void verifyByPhone() {
		System.out.println("Enter the Phone and password to verify Admin");
		long phone = s.nextLong();
		String password = s.next();
		Admin admin = adminDao.verify(phone, password);
		if (admin != null) {
			System.out.println("Verification Succesfull");
			System.out.println("Admin Id:" + admin.getId());
			System.out.println("Name:" + admin.getName());
			System.out.println("Phone Number:" + admin.getPhone());
			System.out.println("Email Id:" + admin.getEmail());
		} else {
			System.err.println("Invalid Phone Number or Password");
		}
	}

	public static void verifyByEmail() {
		System.out.println("Enter the Email Id and password to verify Admin");
		String email = s.next();
		String password = s.next();
		Admin admin = adminDao.verify(email, password);
		if (admin != null) {
			System.out.println("Verification Succesfull");
			System.out.println("Admin Id:" + admin.getId());
			System.out.println("Name:" + admin.getName());
			System.out.println("Phone Number:" + admin.getPhone());
			System.out.println("Email Id:" + admin.getEmail());
		} else {
			System.err.println("Invalid Email id  or Password");
		}
	}

	public static void saveHospital() {
		System.out.println("Enter the Admin Id to add Hospital");
		int admin_id = s.nextInt();
		System.out.println("Enter the name,founder,gst number and year of establsihment to add Hospital");
		Hospital h = new Hospital();
		h.setName(s.next());
		h.setFounder(s.next());
		h.setGst_number(s.next());
		h.setYear_of_estb(s.nextInt());
		h = hospitalDao.saveHospital(h, admin_id);
		if (h != null)
			System.out.println("Hospital saved with Id:" + h.getId());
		else
			System.err.println("Cannot add hospital as Admin Id is Invalid");
	}

	public static void updateHospital() {
		System.out.println("Enter the Hospital Id to update");
		int id = s.nextInt();
		System.out.println("Enter the name,founder,gst number and year of establsihment to add Hospital");
		Hospital h = new Hospital();
		h.setId(id);
		h.setName(s.next());
		h.setFounder(s.next());
		h.setGst_number(s.next());
		h.setYear_of_estb(s.nextInt());
		h = hospitalDao.updateHospital(h);
		if (h != null)
			System.out.println("Hospital  with Id:" + h.getId() + " updated");
		else
			System.err.println("Cannot update hospital as  Id is Invalid");
	}

	public static void findHospitalsByAdminPhonePassword() {
		System.out.println("Enter the Admin Phone and password to find Hospitals");
		long phone = s.nextLong();
		String password = s.next();
		List<Hospital> hospitals = hospitalDao.findHospitalsByAdminPhonePassword(phone, password);
		if (hospitals.size() > 0) {
			for (Hospital h : hospitals) {
				System.out.println("Hospital Id:" + h.getId());
				System.out.println("Hospital Name:" + h.getName());
				System.out.println("Founder:" + h.getFounder());
				System.out.println("GST Number:" + h.getGst_number());
				System.out.println("Year of establishment:" + h.getYear_of_estb());
				System.out.println("_------------------------------");
			}
		} else {
			System.err.println("Invalid Phone Number or Password");
		}
	}

	public static void findHospitalsByAdminEmailPassword() {
		System.out.println("Enter the Admin Email Id and password to find Hospitals");
		String email = s.next();
		String password = s.next();
		List<Hospital> hospitals = hospitalDao.findHospitalsByAdminEmailPassword(email, password);
		if (hospitals.size() > 0) {
			for (Hospital h : hospitals) {
				System.out.println("Hospital Id:" + h.getId());
				System.out.println("Hospital Name:" + h.getName());
				System.out.println("Founder:" + h.getFounder());
				System.out.println("GST Number:" + h.getGst_number());
				System.out.println("Year of establishment:" + h.getYear_of_estb());
				System.out.println("_------------------------------");
			}
		} else {
			System.err.println("Invalid Email Id or Password");
		}
	}

	public static void findHospitalsByAdminId() {
		System.out.println("Enter the Admin Id to find Hospitals");
		int admin_id = s.nextInt();
		List<Hospital> hospitals = hospitalDao.findHospitalsByAdminId(admin_id);
		if (hospitals.size() > 0) {
			for (Hospital h : hospitals) {
				System.out.println("Hospital Id:" + h.getId());
				System.out.println("Hospital Name:" + h.getName());
				System.out.println("Founder:" + h.getFounder());
				System.out.println("GST Number:" + h.getGst_number());
				System.out.println("Year of establishment:" + h.getYear_of_estb());
				System.out.println("_------------------------------");
			}
		} else {
			System.err.println("Invalid Admin Id");
		}
	}

}
