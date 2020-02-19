package jtg.templates;

public final class Template extends jtg.Template {

    private jtg.Template _package = jtg.Template.EMPTY;

    private jtg.Text _class = jtg.Text.EMPTY;

    private jtg.Template _fields = jtg.Template.EMPTY;

    private jtg.Template _setters = jtg.Template.EMPTY;

    private jtg.Template _lines = jtg.Template.EMPTY;

    public Template withPackage(jtg.Template value) {
        _package = value;
        return this;
    }

    public Template withClass(jtg.Text value) {
        _class = value;
        return this;
    }

    public Template withFields(jtg.Template value) {
        _fields = value;
        return this;
    }

    public Template withSetters(jtg.Template value) {
        _setters = value;
        return this;
    }

    public Template withLines(jtg.Template value) {
        _lines = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        _package.appendTo(sb, indentation + "");
        sb.append(indentation).append("public final class ");
        _class.appendTo(sb);
        sb.append(" extends jtg.Template {\n");
        _fields.appendTo(sb, indentation + "    ");
        _setters.appendTo(sb, indentation + "    ");
        sb.append("\n");
        sb.append(indentation).append("    @Override\n");
        sb.append(indentation).append("    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {\n");
        _lines.appendTo(sb, indentation + "        ");
        sb.append(indentation).append("    }\n");
        sb.append(indentation).append("}\n");
    }
}
