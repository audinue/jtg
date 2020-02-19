package jtg;

public abstract class Template {

    public static final Template EMPTY = new Template() {
        @Override
        public void appendTo(StringBuilder sb, String indentation) {
        }
    };

    public static Template from(final Text text) {
        return new Template() {
            @Override
            public void appendTo(StringBuilder sb, String indentation) {
                sb.append(indentation);
                text.appendTo(sb);
                sb.append("\n");
            }
        };
    }

    public static Template from(final String string) {
        return new Template() {
            @Override
            public void appendTo(StringBuilder sb, String indentation) {
                sb.append(indentation).append(string).append("\n");
            }
        };
    }

    public static Template join(final Iterable<Template> templates) {
        return new Template() {
            @Override
            public void appendTo(StringBuilder sb, String indentation) {
                for (Template template : templates) {
                    template.appendTo(sb, indentation);
                }
            }
        };
    }

    public abstract void appendTo(StringBuilder sb, String indentation);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendTo(sb, "");
        return sb.toString();
    }
}
