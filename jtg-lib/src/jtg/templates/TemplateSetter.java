package jtg.templates;

public final class TemplateSetter extends jtg.Template {

    private jtg.Text _class = jtg.Text.EMPTY;

    private jtg.Text _upperFirstName = jtg.Text.EMPTY;

    private jtg.Text _name = jtg.Text.EMPTY;

    public TemplateSetter withClass(jtg.Text value) {
        _class = value;
        return this;
    }

    public TemplateSetter withUpperFirstName(jtg.Text value) {
        _upperFirstName = value;
        return this;
    }

    public TemplateSetter withName(jtg.Text value) {
        _name = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append("\n");
        sb.append(indentation);
        sb.append("public ");
        _class.appendTo(sb);
        sb.append(" with");
        _upperFirstName.appendTo(sb);
        sb.append("(jtg.Template value) {\n");
        sb.append(indentation);
        sb.append("    ");
        _name.appendTo(sb);
        sb.append(" = value;\n");
        sb.append(indentation).append("    return this;\n");
        sb.append(indentation).append("}\n");
    }
}
