package ch.alika.cukes.shopping.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MoneyTest {

    private static final Money $0_00 = new Money(0, 0);
    private static final Money $8_40 = new Money(8, 40);
    private static final Money $1_20 = new Money(1, 20);
    private static final Money $1_60 = new Money(1, 60);
    private static final Money $2_80 = new Money(2, 80);
    private static final Money $1_80 = new Money(1, 80);
    private static final Money $3_60 = new Money(3, 60);

    @Test
    void whereComparedForEquality() {
        assertThat(new Money(2,80),is($2_80));
    }

    @Test
    void whereConstructedUsingDefault() {
        assertThat(new Money(),is($0_00));
    }

    @Test
    void whereAdded() {
        assertThat($0_00.plus($1_20),is($1_20));
        assertThat($1_20.plus($1_60),is($2_80));
        assertThat($1_80.plus($1_80),is($3_60));
    }

    @Test
    void whereConstructedWithGreaterThan100Cents() {
        assertThat(new Money(2,160), is($3_60));
    }
    
    @Test
    void whereSubtracted() {
        assertThat($2_80.minus($1_60),is($1_20));
        assertThat($3_60.minus($1_80),is($1_80));
    }

    @Test
    void whereMultipliedByInteger() {
        assertThat($1_20.multipliedBy(7),is($8_40));
        assertThat($1_20.multipliedBy(3),is($3_60));
    }

    @Test
    void whereParsedFromStrings() {
        assertThat(Money.fromString("$3.60"),is($3_60));
        assertThat(Money.fromString("1.60"),is($1_60));
    }
}
