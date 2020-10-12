package com.eomcs.io.ex05;

import java.io.FileInputStream;
import java.io.IOException;

public class DataFileInputStream extends FileInputStream{

  public DataFileInputStream(String fileName) throws Exception {
    super(fileName);
  }

  public String readUTF() throws IOException {
    int size = this.read();
    byte[] buff = new byte[size];
    this.read(buff);
    return new String(buff, "UTF-8");
  }

  public int readInt() throws Exception {
    return (this.read() << 24) + (this.read() << 16) + (this.read() << 8) + this.read();
  }

  public int readLong() throws Exception {
    return (this.read() << 56) + (this.read() << 48) 
        + (this.read() << 40) + (this.read() << 32) + (this.read() << 24) + 
        (this.read() << 16) + (this.read() << 8) + this.read();
  }

  public boolean readBoolean() throws IOException {
    if (this.read() == 1)
      return true;
    else
      return false;
  }



}
