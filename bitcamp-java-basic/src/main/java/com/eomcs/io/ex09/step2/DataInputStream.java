package com.eomcs.io.ex09.step2;

import java.io.InputStream;

public class DataInputStream extends DecoratorInputStream{


  public DataInputStream(InputStream in) {
    super(in);
  }

  public String readUTF() throws Exception {
    int size = 연결된부품.read();
    byte[] bytes = new byte[size];
    연결된부품.read(bytes);
    return new String(bytes, "UTF-8");
  }

  public int readInt() throws Exception {
    int value = 0;

    value = 연결된부품.read() << 24;
    value += 연결된부품.read() << 16;
    value += 연결된부품.read() << 8;
    value += 연결된부품.read();
    return value;
  }

  public long readLong() throws Exception {
    long value = 0;
    value += (long) 연결된부품.read() << 56;
    value += (long) 연결된부품.read() << 48;
    value += (long) 연결된부품.read() << 40;
    value += (long) 연결된부품.read() << 32;
    value += (long) 연결된부품.read() << 24;
    value += (long) 연결된부품.read() << 16;
    value += (long) 연결된부품.read() << 8;
    value += 연결된부품.read();
    return value;
  }

  public boolean readBoolean() throws Exception {
    if (연결된부품.read() == 1)
      return true;
    else
      return false;
  }

}
