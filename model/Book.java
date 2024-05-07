package model;
import java.util.Scanner;
public class Book {
	private String tac_gia,tieu_de;
	private int namxb,id;
	Scanner sc = new Scanner(System.in);
	public Book(int id,String tieu_de,String tac_gia, int namxb){
		this.tac_gia=tac_gia;
		this.id=id;
		this.namxb=namxb;
		this.tieu_de=tieu_de;
	}
	public String getTac_gia() {
		return tac_gia;
	}



	public void setTac_gia(String tac_gia) {
		this.tac_gia = tac_gia;
	}



	public String getTieu_de() {
		return tieu_de;
	}



	public void setTieu_de(String tieu_de) {
		this.tieu_de = tieu_de;
	}



	public int getNamxb() {
		return namxb;
	}



	public void setNamxb(int namxb) {
		this.namxb = namxb;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return tac_gia + ","  + tieu_de + "," + namxb + "," + id;
	}

	public static void main(String[] args) {
		System.out.print(new Book(1,"kkk","thanh",23));
	}
}