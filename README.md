# jtg

Java template generator.

Features:

- **Clean templates.**
  Substitution only, no expressions, no statements.
- **Clean output.**
  Produces properly indented output.

```
$ cat templates/NavItem.jtg
<li>
  <a href="${href}">${text}</a>
</li>

$ cat templates/Nav.jtg
<ul>
  ${items}
</ul>

$ cat templates/Page.jtg
<html>
  <head>
    <title>${title}</title>
  </head>
  <body>
    ${content}
  </body>
</html>

$ jtg com.example templates gen
Generated gen/com/example/NavItem.java from templates/NavItem.jtg.
Generated gen/com/example/Nav.java from templates/Nav.jtg.
Generated gen/com/example/Page.java from templates/Page.jtg.

$ cat src/com/example/Main.java
package com.example;

import java.util.Arrays;
import jtg.Template;
import jtg.Text;

public class Main {
  
  public static void main(String[] args) {
    Page page = new Page()
      .withTitle(Text.from("Hello World"))
      .withContent(new Nav()
        .withItems(Template.join(Arrays.asList(
          new NavItem()
            .withHref(Text.from("/home"))
            .withText(Text.from("Home")),
          new NavItem()
            .withHref(Text.from("/categories"))
            .withText(Text.from("Categories")),
          new NavItem()
            .withHref(Text.from("/about"))
            .withText(Text.from("About"))
        ))));
    System.out.print(page);
  }
}

$ java -cp jtg-run.jar com.example.Main
<html>
  <head>
    <title>Hello World</title>
  </head>
  <body>
    <ul>
      <li>
        <a href="/home">Home</a>
      </li>
      <li>
        <a href="/categories">Categories</a>
      </li>
      <li>
        <a href="/about">About</a>
      </li>
    </ul>
  </body>
</html>
```
