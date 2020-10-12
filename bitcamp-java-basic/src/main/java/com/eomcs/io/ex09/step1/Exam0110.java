package com.eomcs.io.ex09.step1;

import java.io.FileInputStream;

public class Exam0110 {
  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/test4.data");
    BufferedInputStream in2 = new BufferedInputStream(in);
    DataInputStream in3 = new DataInputStream(in2);

    Member member = new Member();
    member.name = in3.readUTF();
    member.age = in3.readInt();
    member.gender = in3.readBoolean();

    in3.close();
    in2.close();
    in.close();

    System.out.println(member);
  }
}
