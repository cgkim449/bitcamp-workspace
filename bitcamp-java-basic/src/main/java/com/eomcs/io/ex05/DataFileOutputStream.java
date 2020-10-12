package com.eomcs.io.ex05;

import java.io.FileOutputStream;

public class DataFileOutputStream extends FileOutputStream{

  public DataFileOutputStream(String fileName) throws Exception {
    super(fileName);
  }

  public void writeUTF(String value) throws Exception {
    byte[] bytes = value.getBytes("UTF-8");
    this.write(bytes.length);
    this.write(bytes);
  }

  public void writeInt(int value) throws Exception {
    this.write(value >> 24);
    this.write(value >> 16);
    this.write(value >> 8);
    this.write(value);    
  }

  public void writeLong(long value) throws Exception {
    this.write((int)value >> 56);
    this.write((int)value >> 48);
    this.write((int)value >> 40);
    this.write((int)value >> 32);
    this.write((int)value >> 24);
    this.write((int)value >> 16);
    this.write((int)value >> 8);
    this.write((int)value);    
  }

  public void writeBoolean(boolean value) throws Exception {
    this.write(value ? 1 : 0);    
  }
}
