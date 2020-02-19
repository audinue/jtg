package jtg.templates;

public final class TextField extends jtg.Template {

    private jtg.Text _name = jtg.Text.EMPTY;

    public TextField withName(jtg.Text value) {
        _name = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append("\n");
        sb.append(indentation);
        sb.append("private jtg.Text ");
        _name.appendTo(sb);
        sb.append(" = jtg.Text.EMPTY;\n");
    }
}
