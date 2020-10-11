package com.demo.program.java8.design.pattern;

import com.demo.program.java8.SuperHero;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;




public class GenericBuilderDemo {

    public static void main(String[] args) {

        SuperHero superHero = GenericBuilder.of(SuperHero::new)
                .with(SuperHero::setName, "Tony")
                .with(SuperHero::setSuperName, "Iron Man")
                .with(SuperHero::setProfession, "Business man")
                .with(SuperHero::setAge, 50)
                .with(SuperHero::setCanFly, true)
                .build();

        System.out.println("Constructing Iron man using java8 Builder pattern");
        System.out.println();
        System.out.println("Iron man :: " + superHero);

    }
}




class GenericBuilder<T> {

    private final Supplier<T> instantiator;
    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public GenericBuilder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
        return new GenericBuilder<T>(instantiator);
    }

    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        instanceModifiers.add(c);
        return this;
    }

    public T build() {
        T val = instantiator.get();
        instanceModifiers.forEach(modifier -> modifier.accept(val));
        instanceModifiers.clear();
        return val;
    }
}