package jtg.templates;

public final class StaticLine extends jtg.Template {

    private jtg.Text _content = jtg.Text.EMPTY;

    public StaticLine withContent(jtg.Text value) {
        _content = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation);
        sb.append("sb.append(indentation).append(");
        _content.appendTo(sb);
        sb.append(");\n");
    }
}
