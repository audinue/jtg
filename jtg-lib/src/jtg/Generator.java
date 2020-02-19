package jtg;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jtg.templates.EmptyLine;
import jtg.templates.IndentLine;
import jtg.templates.StaticLine;
import jtg.templates.StringLine;
import jtg.templates.TemplateField;
import jtg.templates.TemplateLine;
import jtg.templates.TemplateSetter;
import jtg.templates.TextField;
import jtg.templates.TextLine;
import jtg.templates.TextSetter;

public final class Generator {

    private final Pattern TEMPLATE_LINE = Pattern.compile("^(\\s*)\\$\\{([A-Za-z_$][A-Za-z0-9_$]*)}\\s*$");
    private final Pattern TEXT_LINE = Pattern.compile("\\$\\{([A-Za-z_$][A-Za-z0-9_$]*)}");

    public String generate(String packageName, String className, String input) {
        jtg.templates.Template template = new jtg.templates.Template();
        if (!packageName.isEmpty()) {
            template.withPackage(new jtg.templates.Package()
                    .withName(Text.from(packageName)));
        }
        Text classNameText = Text.from(className);
        template.withClass(classNameText);
        ArrayList<Template> fields = new ArrayList<>();
        ArrayList<Template> setters = new ArrayList<>();
        ArrayList<Template> lines = new ArrayList<>();
        for (String line : input.split("\r\n|\r|\n", -1)) {
            if (line.isEmpty()) {
                lines.add(new EmptyLine());
                continue;
            }
            Matcher matcher;
            matcher = TEMPLATE_LINE.matcher(line);
            if (matcher.find()) {
                Text nameText = prefix(matcher.group(2));
                fields.add(new TemplateField()
                        .withName(nameText));
                setters.add(new TemplateSetter()
                        .withName(nameText)
                        .withClass(classNameText)
                        .withUpperFirstName(upperFirst(matcher.group(2))));
                lines.add(new TemplateLine()
                        .withIndentation(quote(matcher.group(1)))
                        .withName(nameText));
                continue;
            }
            matcher = TEXT_LINE.matcher(line);
            if (matcher.find()) {
                lines.add(new IndentLine());
                int last = 0;
                do {
                    Text nameText = prefix(matcher.group(1));
                    fields.add(new TextField()
                            .withName(nameText));
                    setters.add(new TextSetter()
                            .withName(nameText)
                            .withClass(classNameText)
                            .withUpperFirstName(upperFirst(matcher.group(1))));
                    lines.add(new StringLine()
                            .withContent(quote(line.substring(last, matcher.start()))));
                    lines.add(new TextLine()
                            .withName(nameText));
                    last = matcher.end();
                } while (matcher.find());
                lines.add(new StringLine()
                        .withContent(quote(line.substring(last) + "\n")));
                continue;
            }
            lines.add(new StaticLine()
                    .withContent(quote(line + "\n")));
        }
        return template
                .withFields(Template.join(fields))
                .withSetters(Template.join(setters))
                .withLines(Template.join(lines))
                .toString();
    }

    private static Text prefix(final String name) {
        return new Text() {

            @Override
            public void appendTo(StringBuilder sb) {
                sb.append("_").append(name);
            }
        };
    }

    private static Text upperFirst(final String name) {
        return new Text() {

            @Override
            public void appendTo(StringBuilder sb) {
                sb.append(Character.toUpperCase(name.charAt(0)))
                        .append(name.substring(1));
            }
        };
    }

    private static Text quote(final String string) {
        return new Text() {

            @Override
            public void appendTo(StringBuilder sb) {
                sb.append('"');
                for (int i = 0; i < string.length(); i++) {
                    char c = string.charAt(i);
                    switch (c) {
                        case '\\':
                            sb.append("\\\\");
                            break;
                        case '\t':
                            sb.append("\\t");
                            break;
                        case '\r':
                            sb.append("\\r");
                            break;
                        case '\n':
                            sb.append("\\n");
                            break;
                        case '"':
                            sb.append("\\\"");
                            break;
                        default:
                            sb.append(c);
                    }
                }
                sb.append('"');
            }
        };
    }
}
