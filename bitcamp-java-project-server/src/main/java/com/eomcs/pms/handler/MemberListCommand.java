package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;

public class MemberListCommand implements Command {

  MemberService memberService;

  public MemberListCommand(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public void execute(Map<String, Object> context) {
    PrintWriter out = (PrintWriter) context.get("out");
    BufferedReader in = (BufferedReader) context.get("in");
    try {

      out.println("[회원 목록]");

      List<Member> members = (List<Member>) memberService.list();

      // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
      // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.

      for (Member member : members) {
        out.printf("%d, %s, %s, %s, %s\n", member.getNo(), member.getName(), member.getEmail(),
            member.getTel(), member.getRegisteredDate());
      }
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
