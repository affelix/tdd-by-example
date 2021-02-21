package guru.springframework;

import lombok.Getter;

/**
 *
 */
public class Foo {

    @Getter
    private static final String name = "Andre";

    public String getBar() {
        return "FooBar";
    }
}
