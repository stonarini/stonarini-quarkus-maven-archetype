package ${package}.models;

public class Item {
    private Long id;
    private String name;
    private Integer count;
    private String status;

    public Item() {
    };

    public Item(String name, Integer count, String status) {
        this.name = name;
        this.count = count;
        this.status = status;
    }

    public Item(Long id, String name, Integer count, String status) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
