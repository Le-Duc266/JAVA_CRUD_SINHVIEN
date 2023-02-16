package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    private Connection connection;

    public SinhVienDAO(Connection connection) {
        this.connection = connection;
    }


    // Lấy ra danh sách sinh vien
    public List<SinhVien> getALl() {
        List<SinhVien> result;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students order by code asc");
            result= showInfor(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    // sắp xep theo tuổi
    public List<SinhVien> sortByAge() {
        List<SinhVien> result;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students ORDER BY age DESC ");
            result= showInfor(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    // inert
    public void insert(SinhVien svien) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "insert into students(code,name,phone,address,created_at,updated_at,age) " +
                    "values(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, svien.getCode());
            preparedStatement.setString(2, svien.getName());
            preparedStatement.setString(3, svien.getPhone());
            preparedStatement.setString(4, svien.getAddress());
            preparedStatement.setDate(5, new Date(svien.getCreated_at().getTime()));
            preparedStatement.setDate(6, new Date(svien.getUpdated_at().getTime()));
            preparedStatement.setInt(7, svien.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // update thong tin sinh vien
    public void update(SinhVien svien) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update students set code=?,name =?,phone=?,address=?,created_at=?,updated_at=?, age=? where id=?");
            preparedStatement.setString(1, svien.getCode());
            preparedStatement.setString(2, svien.getName());
            preparedStatement.setString(3, svien.getPhone());
            preparedStatement.setString(4, svien.getAddress());
            preparedStatement.setDate(5, new Date(svien.getCreated_at().getTime()));
            preparedStatement.setDate(6, new Date(svien.getUpdated_at().getTime()));
            preparedStatement.setInt(7, svien.getAge());
            preparedStatement.setInt(8, svien.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // xóa sinh viên
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<SinhVien> getByName(String name) {
        List<SinhVien> result;
        try {

            // tìm kiem theo
            PreparedStatement preparedStatement = connection.prepareStatement("select * from students where  name like ?");

            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            result= showInfor(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  result;
    }

    public List<SinhVien> showInfor(ResultSet resultSet){
        List<SinhVien> result = new ArrayList<SinhVien>();
        try {
            while (resultSet.next()) {
                SinhVien svien = new SinhVien(resultSet.getInt("id"), resultSet.getString("code"), resultSet.getString("name"), resultSet.getString("phone"), resultSet.getString("address"), resultSet.getDate("created_at"), resultSet.getDate("updated_at"), resultSet.getInt("age"));
                result.add(svien);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


}
