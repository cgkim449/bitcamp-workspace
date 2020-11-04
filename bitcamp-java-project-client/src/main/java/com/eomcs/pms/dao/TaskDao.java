package com.eomcs.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Task;

public class TaskDao {
  public int insert(Task task) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into pms_task(content,deadline,owner,project_no,status)"
                + " values(?,?,?,?,?)")) {

      stmt.setString(1, task.getContent());
      stmt.setDate(2, task.getDeadline());
      stmt.setInt(3, task.getOwner().getNo());
      stmt.setInt(4, task.getProjectNo());
      stmt.setInt(5, task.getStatus());
      return stmt.executeUpdate();
    }
  }

  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "delete from pms_task where no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }
  }

  public Task findByNo(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select "
                + " t.content, "
                + " t.deadline,"
                + " t.status,"
                + " m.owner owner_no,"
                + " m.name owner_name"
                + " p.no project_no,"
                + " p.title,"
                + " from pms_task t "
                + " inner join pms_member m on t.owner=m.no"
                + " inner join pms_project p on t.project_no=p.no"
                + " where t.no = ?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Task task = new Task();
          task.setContent(rs.getString("content"));
          task.setDeadline(rs.getDate("deadline"));
          task.setStatus(rs.getInt("status"));

          Member owner = new Member();
          owner.setNo(rs.getInt("owner_no"));
          owner.setName(rs.getString("owner_name"));

          task.setProjectNo(rs.getInt("project_no"));
          task.setProjectTitle(rs.getString("title"));

          return task;
        } else {
          System.out.println("해당 번호의 작업이 존재하지 않습니다.");
          return null;
        }
      }
    }
  }

  public List<Task> findAll() throws Exception {
    List<Task> tasks = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select"
                + " t.no,"
                + " t.content,"
                + " t.deadline,"
                + " t.owner,"
                + " t.status,"
                + " m.no owner_no,"
                + " m.name owner_name"
                + " from pms_task t"
                + " inner join pms_member m on t.owner=m.no"
                + " order by t.deadline asc")) {

      try (ResultSet rs = stmt.executeQuery()) {
        while(rs.next()) {
          Task task = new Task();
          task.setNo(rs.getInt("no"));
          task.setContent(rs.getString("content"));
          task.setDeadline(rs.getDate("deadline"));

          Member owner = new Member();
          owner.setName(rs.getString("owner_name"));
          owner.setNo(rs.getInt("owner_no"));
          task.setOwner(owner);

          tasks.add(task);
        }
        return tasks;
      }
    }
  }

  public int update(Task task) throws Exception {
    return 0;
  }

}
