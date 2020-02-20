package com.example;

import java.util.Arrays;
import jtg.Template;
import jtg.Text;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("--- BEGIN ---");
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			Page page = new Page()
				.withTitle(Text.from("Hello World"))
				.withContent(new Nav()
					.withItems(Template.join(Arrays.<Template>asList(
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
			String string = page.toString();
			System.out.println(System.nanoTime() - start);
			System.out.println(string.length());
		}
	}
}
