package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Prompt;

public class MemberHandler { // memberList의 Box

  ArrayList<Member> memberList = new ArrayList<>();

  public void add() { 
    System.out.println("[회원 등록]");

    Member member = new Member();
    // Member 객체를 생성
    // 사용자로부터 Member 객체의 변수값들을 받아 Member 객체에 변수들에 넣는다
    // 그리고 그 Member 객체를 
    // memberList 객체에 넣는다
    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));

    memberList.add(member);
  }

  public void list() { 
    System.out.println("[회원 목록]");

    for (int i = 0; i < memberList.size(); i++) {

      Member member = memberList.get(i);
      // Member 레퍼런스 선언을 해야지 Member 객체를 memberList에서 꺼낼 수 있다
      // 그릇을 만드는것

      System.out.printf("%d, %s, %s, %s, %s\n",
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getTel(),
          member.getRegisteredDate());
    }
  }

  public Member findByName(String name) {

    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }
}
