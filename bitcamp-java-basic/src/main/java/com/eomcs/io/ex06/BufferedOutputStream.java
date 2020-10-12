package com.eomcs.io.ex06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream extends FileOutputStream{

  byte[] buf = new byte[8196];
  int cursor;

  public BufferedOutputStream(String name) throws FileNotFoundException {
    super(name);
  }

  @Override
  public void write(int b) throws IOException {
    if (cursor == buf.length) {
      super.write(buf);
      cursor = 0;
    }
    buf[cursor++] = (byte) b;
  }

  @Override
  public void write(byte[] buf) throws IOException {
    for (byte b : buf) {
      this.write(b & 0x000000ff);
    }
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
    super.close();
  }
}
