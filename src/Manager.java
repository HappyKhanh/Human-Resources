public class Manager extends Staff implements ICalculator{
    //Thuộc tính
    private String chucDanh;

    //Constructor
    public Manager(String maNv, String tenNv, int tuoiNv, double heSoLuong, String ngayVaoLam, int ngayNghiPhep,
                   Department boPhan, String chucDanh){
        super(maNv, tenNv, tuoiNv, heSoLuong, ngayVaoLam, ngayNghiPhep, boPhan);
        this.chucDanh=chucDanh;
    }

    //getter
    public String getChucDanh() {
        return chucDanh;
    }

    //setter
    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    //Hien thi thong tin nhan vien
    @Override
    public void displayInformation() {
        System.out.println("Mã nhân viên: "+super.getMaNv() +", Tên nhân viên: "+super.getTenNv() +
                ", Tuổi nhân viên: "+super.getTuoiNv()+", Bộ phận: "+super.getBoPhan().getTenBoPhan()+
                ", Hệ số lương: "+super.getHeSoLuong()+ ", Ngày vào làm: "+super.getNgayVaoLam()+
                ", Ngày nghỉ phép: "+super.getNgayNghiPhep()+", Chức danh: "+this.chucDanh);
    }
    //Tinh luong nhan vien
    @Override
    public double calculateSalary(){
        int luongTrachNhiem=0;
        if (this.chucDanh=="Business Leader"){
            luongTrachNhiem=8000000;
        }else if (this.chucDanh=="Project Leader"){
            luongTrachNhiem=5000000;
        }if (this.chucDanh=="Technical Leader"){
            luongTrachNhiem=6000000;
        }
        return super.getHeSoLuong()*5000000 + luongTrachNhiem;
    }
}
