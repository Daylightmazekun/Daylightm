package com.nukezam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nukezam.model.ClassRoom;
import com.nukezam.model.Notes;
import com.nukezam.model.UserAdd;

public class AdminDao {
	
	public String getNotes() throws SQLException {
		Statement stmt = null;
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		ResultSet rs = null;
		String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>标题</th><th>开始时间</th><th>结束时间</th><th>公告内容</th></tr>";
		try{
			con = dbutil.getCon();
			stmt = con.createStatement();
			String sql = "select * from notes" + ";";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
                str = str + "<tr>" + "<td>" + rs.getString("title") + "</td>" + "<td>" + rs.getString("start_time") + "</td>" + "<td>" + rs.getString("stop_time") + "</td>" + "<td>" + rs.getString("description") + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">编辑</button></td>" +
                        "<td><form action=\"../deletenotes\" method=\"post\"><input name=\"notes_id\" type=\"hidden\" value=\"" + rs.getString("notes_id") + "\"/><button type=\"button\" class=\"btn btn-danger\">删除</button></form></td>" + "</tr>";

			}
			return str + "</table>";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
        	if(con != null){
        		con.close();
        	}
        }
	return str;
	}
	
	public String getCourse() throws SQLException {
		Statement stmt = null;
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名称</th><th>学分</th><th>教师</th><th>上课时间</th><th>上课地点</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, name, schooltime, location from score, user, cource, classroom where teacher=user_id and cource=cource_id and classroom=classroom_id" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "<td>" + rs.getString("location") + "</td>" +
                        "<td><button type=\"button\" class=\"btn btn-success\">编辑</button></td>" +
                        "<td><form action=\"../deletecource\" method=\"post\"><input name=\"cource_id\" type=\"hidden\" value=\"" + rs.getString("cource_id") + "\"/><button type=\"button\" class=\"btn btn-danger\">删除</button></form></td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	if(con != null){
        		con.close();
        	}
        }
        
        return str;
    }
	
	
	public String getScourse() throws SQLException {
		
		Statement stmt = null;
		Dbutil dbutil = new Dbutil();
		Connection con = null;
		ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名称</th><th>学分</th><th>学号</th><th>学生姓名</th><th>上课时间</th><th>上课地点</th></tr>";
        try{
        	con = dbutil.getCon();
        	stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, school_num, name, schooltime, location from score, user, cource, classroom where student=user_id and cource=cource_id and classroom=classroom_id" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "<td>" + rs.getString("location") + "</td>" + "</tr>";
            }
            return str + "</table>";
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(con != null){
        		con.close();
        	}
        }
        return str;
        
	}
	//get score
    public String getScore() throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名</th><th>学分</th><th>学号</th><th>姓名</th><th>平时成绩</th><th>期末成绩</th><th>最终成绩</th></tr>";
        try {
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, school_num, name, pingshi_score, qimo_score, final_score from score, user, cource where student=user_id and cource=cource_id" + ";";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("pingshi_score") + "</td>" + "<td>" + rs.getString("qimo_score") + "</td>" + "<td>" + rs.getString("final_score") + "</td>" + "</tr>";
            }
            return str + "</table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    public Notes notesadd(Connection con, Notes notes) throws SQLException{
    		PreparedStatement pst = null;
    		try{
    			String sql = "insert into notes (title, start_time, stop_time, description) values (?, ?, ?, ?)";
    			pst = con.prepareStatement(sql);
    			pst.setString(1, notes.getTitle());
    			pst.setString(2, notes.getStart_time());
    			pst.setString(3, notes.getStop_time());
    			pst.setString(4, notes.getDescription());
    			
    			pst.executeQuery();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return null;
    }
    public UserAdd userAdd(Connection con, UserAdd userAdd) throws SQLException {
    	PreparedStatement pst = null;
    	
    	try{
            String sql = "insert into user (school_num, name, sex, grade, school, major, qq, phone, email, password, address, role) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, userAdd.getSchool_num());
            pst.setString(2, userAdd.getName());
            pst.setString(3, userAdd.getSex());
            pst.setString(4, userAdd.getGrade());
            pst.setString(5, userAdd.getSchool());
            pst.setString(6, userAdd.getMajor());
            pst.setString(7, userAdd.getQq());
            pst.setString(8, userAdd.getPhone());
            pst.setString(9, userAdd.getEmail());
            pst.setString(10, userAdd.getPassword());
            pst.setString(11, userAdd.getAddress());
            pst.setString(12, userAdd.getRole());
            
            pst.executeQuery();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    public ClassRoom classRoomAdd(Connection con, ClassRoom classroom) throws SQLException{
    		PreparedStatement pst = null;
    		
    		try{
    			String sql = "insert into classroom (location, capacity) values (?, ?, ?)";
    			pst = con.prepareStatement(sql);
    			pst.setString(1, classroom.getLocation());
    			pst.setString(2, classroom.getCapacity());
    			
    			pst.executeQuery();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return null;
    }
    public Notes noteDelete(Connection con, Notes notes) throws SQLException{
    	PreparedStatement pst = null;
    	try{
    		String sql = "delete form notes where notes_id = ?";
    		pst = con.prepareStatement(sql);
    		pst.setString(1, notes.getNotes_id());
    		pst.execute();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
}

