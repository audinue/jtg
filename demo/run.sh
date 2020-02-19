rm -r gen
rm -r out

mkdir gen
mkdir out

../jtg com.example templates gen

javac -cp ../jtg-run/dist/jtg-run.jar -sourcepath gen:src -d out src/com/example/Main.java

java -cp ../jtg-run/dist/jtg-run.jar:out com.example.Main
