package org.example;

import java.util.Objects;
public class BeginStringFilter implements Filter{
    private final String pattern;

    public BeginStringFilter(String pattern){
        if (pattern == null){
            throw new IllegalArgumentException("Pattern is null.");
        }
        this.pattern = pattern;
    }

    public String getPattern(){
        return pattern;
    }

    @Override
    public boolean apply(String str){
        return str != null && str.startsWith(pattern);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeginStringFilter that = (BeginStringFilter) o;
        return Objects.equals(pattern, that.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pattern);
    }

    @Override
    public String toString() {
        return "BeginStringFilter{pattern='" + pattern + "'}";
    }
}
