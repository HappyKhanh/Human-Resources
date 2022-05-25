import java.util.*;

public class HumanResoucres {
    static Scanner sc = new Scanner(System.in);
    static ArrayList <Department> dsBoPhan = new ArrayList<Department>();
    static ArrayList <Staff> dsNhanSu = new ArrayList<Staff>();
    static ArrayList <Staff> dsNhanSuSapXep = new ArrayList<Staff>();

    static boolean flag = true;
    static Department department = new Department();
    public static void main(String[] args) {
        System.out.println("Bạn đang sử dụng ứng dụng quản lý nguồn nhân lực Human Resources");
        do {
            hienThiMenu();
            int functionID = sc.nextInt();
            switch (functionID) {
                case 1:
                    hienThiNhanVien();
                    break;
                case 2:
                    hienThiBoPhan();
                    break;
                case 3:
                    hienThiNhanVienBoPhan();
                    break;
                case 4:
                    themNhanVien();
                    break;
                case 5:
                    timKiemNhanVien();
                    break;
                case 6:
                    hienThiBangLuong(dsNhanSu);
                    break;
                case 7:
                    hienThiBangLuongTangDan();
                    break;
                case 8:
                    hienThiBangLuongGiamDan();
                    break;
                default:
                    flag = false;
                    break;
            }
        } while (flag);
    }
    //method 1: Hiển thị danh sách nhân viên của công ty
    //Dùng vòng lặp duyệt qua mảng, và mỗi phần tử thì dùng phương thức displayInformation() để hiển thị thông tin..
    public static void hienThiNhanVien(){
        for ( int i =0; i<dsNhanSu.size(); i++){
            dsNhanSu.get(i).displayInformation();
        }
    }
    //method:  2 Hiển thị các bộ phận trong công ty
    //Dùng vòng lặp duyệt qua mảng, và mỗi phần tử thì dùng toString() để hiển thị thông tin..
    public static void hienThiBoPhan(){
        for (int i = 0; i< dsBoPhan.size(); i++){
            System.out.println(dsBoPhan.get(i));
        }
    }
    // 3: Hiển thị các nhân viên theo từng bộ phận
    // Duyệt array ds bộphận in ra thông tin bộ phận để người dùng chọn.
    // Duyệt lại array dsNhanSu để in ra thông tin nv ứng với bộ phận đã chọn
    public static void hienThiNhanVienBoPhan() {
        int chonBoPhan;
        do {
            System.out.printf("Chọn 1 bộ phận bạn muốn lấy thông tin nhân viên\n");
            for (int i = 0; i < dsBoPhan.size(); i++) {
                System.out.printf("(%d) %s\n", i + 1, dsBoPhan.get(i).getTenBoPhan());
            }
            chonBoPhan = sc.nextInt();
        }
            while (chonBoPhan > dsBoPhan.size() || chonBoPhan < 0) ;
        System.out.printf("Danh sách nhân viên bộ phận %s:\n",dsBoPhan.get(chonBoPhan-1).getTenBoPhan());
        for (int i =0; i< dsNhanSu.size(); i++){
            if (dsNhanSu.get(i).getBoPhan().getTenBoPhan().equals(dsBoPhan.get(chonBoPhan-1).getTenBoPhan())){
                dsNhanSu.get(i).displayInformation();
            }
        }


    }
    //  4 Thêm nhân viên mới vào công ty
    //Dùng Scanner input để nhập dữ liệu cho Employee rồi chèn vào ArrayList
    public static void themNhanVien(){
        //Validate người dùng chọn kiểu nhân viên
        boolean checkThemNhanVien;
        int kieuThem;
        do {
            checkThemNhanVien =false;
            System.out.println("Bạn muốn thêm kiểu nhân viên nào: (1) Thêm nhân viên thông thường/ " +
                    "(2) Thêm nhân viên là cấp quản lý ");
            kieuThem = sc.nextInt();
            if (kieuThem!= 1&&kieuThem!= 2 ){
                System.out.println("Chọn sai kiểu nhân viên, vui lòng nhập lại: ");
                checkThemNhanVien = true;
            }
        }while (checkThemNhanVien);

        System.out.println("Bạn hãy nhập các thông tin sau: ");
        boolean checkMaNhanVien;
        String maNv;
        //Validate việc nhập thông tin mã nv
        do{checkMaNhanVien=false;
            System.out.print("Mã nhân viên: ");
            maNv= sc.next();
            for (int i=0; i<dsNhanSu.size();i++){
                if (dsNhanSu.get(i).getMaNv().equalsIgnoreCase(maNv)) {
                    checkMaNhanVien =true;
                    System.out.println("Không thể thêm mã nhân viên đã tồn tại. Vui lòng nhập lại");
                }
            }
        }while (checkMaNhanVien);
        System.out.print("Tên nhân viên: ");
        sc.nextLine();
        String tenNv= sc.nextLine();
        System.out.print("Tuổi: ");
        int tuoiNv= sc.nextInt();
        System.out.print("Hệ số lương: ");
        double heSoLuong= sc.nextDouble();
        System.out.print("Ngày vào làm: ");
        String ngayVaoLam= sc.next();
        System.out.print("Ngày nghỉ phép: ");
        int ngayNghiPhep= sc.nextInt();
        System.out.print("Mã bộ phận: ");
        String maBoPhan=sc.next();
        boolean checkMaBoPhan = false;
        //Kiểm tra thông tin bộ phận nhân viên, nếu chưa có thì tạo mới, nếu đã có thì cập nhật lại số nv
        for (int i = 0; i < dsBoPhan.size(); i++) {
            if (dsBoPhan.get(i).getMaBoPhan().equalsIgnoreCase(maBoPhan)) {
                checkMaBoPhan = true;
                dsBoPhan.get(i).setSoNv(dsBoPhan.get(i).getSoNv()+1);
                department = dsBoPhan.get(i);
            }
        }
        if (!checkMaBoPhan) {
        System.out.print("Tên bộ phận: ");
        sc.nextLine();
        String tenBoPhan = sc.nextLine();
        department = new Department(maBoPhan,tenBoPhan,1);
        dsBoPhan.add(department);
        }
        if (kieuThem==1){
            System.out.print("Giờ làm thêm: ");
            int gioLamThem= sc.nextInt();
            dsNhanSu.add(new Employee(maNv, tenNv, tuoiNv, heSoLuong, ngayVaoLam,
             ngayNghiPhep, department, gioLamThem));
            System.out.println("Bạn đã thêm thành công thông tin nhân viên "+tenNv);
        } else {
            String chucDanh = "";
            boolean loop;
            do {
                loop=false;
                System.out.print("Chức danh? (1) Business Leader/ (2) Project Leader / (3) Technical Leader. Chọn: ");
                int maChucDanh = sc.nextInt();
                switch (maChucDanh) {
                    case 1:
                        chucDanh = "Business Leader";
                        break;
                    case 2:
                        chucDanh = "Project Leader";
                        break;
                    case 3:
                        chucDanh = "Technical Leader";
                        break;
                    default:
                        loop=true;
                        break;
                }
            } while (loop);
            dsNhanSu.add(new Manager(maNv, tenNv, tuoiNv, heSoLuong, ngayVaoLam,
                    ngayNghiPhep, department, chucDanh));
            System.out.println("Bạn đã thêm thành công thông tin quản lý " + tenNv);
        }
    }
    //  5 Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
    //Dùng lệnh điều kiện để kiểm tra thông tin nhân viên có tồn tại hay không.
    public static void timKiemNhanVien(){
        System.out.print("Nhập tên hoặc mã nhân viên cần tìm: ");
        sc.nextLine();
        String timKiem = sc.nextLine();
        boolean tonTai =false;
        for (int i =0; i< dsNhanSu.size(); i++) {
            if (dsNhanSu.get(i).getTenNv().contains(timKiem.toLowerCase()) ||
                    dsNhanSu.get(i).getMaNv().toLowerCase().contains(timKiem.toLowerCase())) {
                tonTai = true;
                dsNhanSu.get(i).displayInformation();
            }
        }
            if (!tonTai){
                System.out.println("Nhân viên bạn tìm kiếm không tồn tại");
            }
        }
    //  6 Hiển thị bảng lương của nhân viên toàn công ty
    public static void hienThiBangLuong(ArrayList<Staff> dsNhanSu){
        themThongTinLuong ();
        for (int i=0; i<dsNhanSu.size();i++){
                System.out.printf("Mã nhân viên: %s, Nhân viên: %s, Tổng lương: %.0f\n",dsNhanSu.get(i).getMaNv(),
                        dsNhanSu.get(i).getTenNv(),dsNhanSu.get(i).getSalary());
        }
    }
    //  7 Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
    public static void hienThiBangLuongTangDan(){
        themThongTinLuong ();
        dsNhanSuSapXep = new ArrayList<Staff>(dsNhanSu);
        Collections.sort(dsNhanSuSapXep, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                }else if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        hienThiBangLuong(dsNhanSuSapXep);
    }
    public static void hienThiBangLuongGiamDan(){
        themThongTinLuong ();
        dsNhanSuSapXep = new ArrayList<Staff>(dsNhanSu);
        Collections.sort(dsNhanSuSapXep, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                if (o1.getSalary() < o2.getSalary()) {
                    return 1;
                }else if (o1.getSalary() > o2.getSalary()) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        hienThiBangLuong(dsNhanSuSapXep);
    }
    public static void hienThiMenu(){
        System.out.println();
        System.out.println("Hãy nhập số từ 1 đến 8 để lựa chọn chức năng");
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty  ");
        System.out.println("2. Hiển thị các bộ phận trong công ty ");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận ");
        System.out.println("4. Thêm nhân viên mới vào công ty ");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty ");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần ");
        System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần ");
        System.out.println("Chọn số bất kì nào khác để kết thúc chương trình");
    }
    public static void themThongTinLuong (){
        for (int i=0; i<dsNhanSu.size();i++){
            if (dsNhanSu.get(i) instanceof Employee){
                double salary = (((Employee) dsNhanSu.get(i)).calculateSalary());
                dsNhanSu.get(i).setSalary(salary);
            } else if (dsNhanSu.get(i) instanceof Manager){
                double salary = (((Manager) dsNhanSu.get(i)).calculateSalary());
                dsNhanSu.get(i).setSalary(salary);
            }
        }
    }
}
