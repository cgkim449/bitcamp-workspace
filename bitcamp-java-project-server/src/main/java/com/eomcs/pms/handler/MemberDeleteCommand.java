package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;
import com.eomcs.util.Prompt;

public class MemberDeleteCommand implements Command {

  MemberService memberService;

  public MemberDeleteCommand(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public void execute(Map<String, Object> context) {
    PrintWriter out = (PrintWriter) context.get("out");
    BufferedReader in = (BufferedReader) context.get("in");
    try {
      out.println("[회원 삭제]");
      int no = Prompt.inputInt("번호? ", out, in);

      Member member = memberService.get(no);

      if (member == null) {
        out.println("해당 번호의 회원이 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("회원 삭제를 취소하였습니다.");
        return;
      }

      memberService.delete(no);
      out.println("회원을 삭제하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
