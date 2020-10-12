package com.eomcs.io.ex08;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Exam0110 {

  public static void main(String[] args) throws IOException {
    byte[] buf = {0x0b, 0x41, 0x42, (byte) 0xea, (byte) 0xb0, (byte) 0x80, (byte) 0xea, (byte) 0xb0,
        (byte) 0x81, (byte) 0xea, (byte) 0xb0, (byte) 0x84, 0x00, 0x00, 0x00, 0x1b, 0x01};

    ByteArrayInputStream in = new ByteArrayInputStream(buf);

    DataInputStream in2 = new DataInputStream(in);

    Member member = new Member();

    member.name = in2.readUTF();
    member.age = in2.readInt();
    member.gender = in2.readBoolean();

    in.close();

    System.out.println(member);

  }

}
