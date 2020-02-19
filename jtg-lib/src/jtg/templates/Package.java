package jtg.templates;

public final class Package extends jtg.Template {

    private jtg.Text _name = jtg.Text.EMPTY;

    public Package withName(jtg.Text value) {
        _name = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation);
        sb.append("package ");
        _name.appendTo(sb);
        sb.append(";\n");
        sb.append("\n");
    }
}
