# jollyTest
This is a short test case illustrating a problem with jollyday (https://github.com/svendiedrichsen/jollyday) on ubuntu 18.04 LTS

Executing this test case on ubuntu 16.04 LTS (e.g. AWS ami-66506c1c) works as expected.

Executing this test case on ubuntu 18.04 LTS (e.g. AWS ami-920b10ed) fails with an exception.

JDK version istalled in both environments is the same (openjdk-8-jdk).

## Note: the cause has been found
please see https://github.com/svendiedrichsen/jollyday/issues/77

Please see below for relevant test logs:

## ubuntu 18.04 LTS (failure)
```
mvn compile test
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building jollyTest 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ jollyTest ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /root/jollyTest/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ jollyTest ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ jollyTest ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /root/jollyTest/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ jollyTest ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ jollyTest ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /root/jollyTest/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ jollyTest ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ jollyTest ---
[INFO] Surefire report directory: /root/jollyTest/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.engisys.AppTest
java.lang.IllegalStateException: Cannot create manager class de.jollyday.impl.DefaultHolidayManager
	at de.jollyday.caching.HolidayManagerValueHandler.instantiateManagerImpl(HolidayManagerValueHandler.java:61)
	at de.jollyday.caching.HolidayManagerValueHandler.createValue(HolidayManagerValueHandler.java:41)
	at de.jollyday.caching.HolidayManagerValueHandler.createValue(HolidayManagerValueHandler.java:13)
	at de.jollyday.util.Cache.lambda$get$0(Cache.java:43)
	at java.base/java.util.concurrent.ConcurrentHashMap.computeIfAbsent(ConcurrentHashMap.java:1719)
	at de.jollyday.util.Cache.get(Cache.java:43)
	at de.jollyday.HolidayManager.createManager(HolidayManager.java:166)
	at de.jollyday.HolidayManager.getInstance(HolidayManager.java:146)
	at de.jollyday.HolidayManager.getInstance(HolidayManager.java:100)
	at com.engisys.App.setHolidays(App.java:23)
	at com.engisys.AppTest.testApp(AppTest.java:41)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at junit.framework.TestCase.runTest(TestCase.java:154)
	at junit.framework.TestCase.runBare(TestCase.java:127)
	at junit.framework.TestResult$1.protect(TestResult.java:106)
	at junit.framework.TestResult.runProtected(TestResult.java:124)
	at junit.framework.TestResult.run(TestResult.java:109)
	at junit.framework.TestCase.run(TestCase.java:118)
	at junit.framework.TestSuite.runTest(TestSuite.java:208)
	at junit.framework.TestSuite.run(TestSuite.java:203)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at org.apache.maven.surefire.junit.JUnitTestSet.execute(JUnitTestSet.java:95)
	at org.apache.maven.surefire.junit.JUnit3Provider.executeTestSet(JUnit3Provider.java:121)
	at org.apache.maven.surefire.junit.JUnit3Provider.invoke(JUnit3Provider.java:98)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)
	at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)
	at org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)
Caused by: java.lang.reflect.InvocationTargetException
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:488)
	at de.jollyday.caching.HolidayManagerValueHandler.instantiateManagerImpl(HolidayManagerValueHandler.java:58)
	... 38 more
Caused by: java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
	at de.jollyday.util.CalendarUtil.<init>(CalendarUtil.java:45)
	at de.jollyday.HolidayManager.<init>(HolidayManager.java:64)
	at de.jollyday.impl.DefaultHolidayManager.<init>(DefaultHolidayManager.java:39)
	... 43 more
Caused by: java.lang.ClassNotFoundException: javax.xml.bind.JAXBException
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:582)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:190)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:499)
	... 46 more
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.1 sec <<< FAILURE!
testApp(com.engisys.AppTest)  Time elapsed: 0.082 sec  <<< FAILURE!
junit.framework.AssertionFailedError: Exception received
	at junit.framework.Assert.fail(Assert.java:47)
	at com.engisys.AppTest.testApp(AppTest.java:47)


Results :

Failed tests:   testApp(com.engisys.AppTest): Exception received

Tests run: 1, Failures: 1, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.197 s
[INFO] Finished at: 2018-08-10T10:58:58-04:00
[INFO] Final Memory: 10M/74M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project jollyTest: There are test failures.
[ERROR] 
[ERROR] Please refer to /root/jollyTest/target/surefire-reports for the individual test results.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException




```


## ubuntu 16.04 LTS (success)
```
~/jollyTest# mvn compile test
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building jollyTest 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ jollyTest ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /root/jollyTest/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ jollyTest ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ jollyTest ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /root/jollyTest/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ jollyTest ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ jollyTest ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /root/jollyTest/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ jollyTest ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.17:test (default-test) @ jollyTest ---
[INFO] Surefire report directory: /root/jollyTest/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.engisys.AppTest
test has 27 entries
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.281 sec - in com.engisys.AppTest

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.364 s
[INFO] Finished at: 2018-08-10T10:57:29-04:00
[INFO] Final Memory: 12M/920M
[INFO] ------------------------------------------------------------------------

```
