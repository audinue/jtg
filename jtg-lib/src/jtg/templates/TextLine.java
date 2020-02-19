package jtg.templates;

public final class TextLine extends jtg.Template {

    private jtg.Text _name = jtg.Text.EMPTY;

    public TextLine withName(jtg.Text value) {
        _name = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation);
        _name.appendTo(sb);
        sb.append(".appendTo(sb);\n");
    }
}
