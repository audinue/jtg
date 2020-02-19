package com.example;

public final class Nav extends jtg.Template {

    private jtg.Template _items = jtg.Template.EMPTY;

    public Nav withItems(jtg.Template value) {
        _items = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation).append("<ul>\n");
        _items.appendTo(sb, indentation + "\t");
        sb.append(indentation).append("</ul>\n");
    }
}
