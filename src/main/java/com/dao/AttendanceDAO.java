
package com.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.*;
import java.sql.ResultSet;

import com.dao.*;
import com.entity.*;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class AttendanceDAO {

	private Connection conn;

	public AttendanceDAO(Connection conn) {
			super();
			this.conn = conn;
		}

	public boolean addStudent(String name, String status) {
		boolean f = false;

		try {
			String sql = "insert into attendance_app1(name,status) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, status);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;

	}

	public List<AttendanceDetails> getAttendance() {
		List<AttendanceDetails> list = new ArrayList<AttendanceDetails>();
		AttendanceDetails t = null;

		try {
			String sql = "select * from attendance_app1 ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				t = new AttendanceDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setStatus(rs.getString(3));
				list.add(t);

			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

		return list;
	}

	public AttendanceDetails getAttendanceid(int id) {

		AttendanceDetails t = null;

		try {
			String sql = "select * from Attendance_app1 where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				t = new AttendanceDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setStatus(rs.getString(3));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return t;

	}

	public boolean updateAttendance(AttendanceDetails t) {
		boolean f = false;
		try {
			String sql = "update attendance_app1 set name=?,status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getStatus());
			ps.setInt(3, t.getId());

			int i = ps.executeUpdate();

			if (i == 1) {

				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;

	}

	public boolean deleteAttendance(int id) {

		boolean f = false;

		try {

			String sql = "delete from attendance_app1 where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {

				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;

	}

}
