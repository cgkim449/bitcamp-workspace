package com.eomcs.io.ex09.step2;

import java.io.IOException;
import java.io.InputStream;

public abstract class DecoratorInputStream extends InputStream{

  InputStream 연결된부품;

  public DecoratorInputStream(InputStream 연결된부품) {
    this.연결된부품 = 연결된부품;
  }

  @Override
  public int read() throws IOException {
    return 연결된부품.read();
  }

  @Override
  public void close() throws IOException {
    연결된부품.close();
  }
}
