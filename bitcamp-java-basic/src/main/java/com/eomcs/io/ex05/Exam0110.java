package com.eomcs.io.ex05;

public class Exam0110 {
  public static void main(String[] args) throws Exception {
    DataFileOutputStream out = new DataFileOutputStream("temp/test4.data");

    Member member = new Member();

    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;

    out.writeUTF(member.name);

    out.writeInt(member.age);

    out.writeBoolean(member.gender);

    out.close();

    System.out.println("데이터 출력 완료");
  }
}
