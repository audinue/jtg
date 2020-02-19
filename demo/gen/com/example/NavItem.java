package com.example;

public final class NavItem extends jtg.Template {

    private jtg.Text _href = jtg.Text.EMPTY;

    private jtg.Text _text = jtg.Text.EMPTY;

    public NavItem withHref(jtg.Text value) {
        _href = value;
        return this;
    }

    public NavItem withText(jtg.Text value) {
        _text = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation).append("<li>\n");
        sb.append(indentation);
        sb.append("\t<a href=\"");
        _href.appendTo(sb);
        sb.append("\">");
        _text.appendTo(sb);
        sb.append("</a>\n");
        sb.append(indentation).append("</li>\n");
    }
}
