package com.example;

public final class Page extends jtg.Template {

    private jtg.Text _title = jtg.Text.EMPTY;

    private jtg.Template _content = jtg.Template.EMPTY;

    public Page withTitle(jtg.Text value) {
        _title = value;
        return this;
    }

    public Page withContent(jtg.Template value) {
        _content = value;
        return this;
    }

    @Override
    public void appendTo(java.lang.StringBuilder sb, java.lang.String indentation) {
        sb.append(indentation).append("<html>\n");
        sb.append(indentation).append("\t<head>\n");
        sb.append(indentation);
        sb.append("\t\t<title>");
        _title.appendTo(sb);
        sb.append("</title>\n");
        sb.append(indentation).append("\t</head>\n");
        sb.append(indentation).append("\t<body>\n");
        _content.appendTo(sb, indentation + "\t\t");
        sb.append(indentation).append("\t</body>\n");
        sb.append(indentation).append("</html>\n");
        sb.append("\n");
    }
}
