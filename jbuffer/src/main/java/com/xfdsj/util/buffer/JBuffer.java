package com.xfdsj.util.buffer;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

public class JBuffer {

  private IoBuffer buff;

  public JBuffer() {
    this.buff = IoBuffer.allocate(2048);
  }

  public JBuffer(int size) {
    this.buff = IoBuffer.allocate(size);
  }

  public JBuffer(IoBuffer buff) {
    this.buff = buff;
  }

  public JBuffer(byte[] bytes) {
    this.buff = IoBuffer.wrap(bytes);
  }

  public JBuffer mark() {
    this.buff.mark();
    return this;
  }

  public int markValue() {
    return this.buff.markValue();
  }

  public JBuffer reset() {
    this.buff.reset();
    return this;
  }

  public JBuffer flip() {
    this.buff.flip();
    return this;
  }

  public int remaining() {
    return this.buff.remaining();
  }

  public boolean hasRemain() {
    return this.buff.remaining() > 0;
  }

  public int position() {
    return this.buff.position();
  }

  public void position(int newPosition) {
    this.buff.position(newPosition);
  }

  public void clear() {
    this.buff.clear();
  }

  public void putByte(byte a) {
    this.buff.put(a);
  }

  public void putShort(short a) {
    this.buff.putShort(a);
  }

  public void putBytes(byte[] a) {
    this.buff.put(a);
  }

  public void putInt(int a) {
    this.buff.putInt(a);
  }

  public void putString(String str) {
    try {
      this.buff.putString(str, Charset.forName("GBK").newEncoder());
    } catch (CharacterCodingException e1) {
      e1.printStackTrace();
    }
  }

  public void putString(String str, int len) {
    try {
      this.buff.putString(str, len, Charset.forName("GBK").newEncoder());
    } catch (CharacterCodingException e1) {
      e1.printStackTrace();
    }
  }

  public byte get(int index) {
    return this.buff.get(index);
  }

  public byte getByte() {
    return this.buff.get();
  }

  public byte[] getBytes(int len) {
    byte[] data = new byte[len];
    this.buff.get(data);
    return data;
  }

  public byte[] getBytes() {
    byte[] data = new byte[this.buff.limit() - this.buff.position()];
    this.buff.get(data);
    return data;
  }

  public int getInt() {
    return this.buff.getInt();
  }

  public short getShort() {
    return this.buff.getShort();
  }

  public String getString() {
    try {
      String str = this.buff.getString(Charset.forName("GBK").newDecoder());
      return str;
    } catch (CharacterCodingException e) {
      e.printStackTrace();
      return "";
    }
  }

  public String getString(int len) {
    try {
      String str = this.buff.getString(len, Charset.forName("GBK").newDecoder());
      return str;
    } catch (CharacterCodingException e) {
      e.printStackTrace();
      return "";
    }
  }

  public byte[] array() {
    int pos = this.buff.position();
    byte[] data = new byte[pos];
    this.buff.position(0);
    this.buff.get(data);
    return data;
  }
}
