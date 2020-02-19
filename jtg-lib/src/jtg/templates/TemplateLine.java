package jtg.templates;

public final class TemplateLine extends jtg.Template {

    private jtg.Text _name = jtg.Text.EMPTY;

    private jtg.Text _indentation = jtg.Text.EMPTY;

    public TemplateLine withName(jtg.Text value) {
        _name = value;
        return this;
    }

    public TemplateLine withIndentation(jtg.Text value) {
        _indentation = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation);
        _name.appendTo(sb);
        sb.append(".appendTo(sb, indentation + ");
        _indentation.appendTo(sb);
        sb.append(");\n");
    }
}
