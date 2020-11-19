package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.service.ProjectService;

public class ProjectListCommand implements Command {

  ProjectService projectService;

  public ProjectListCommand(ProjectService projectService) {
    this.projectService = projectService;
  }

  @Override
  public void execute(Map<String, Object> context) {
    PrintWriter out = (PrintWriter) context.get("out");
    BufferedReader in = (BufferedReader) context.get("in");
    try {
      out.println("[프로젝트 목록]");

      List<Project> projects = (List<Project>) projectService.list();

      StringBuilder members = new StringBuilder();
      for (Project p : projects) {
        for (Member member : p.getMembers()) {
          if (members.length() > 0) {
            members.append(",");
          }
          members.append(member.getName());
        }

      }
      for (Project project : projects) {
        out.printf("%d, %s, %s, %s, %s, [%s]\n", project.getNo(), project.getTitle(),
            project.getStartDate(), project.getEndDate(), project.getOwner().getName(),
            members.toString());
      }
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
