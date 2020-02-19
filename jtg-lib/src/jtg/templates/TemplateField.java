package jtg.templates;

public final class TemplateField extends jtg.Template {

    private jtg.Text _name = jtg.Text.EMPTY;

    public TemplateField withName(jtg.Text value) {
        _name = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append("\n");
        sb.append(indentation);
        sb.append("private jtg.Template ");
        _name.appendTo(sb);
        sb.append(" = jtg.Template.EMPTY;\n");
    }
}
