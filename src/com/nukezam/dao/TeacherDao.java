package com.nukezam.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDao {
	
	public String getCource() throws SQLException {
		Statement stmt = null;
		Connection con = null;
		Dbutil dbutil = new Dbutil();
		ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名称</th><th>授课教师</th><th>教室</th><th>上课时间</th></tr>";

		try{
			con = dbutil.getCon();
			stmt = con.createStatement();
            String sql = "select cource_id, cource_name, name, location, schooltime from cource, user, classroom where teacher=user_id and classroom=classroom_id" + ";";
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("location") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "</tr>";

            }
            return str + "</table>";
		}catch (Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
//TODO
}
