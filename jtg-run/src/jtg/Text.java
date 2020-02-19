package jtg;

public abstract class Text {

    public static final Text EMPTY = new Text() {
        @Override
        public void appendTo(StringBuilder sb) {
        }
    };

    public static Text from(final String string) {
        return new Text() {
            @Override
            public void appendTo(StringBuilder sb) {
                sb.append(string);
            }
        };
    }

    public static Text join(final Text separator, final Iterable<Text> texts) {
        return new Text() {
            @Override
            public void appendTo(StringBuilder sb) {
                boolean next = false;
                for (Text text : texts) {
                    if (next) {
                        separator.appendTo(sb);
                    } else {
                        next = true;
                    }
                    text.appendTo(sb);
                }
            }
        };
    }

    public abstract void appendTo(StringBuilder sb);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendTo(sb);
        return sb.toString();
    }
}
