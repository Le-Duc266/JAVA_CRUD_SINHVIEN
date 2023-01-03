package org.example;

import java.util.List;
import java.util.Scanner;

public class Validate {

    // check trùng mã code
    public String checkCodeExit(String code){
        String _code = code;
        SinhVienDAO stdao = new SinhVienDAO(DatabaseConnection.getConnection());
        Scanner sc = new Scanner(System.in);
        List<SinhVien> sv= stdao.getALl();
        for (int i =0; i<sv.size();i++){
            while (sv.get(i).getCode().equals(_code)){
                System.out.println("Mã bị trùng");
                System.out.println("Nhập mã code sinh vien: ");
                _code = sc.nextLine();
            }
        }
        return _code;
    }
}
