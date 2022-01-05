public class TestMain {

  public static void main(String[] args) throws Exception {
/**
  ClassReaderTest.testRead();
  ClassLoaderTest.testLoadClassFromJar();
  ClassLoaderTest.testLoadClassFromDir();
  ClassLoaderTest.testLoadClassFromClasspath();
  ClassLoaderTest.testLoadClass_object();
  ClassLoaderTest.testLoadClass_test();
*/
    System.out.println("Test ClassReader...");
    ClassLoaderTest.testLoadClass_cache();
    ClassReaderTest.testRead();

    System.out.println("Test ClassLoader...");
    ClassLoaderTest.testLoadClassFromJar();
    ClassLoaderTest.testLoadClassFromDir();
    ClassLoaderTest.testLoadClassFromClasspath();
    ClassLoaderTest.testLoadClass_object();
    ClassLoaderTest.testLoadClass_test();

    System.out.println("Test Frame...");
    FrameTest.testFrameLocalVars();
    FrameTest.testFrameOperandStack();
  }
}

