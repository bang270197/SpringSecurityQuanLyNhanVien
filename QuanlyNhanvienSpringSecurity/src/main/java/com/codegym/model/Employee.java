package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Size(min = 4,max = 30)
//    @NotNull
    private String MaNv;
//    @Size(min = 4,max = 30)
//    @NotNull
    private String HoTen;
//    @Size(min = 2,max = 3)
//    @NotNull
    private String GioiTinh;
//    @Pattern(regexp = "^0[98]{1}\\d{9}$",message = "Sai dinh dang ")
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "GroupMember_id")
    private GroupMembers groupMembers;

    public Employee() {
    }

//    public Employee(@Size(min = 4, max = 30) @NotNull String maNv, @Size(min = 4, max = 30) @NotNull String hoTen, @Size(min = 2, max = 3) @NotNull String gioiTinh, @Pattern(regexp = "^0[98]{1}\\d{9}$", message = "Sai dinh dang ") String sdt) {
//        MaNv = maNv;
//        HoTen = hoTen;
//        GioiTinh = gioiTinh;
//        this.sdt = sdt;
//    }


    public Employee(String maNv, String hoTen, String gioiTinh, String sdt, GroupMembers groupMembers) {
        MaNv = maNv;
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        this.sdt = sdt;
        this.groupMembers = groupMembers;
    }

    public GroupMembers getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(GroupMembers groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String maNv) {
        MaNv = maNv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
