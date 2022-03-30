package ccit.js1842.wxf.bean;

public class GoodsBean {
    private Integer id;
    private String name;
    private double value;
    private Integer number;
    private String img_path;

    private String path = "";

    public GoodsBean() {

    }

    public GoodsBean(Integer id, String name, double value, Integer number, String img_path) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.number = number;
        if (img_path != null && "".equals(img_path)) {
            this.img_path = img_path;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        if (img_path != null && "".equals(img_path)) {
            this.img_path = img_path;
        } else {
            this.img_path = path;
        }
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", number=" + number +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
