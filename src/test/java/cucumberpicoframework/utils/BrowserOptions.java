package cucumberpicoframework.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;

public enum BrowserOptions {
    CHROME("chrome"), OPERA("opera"), FIREFOX("firefox"), IE("ie");

    private String name;

    BrowserOptions(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
