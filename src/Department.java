public class Department {
    //thuộc tính
    private String maBoPhan;
    private String tenBoPhan;
    private int soNv;
    //Contructor
        public Department(String maBoPhan, String tenBoPhan, int soNv){
            this.maBoPhan=maBoPhan;
            this.tenBoPhan=tenBoPhan;
            this.soNv=soNv;
        }
        public Department(){

        };
    // getter
    public String getMaBoPhan() {
        return maBoPhan;
    }
    public int getSoNv() {
        return soNv;
    }
    public String getTenBoPhan() {
        return tenBoPhan;
    }

    //setter
    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }
    public void setSoNv(int soNv) {
        this.soNv = soNv;
    }
    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    //Method
    public String toString(){
        return "Mã bộ phận: "+maBoPhan+ ", Bộ phận: "+tenBoPhan+", Số nhân viên: "+soNv;
    }
}
