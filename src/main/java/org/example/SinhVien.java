package org.example;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SinhVien {
    private int id;
    private String code;
    private String name;
    private String phone;
    private String address;
    private Date created_at;
    private Date updated_at;
    private int age;

    public SinhVien() {
    }

    public SinhVien(int id, String code, String name, String phone, String address, Date created_at, Date updated_at, int age) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.age = age;
    }

    public SinhVien(String code, String name, String phone, String address, Date created_at, Date updated_at, int age) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // nhập thông tin
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã code sinh viên:");
        String _code = sc.nextLine();
        Validate validate = new Validate();
        code = validate.checkCodeExit(_code);
        validateName();
        System.out.println("Nhập số điện thoại sinh viên:");
        phone = sc.nextLine();
        System.out.println("Nhập địa chỉ sinh viên:");
        address = sc.nextLine();
        created_at = new java.util.Date();
        updated_at = new java.util.Date();
        validateAge();
    }

    public void display() {
        System.out.println("Ma sinh vien: " + getId());
        System.out.println("Ma codde sinh vien: " + getCode());
        System.out.println("Ten sinh vien: " + getName());
        System.out.println("Tuoi sinh vien: " + getAge());
        System.out.println("Số điện thoại: " + getPhone());
        System.out.println("Địa chỉ: " + getAddress());
        System.out.println("----------------------");
    }

    public void validateName() {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-zA-z ]{1,15}$");
        while (true) {
            System.out.println("Nhập tên sinh viên:");
            name = sc.nextLine();
            if (pattern.matcher(name).find()) {
                break;
            } else {
                System.out.println("Ten khong co ki tu dac biet");
            }
        }
    }

    public void validateAge() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhap tuoi sinh vien");
                age = Integer.parseInt(sc.nextLine());
                if (age > 0) {
                    break;
                } else {
                    System.out.println("Tuoi phai la so duong");
                }
            } catch (Exception e) {
                System.out.println("Tuoi sinh vien phai la so");
            }
        }
    }


}
