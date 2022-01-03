public class TestMain {

  public static void main(String[] args) throws Exception {
  ClassReaderTest.testRead();
  ClassLoaderTest.testLoadClassFromJar();
  ClassLoaderTest.testLoadClassFromDir();
  ClassLoaderTest.testLoadClassFromClasspath();
  ClassLoaderTest.testLoadClass_object();
  ClassLoaderTest.testLoadClass_test();

}
}

