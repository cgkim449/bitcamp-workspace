package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStream extends FileInputStream{

  private byte[] buff = new byte[8192];
  private int cursor;
  private int size;

  public BufferedInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  @Override
  public int read() throws IOException {
    if (cursor == size) {
      cursor = 0;
      if ((size = super.read(buff)) == -1) {
        return -1;
      } 
    }
    return buff[cursor++];
  }

  @Override
  public int read(byte[] buf) throws IOException {
    return i;
  }
}
