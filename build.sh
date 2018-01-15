#!/bin/sh

#mkdir -p ./junit/4.12/
#curl "http://central.maven.org/maven2/junit/junit/4.12/junit-4.12.jar" > ./junit/4.12/#junit-4.12.jar
#mkdir -p ./org/hamcrest/hamcrest-core/1.3/
#curl "http://central.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-#core-1.3.jar" > ./org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar

mkdir -p ./target/test-classes/


javac ArrayIntList.java
mv ArrayIntList.class ./target/test-classes/

javac -classpath ./target/test-classes/:./junit/4.12/junit-4.12.jar:./org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:. ./ArrayIntListTest.java

mv ArrayIntListTest.class ./target/test-classes/


java -cp ./target/test-classes:junit/4.12/junit-4.12.jar:org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore ArrayIntListTest


