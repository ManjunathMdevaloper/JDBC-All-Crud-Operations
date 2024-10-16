package org.jsp;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class HospitalManagementApp 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		while(true)
		{
			System.out.println("Select the Options");
			System.out.println("1) Register a new Patient ");
			System.out.println("2) Update disease info by id");
			System.out.println("3) Update the age by phone no");
			System.out.println("4) View all patient Records");
			System.out.println("5) View patient by phone number");
			System.out.println("6) Search by patients by disease");
			System.out.println("7) Search patient by name");
			System.out.println("8) Delete a patient record by phone number And name");
			System.out.println("9) Exit");
			switch (sc.nextInt()) {
			case 1:
				registerPatient();
				break;
			case 2:
				updateDiseaseById();
				break;
			case 3:
				updateAgeByPhoneNo();
				break;
			case 4:
				viewAllRecords();
				break;
			case 5:
				viewPatientByPhoneNo();
				break;
			case 6:
				searchPatientByDisease();
				break;
			case 7:
				searchPatientByName();
				break;
			case 8:
				deletePatientByPhoneNo();
				break;
			case 9:
				System.out.println("*********Thank you**********");
				System.exit(0);
				break;
			default:System.out.println("Invalid input");
				break;
			}
		}
	}
	 private static void deletePatientByPhoneNo() {
		 System.out.println("Enter phone no");
		 long phoneNum = sc.nextLong();
		 Connection con = null;
		 PreparedStatement ps = null;
//		 Statement s= null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Manu@9965");
				ps = con.prepareStatement("delete from patient where phone=?");
//				s = con.createStatement();
				ps.setLong(1, phoneNum);
				int row = ps.executeUpdate();
				System.out.println(row+" Row deleted...");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
	private static void searchPatientByName() {
		 System.out.println("Enter Name");
		 String name = sc.next();
		 Connection con = null;
		 PreparedStatement ps =null;
		 ResultSet rs=null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Manu@9965");
				ps = con.prepareStatement("select * from patient where name=?");
				ps.setString(1, name);
				rs = ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getLong(4)+"\t"+rs.getString(5)+"\t"+rs.getDate(6));
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs != null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
	}
	private static void searchPatientByDisease() {
		 System.out.println("Enter Disease");
		 String disease = sc.next();
		 Connection con = null;
		 PreparedStatement ps =null;
		 ResultSet rs=null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Manu@9965");
				ps = con.prepareStatement("select * from patient where disease=?");
				ps.setString(1, disease);
				rs = ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getLong(4)+"\t"+rs.getString(5)+"\t"+rs.getDate(6));
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs != null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			}
	
	private static void viewPatientByPhoneNo() {
		 System.out.println("Enter phone number");
		 long phoneNo = sc.nextLong();
		 Connection con = null;
		 PreparedStatement ps =null;
		 ResultSet rs=null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Manu@9965");
				ps = con.prepareStatement("select * from patient where phone=?");
				ps.setLong(1, phoneNo);
				rs = ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getLong(4)+"\t"+rs.getString(5)+"\t"+rs.getDate(6));
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs != null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			}
	
	private static void viewAllRecords() {
		 Connection con = null;
		 PreparedStatement ps =null;
		 ResultSet rs=null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Manu@9965");
				ps = con.prepareStatement("select * from patient");
				rs = ps.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getLong(4)+"\t"+rs.getString(5)+"\t"+rs.getDate(6));
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs != null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		 
	}
	private static void updateAgeByPhoneNo() {
		 System.out.println("Enter phone no");
		 long phoneNum = sc.nextLong();
		 System.out.println("Enter age");
		 int age = sc.nextInt();
		 Connection con = null;
		 PreparedStatement ps = null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Manu@9965");
				ps = con.prepareStatement("update patient set age=? where phone=?");
				ps.setInt(1, age);
				ps.setLong(2, phoneNum);
				int row = ps.executeUpdate();
				System.out.println(row+" Row Updated");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
	private static void updateDiseaseById() {
		 System.out.println("Enter id");
		 int id = sc.nextInt();
		 System.out.println("Enter disease name");
		 String disease = sc.next();
		 Connection con = null;
		 PreparedStatement ps = null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Manu@9965");
				ps = con.prepareStatement("update patient set disease=? where id=?");
				ps.setString(1, disease);
				ps.setInt(2, id);
				int row = ps.executeUpdate();
				System.out.println(row+" Row Updated");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(ps != null)
				{
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con != null)
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
	static void registerPatient() {
		 System.out.println("Enter id");
		 int id = sc.nextInt();
		 System.out.println("Enter name");
		 String name = sc.next();
		 System.out.println("Enter age");
		 int age = sc.nextInt();
		 System.out.println("Enter phone no");
		 long phoneNo = sc.nextLong();
		 System.out.println("Enter disease");
		 String disease = sc.next();
		 System.out.println("Enter adimition Date");
		 String admition = sc.next();
		 Connection con = null;
		PreparedStatement ps = null;		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Manu@9965");
			ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setLong(4, phoneNo);
			ps.setString(5, disease);
			ps.setDate(6, Date.valueOf(admition));
			int row = ps.executeUpdate();
			System.out.println(row+" Row Inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
