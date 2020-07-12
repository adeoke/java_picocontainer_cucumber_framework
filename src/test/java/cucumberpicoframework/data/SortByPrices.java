package cucumberpicoframework.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

public enum SortByPrices {
    ASCENDING("price:asc"),
    DESCENDING("price:desc"),
    NAME_A_TO_Z("name:asc"),
    NAME_Z_TO_A("name:desc"),
    STOCK("quantity:desc"),
    REFERENCE_ASC("reference:asc"),
    REFERENCE_DESC("reference:desc");

    private String name;

    SortByPrices(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
