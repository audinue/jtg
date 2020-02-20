rm -r gen
rm -r out

mkdir gen
mkdir out

../jtg com.example templates gen

jdk=/root/Downloads/jdk1.7.0_80

$jdk/bin/javac -cp ../jtg-run/dist/jtg-run.jar -sourcepath gen:src -d out src/com/example/Main.java

$jdk/bin/java -cp ../jtg-run/dist/jtg-run.jar:out com.example.Main
