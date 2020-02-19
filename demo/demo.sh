set -x

cat templates/NavItem.jtg

cat templates/Nav.jtg

cat templates/Page.jtg

../jtg com.example templates gen

cat src/com/example/Main.java

java -cp ../jtg-run/dist/jtg-run.jar:out com.example.Main
