//桥接类，画笔。桥接了颜色、画笔大小和样式
class Paint {
    private Color color;
    private Width width;
    private Style style;

    public Paint() {}
    public Paint(Color color, Width width, Style style) {
        this.color = color;
        this.width = width;
        this.style = style;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setWidth(Width width) {
        this.width = width;
    }
    public void setStyle(Style style) {
        this.style = style;
    }

    public void draw() {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.append(width.draw()).append(style.draw()).append(color.draw()).toString() + "画笔");
    }
}
//颜色抽象和具体实现
interface Color {
    String draw();
}
class Red implements Color {
    @Override
    public String draw() {
        return "红色";
    }
}
class Green implements Color {
    @Override
    public String draw() {
        return "绿色";
    }
}
//画笔大小抽象和具体实现
interface Width {
    String draw();
}
class BigWidth implements Width {
    @Override
    public String draw() {
        return "粗笔";
    }
}
class LittleWidth implements Width {
    @Override
    public String draw() {
        return "细笔";
    }
}
//样式抽象和具体实现
interface Style {
    String draw();
}
class FillStyle implements Style {
    @Override
    public String draw() {
        return "填充式";
    }
}