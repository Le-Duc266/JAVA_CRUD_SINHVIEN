package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<SinhVien> students = new ArrayList<>();
        SinhVienDAO svdao = new SinhVienDAO(DatabaseConnection.getConnection());
        do {
            System.out.println("--------Menu---------");
            System.out.println("1. Danh sách sinh vien.");
            System.out.println("2. Thêm mới sinh vien. ");
            System.out.println("3. Sửa thông tin sinh viên.");
            System.out.println("4. Xoa sinh viên");
            System.out.println("5. Tìm kiếm sinh viên");
            System.out.println("6. Sắp xếp giảm dần theo tuổi");
            System.out.println("7. Thoat");
            System.out.println("+++++++++++++++++++++");
            System.out.println("Moi ban chon: ");
            Scanner sc = new Scanner(System.in);
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.println("Danh sách sinh viên");
                    students = svdao.getALl();
                    students.forEach(student -> student.display());
                    break;
                case 2:
                    SinhVien sv = new SinhVien();
                    sv.input();
                    svdao.insert(sv);
                    break;
                case 3:
                    System.out.println("nhap id sinh vien muon sua: ");
                    int id = Integer.parseInt(sc.nextLine());
                    for (SinhVien st : students) {
                        if (st.getId() == id) {
                            st.input();
                            svdao.update(st);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhap ma sinh vien muon xoa: ");
                    id = Integer.parseInt(sc.nextLine());
                    svdao.delete(id);
                    System.out.println("Xóa thành công");
                    break;

                case 5:
                    System.out.println("Nhap ten hoặc địa chỉ sinh vien muon tim kiem: ");
                    String search = sc.nextLine();
                    List<SinhVien> rs = svdao.getByName(search);
                    if (rs.size() > 0) {
                        System.out.println("Sinh vien tim thay: ");
                        for (SinhVien st : rs) {
                            st.display();
                        }
                    } else {
                        System.out.println("khong tim thay sinh vien ");
                    }
                    break;
                case 6:
                    System.out.println("Danh sach sau khi sap xep giam dan theo tuoi: ");
                    students = svdao.sortByAge();
                    students.forEach(student -> student.display());
                    break;

                case 7:
                    System.out.println("Ban da thoat chuong trinh");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Moi ban chon tu 1 den 7");
                    break;

            }
        } while (true);
    }
}