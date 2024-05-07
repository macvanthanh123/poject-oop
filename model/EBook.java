package model;

public class EBook extends Book{
	private String dinh_dang_file;
	private int kich_thuoc_file;
	public EBook(int id, String tieu_de, String tac_gia, int namxb, String dinh_dang_file, int kich_thuoc_file) {
		super(id, tieu_de, tac_gia, namxb);
		this.dinh_dang_file = dinh_dang_file;
		this.kich_thuoc_file = kich_thuoc_file;
	}
	@Override
	public String toString() {
		return "id:" + getId() + ", tac_gia:" + getTac_gia() + ", tieu_de:" + getTieu_de() + ", namxb:" + getNamxb() + ", dinh_dang_file:" + dinh_dang_file + ", kich_thuoc_file:" + kich_thuoc_file;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new EBook(12,"thanh","hehe",45,"pdf",67));
	}
}
