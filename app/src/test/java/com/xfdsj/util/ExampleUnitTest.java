package com.xfdsj.util;

import com.xfdsj.util.buffer.JBuffer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
  @Test public void addition_isCorrect() throws Exception {
    assertEquals(4, 2 + 2);
  }

  @Test public void testBuffer() {
    String str = "1234";
    JBuffer buffer = new JBuffer();
    buffer.putString(str, 10);     // 31 32 33 34 00 00 00 00 00 00 （10个字节）
    buffer.putShort((short) 100); // 00 64 （2个字节）
    System.out.println("数据长度：" + buffer.position());
    buffer.flip();
    System.out.println("获取字符串：" + buffer.getString() + " position：" + buffer.position());//取走31 32 33 34 00（共5个字节）其中00为结束符'\0'
    System.out.println("取走为0数据：" + buffer.getBytes(5).length + " position：" + buffer.position());//取走00 00 00 00 00（5个字节）
    System.out.println("获取short：" + buffer.getShort() + " position：" + buffer.position());//取走 00 64（2个字节）
  }
}