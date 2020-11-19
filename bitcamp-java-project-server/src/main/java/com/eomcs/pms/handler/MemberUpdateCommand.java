package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;
import com.eomcs.util.Prompt;

public class MemberUpdateCommand implements Command {

  MemberService memberService;

  public MemberUpdateCommand(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public void execute(Map<String, Object> context) {
    PrintWriter out = (PrintWriter) context.get("out");
    BufferedReader in = (BufferedReader) context.get("in");
    try {
      out.println("[회원 변경]");
      int no = Prompt.inputInt("번호? ", out, in);
      Member member = memberService.get(no);

      if (member == null) {
        out.println("해당 번호의 회원이 없습니다.");
        return;
      }

      String name = Prompt.inputString(String.format("이름(%s)? ", member.getName()), out, in);
      String email = Prompt.inputString(String.format("이메일(%s)? ", member.getEmail()), out, in);
      String password = Prompt.inputString("암호? ", out, in);
      String photo = Prompt.inputString(String.format("사진(%s)? ", member.getPhoto()), out, in);
      String tel = Prompt.inputString(String.format("전화(%s)? ", member.getTel()), out, in);

      String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("회원 변경을 취소하였습니다.");
        return;
      }

      member.setName(name);
      member.setEmail(email);
      member.setPassword(password);
      member.setPhoto(photo);
      member.setTel(tel);

      memberService.update(member);

      out.println("회원을 변경하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

}
