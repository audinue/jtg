package jtg.templates;

public final class StringLine extends jtg.Template {

    private jtg.Text _content = jtg.Text.EMPTY;

    public StringLine withContent(jtg.Text value) {
        _content = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation);
        sb.append("sb.append(");
        _content.appendTo(sb);
        sb.append(");\n");
    }
}
