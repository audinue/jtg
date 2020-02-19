package com.example;

public final class Hello extends jtg.Template {

    private jtg.Text _name = jtg.Text.EMPTY;

    public Hello withName(jtg.Text value) {
        _name = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation);
        sb.append("Hello ");
        _name.appendTo(sb);
        sb.append("!\n");
    }
}
