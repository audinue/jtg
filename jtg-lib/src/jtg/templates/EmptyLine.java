package jtg.templates;

public final class EmptyLine extends jtg.Template {

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation).append("sb.append(\"\\n\");\n");
    }
}
