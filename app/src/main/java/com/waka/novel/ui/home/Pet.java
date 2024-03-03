// Pet.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.waka.novel.ui.home;
import java.util.List;

public class Pet {
    private long code;
    private Data data;

    public long getCode() { return code; }
    public void setCode(long value) { this.code = value; }

    public Data getData() { return data; }
    public void setData(Data value) { this.data = value; }
}

// Data.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Data {
    private List<String> photoUrls;
    private String name;
    private long id;
    private Category category;
    private List<Category> tags;
    private String status;

    public List<String> getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(List<String> value) { this.photoUrls = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public Category getCategory() { return category; }
    public void setCategory(Category value) { this.category = value; }

    public List<Category> getTags() { return tags; }
    public void setTags(List<Category> value) { this.tags = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }
}

// Category.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Category {
    private String name;
    private long id;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }
}
