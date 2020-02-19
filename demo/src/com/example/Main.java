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
