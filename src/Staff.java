public abstract class Staff {
    //thuộc tính
    private String maNv;
    private String tenNv;
    private int tuoiNv;
    private double heSoLuong;
    private String ngayVaoLam;
    private Department boPhan;
    private int ngayNghiPhep;
    private double salary;
    //Contructor
    public Staff(String maNv, String tenNv, int tuoiNv, double heSoLuong, String ngayVaoLam, int ngayNghiPhep, Department boPhan){
        this.maNv=maNv;
        this.tenNv=tenNv;
        this.tuoiNv=tuoiNv;
        this.heSoLuong=heSoLuong;
        this.ngayVaoLam=ngayVaoLam;
        this.ngayNghiPhep=ngayNghiPhep;
        this.boPhan=boPhan;
    }
    //method
    public abstract void displayInformation();
    //getter
    public double getHeSoLuong() {
        return heSoLuong;
    }
    public String getMaNv() {
        return maNv;
    }
    public int getNgayNghiPhep() {
        return ngayNghiPhep;
    }
    public String getNgayVaoLam() {
        return ngayVaoLam;
    }
    public int getTuoiNv() {
        return tuoiNv;
    }
    public String getTenNv() {
        return tenNv;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getBoPhan() {
        return boPhan;
    }

    //setter
    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }
    public void setNgayNghiPhep(int ngayNghiPhep) {
        this.ngayNghiPhep = ngayNghiPhep;
    }
    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }
    public void setTuoiNv(int tuoiNv) {
        this.tuoiNv = tuoiNv;
    }
    public void setBoPhan(Department boPhan) {
        this.boPhan = boPhan;
    }
    public double getSalary() {
        return salary;
    }
}
