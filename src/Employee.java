public class Employee extends Staff implements ICalculator{
    //Thuộc tính
    private int gioLamThem;
    //Contructor
    public Employee(String maNv, String tenNv, int tuoiNv, double heSoLuong, String ngayVaoLam, int ngayNghiPhep,
                    Department boPhan, int gioLamThem){
        super(maNv, tenNv, tuoiNv, heSoLuong, ngayVaoLam, ngayNghiPhep, boPhan);
        this.gioLamThem=gioLamThem;
    }
    //getter


    public int getGioLamThem() {
        return gioLamThem;
    }
    //setter

    public void setGioLamThem(int gioLamThem) {
        this.gioLamThem = gioLamThem;
    }

    //method
    @Override
    public void displayInformation() {
        System.out.println("Mã nhân viên: "+super.getMaNv() +", Tên nhân viên: "+super.getTenNv() +
                ", Tuổi nhân viên: "+super.getTuoiNv()+", Bộ phận: "+super.getBoPhan().getTenBoPhan()+
                ", Hệ số lương: "+super.getHeSoLuong()+ ", Ngày vào làm: "+super.getNgayVaoLam()+
                ", Ngày nghỉ phép: "+super.getNgayNghiPhep()+", Giờ làm thêm: "+this.getGioLamThem());

    }
    @Override
    public double calculateSalary(){
        return super.getHeSoLuong()*3000000+ this.gioLamThem*200000;
    }
}
