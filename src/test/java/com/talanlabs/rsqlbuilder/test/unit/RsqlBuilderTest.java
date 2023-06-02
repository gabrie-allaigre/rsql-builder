package com.talanlabs.rsqlbuilder.test.unit;

import com.talanlabs.rsqlbuilder.RsqlBuilder;
import com.talanlabs.rsqlbuilder.test.data.Sexe;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class RsqlBuilderTest {

    @Test
    public void testRsqlPropertyBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().property("address").isNull().query()).isEqualTo("address=na=''");
        softAssertions.assertAll();
    }

    @Test
    public void testRsqlLongBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.newCompletBuilder().is("name", "==", "gaby").query()).isEqualTo("name==gaby");
        softAssertions.assertThat(RsqlBuilder.newCompletBuilder().is("name", "!=", "gaby").query()).isEqualTo("name!=gaby");
        softAssertions.assertThat(RsqlBuilder.newCompletBuilder().is("name", "==", "gaby").and().is("code", "==", "GAB").query()).isEqualTo("name==gaby and code==GAB");
        softAssertions.assertThat(RsqlBuilder.newCompletBuilder().is("name", "==", "gaby").or().is("code", "==", "GAB").query()).isEqualTo("name==gaby or code==GAB");
        softAssertions.assertThat(RsqlBuilder.newCompletBuilder().is("code", "==", "GAB").and().openGroup().is("name", "==", "gaby").or().is("name", "==", "toto").closeGroup().query())
                .isEqualTo("code==GAB and (name==gaby or name==toto)");
        softAssertions.assertThat(
                RsqlBuilder.newCompletBuilder().openGroup().openGroup().is("name", "==", "gaby").or().is("name", "==", "toto").closeGroup().and().is("code", "==", "GAB").closeGroup().query())
                .isEqualTo("((name==gaby or name==toto) and code==GAB)");
        softAssertions.assertAll();
    }

    @Test
    public void testRsqlShortBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().openGroup().openGroup().is("name", "==", "gaby").or().is("name", "==", "toto").closeGroup().and().is("code", "==", "GAB").closeGroup().query())
                .isEqualTo("((name==gaby,name==toto);code==GAB)");
        softAssertions.assertAll();
    }

    @Test
    public void testStringRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").eq("gaby").query()).isEqualTo("name=='gaby'");
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").neq("gaby").query()).isEqualTo("name!='gaby'");
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").startWith("gaby").query()).isEqualTo("name=='gaby*'");
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").endWith("gaby").query()).isEqualTo("name=='*gaby'");
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").contains("gaby").query()).isEqualTo("name=='*gaby*'");
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").in("gaby", "sandra").query()).isEqualTo("name=in=('gaby','sandra')");
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").nin("gaby", "sandra").query()).isEqualTo("name=out=('gaby','sandra')");
        softAssertions.assertAll();
    }

    @Test
    public void testBooleanRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().bool("name").isTrue().query()).isEqualTo("name==true");
        softAssertions.assertThat(RsqlBuilder.rsql().bool("name").isFalse().query()).isEqualTo("name==false");
        softAssertions.assertAll();
    }

    @Test
    public void testShortRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().shortNum("name").eq((short) 10).query()).isEqualTo("name==10");
        softAssertions.assertThat(RsqlBuilder.rsql().shortNum("name").neq((short) 10).query()).isEqualTo("name!=10");
        softAssertions.assertThat(RsqlBuilder.rsql().shortNum("name").lt((short) 10).query()).isEqualTo("name=lt=10");
        softAssertions.assertThat(RsqlBuilder.rsql().shortNum("name").lte((short) 10).query()).isEqualTo("name=le=10");
        softAssertions.assertThat(RsqlBuilder.rsql().shortNum("name").gte((short) 10).query()).isEqualTo("name=ge=10");
        softAssertions.assertThat(RsqlBuilder.rsql().shortNum("name").gt((short) 10).query()).isEqualTo("name=gt=10");
        softAssertions.assertThat(RsqlBuilder.rsql().shortNum("name").in(Arrays.asList((short) 10, (short) 15)).query()).isEqualTo("name=in=(10,15)");
        softAssertions.assertThat(RsqlBuilder.rsql().shortNum("name").nin(Arrays.asList((short) 10, (short) 15)).query()).isEqualTo("name=out=(10,15)");
        softAssertions.assertAll();
    }

    @Test
    public void testIntegerRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().intNum("name").eq(10).query()).isEqualTo("name==10");
        softAssertions.assertThat(RsqlBuilder.rsql().intNum("name").neq(10).query()).isEqualTo("name!=10");
        softAssertions.assertThat(RsqlBuilder.rsql().intNum("name").lt(10).query()).isEqualTo("name=lt=10");
        softAssertions.assertThat(RsqlBuilder.rsql().intNum("name").lte(10).query()).isEqualTo("name=le=10");
        softAssertions.assertThat(RsqlBuilder.rsql().intNum("name").gte(10).query()).isEqualTo("name=ge=10");
        softAssertions.assertThat(RsqlBuilder.rsql().intNum("name").gt(10).query()).isEqualTo("name=gt=10");
        softAssertions.assertThat(RsqlBuilder.rsql().intNum("name").in(Arrays.asList(10, 15)).query()).isEqualTo("name=in=(10,15)");
        softAssertions.assertThat(RsqlBuilder.rsql().intNum("name").nin(Arrays.asList(10, 15)).query()).isEqualTo("name=out=(10,15)");
        softAssertions.assertAll();
    }

    @Test
    public void testFloatRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().floatNum("name").eq(10.1f).query()).isEqualTo("name==10.1");
        softAssertions.assertThat(RsqlBuilder.rsql().floatNum("name").neq(10.1f).query()).isEqualTo("name!=10.1");
        softAssertions.assertThat(RsqlBuilder.rsql().floatNum("name").lt(10.1f).query()).isEqualTo("name=lt=10.1");
        softAssertions.assertThat(RsqlBuilder.rsql().floatNum("name").lte(10.1f).query()).isEqualTo("name=le=10.1");
        softAssertions.assertThat(RsqlBuilder.rsql().floatNum("name").gte(10.1f).query()).isEqualTo("name=ge=10.1");
        softAssertions.assertThat(RsqlBuilder.rsql().floatNum("name").gt(10.1f).query()).isEqualTo("name=gt=10.1");
        softAssertions.assertThat(RsqlBuilder.rsql().floatNum("name").in(Arrays.asList(10.5f, 15f)).query()).isEqualTo("name=in=(10.5,15.0)");
        softAssertions.assertThat(RsqlBuilder.rsql().floatNum("name").nin(Arrays.asList(10.5f, 15f)).query()).isEqualTo("name=out=(10.5,15.0)");
        softAssertions.assertAll();
    }

    @Test
    public void testDoubleRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().doubleNum("name").eq(10.5).query()).isEqualTo("name==10.5");
        softAssertions.assertThat(RsqlBuilder.rsql().doubleNum("name").neq(10.5).query()).isEqualTo("name!=10.5");
        softAssertions.assertThat(RsqlBuilder.rsql().doubleNum("name").lt(10.5).query()).isEqualTo("name=lt=10.5");
        softAssertions.assertThat(RsqlBuilder.rsql().doubleNum("name").lte(10.5).query()).isEqualTo("name=le=10.5");
        softAssertions.assertThat(RsqlBuilder.rsql().doubleNum("name").gte(10.5).query()).isEqualTo("name=ge=10.5");
        softAssertions.assertThat(RsqlBuilder.rsql().doubleNum("name").gt(10.5).query()).isEqualTo("name=gt=10.5");
        softAssertions.assertThat(RsqlBuilder.rsql().doubleNum("name").in(Arrays.asList(10.5, 15.1)).query()).isEqualTo("name=in=(10.5,15.1)");
        softAssertions.assertThat(RsqlBuilder.rsql().doubleNum("name").nin(Arrays.asList(10.5, 15.1)).query()).isEqualTo("name=out=(10.5,15.1)");
        softAssertions.assertAll();
    }

    @Test
    public void testLongRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().longNum("name").eq(10L).query()).isEqualTo("name==10");
        softAssertions.assertThat(RsqlBuilder.rsql().longNum("name").neq(10L).query()).isEqualTo("name!=10");
        softAssertions.assertThat(RsqlBuilder.rsql().longNum("name").lt(10L).query()).isEqualTo("name=lt=10");
        softAssertions.assertThat(RsqlBuilder.rsql().longNum("name").lte(10L).query()).isEqualTo("name=le=10");
        softAssertions.assertThat(RsqlBuilder.rsql().longNum("name").gte(10L).query()).isEqualTo("name=ge=10");
        softAssertions.assertThat(RsqlBuilder.rsql().longNum("name").gt(10L).query()).isEqualTo("name=gt=10");
        softAssertions.assertThat(RsqlBuilder.rsql().longNum("name").in(Arrays.asList(10L, 15L)).query()).isEqualTo("name=in=(10,15)");
        softAssertions.assertThat(RsqlBuilder.rsql().longNum("name").nin(Arrays.asList(10L, 15L)).query()).isEqualTo("name=out=(10,15)");
        softAssertions.assertAll();
    }

    @Test
    public void testEnumRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().<Sexe>enumeration("name").eq(Sexe.MAN).query()).isEqualTo("name=='MAN'");
        softAssertions.assertThat(RsqlBuilder.rsql().<Sexe>enumeration("name").neq(Sexe.MAN).query()).isEqualTo("name!='MAN'");
        softAssertions.assertThat(RsqlBuilder.rsql().<Sexe>enumeration("name").in(Sexe.MAN, Sexe.WOMAN).query()).isEqualTo("name=in=('MAN','WOMAN')");
        softAssertions.assertThat(RsqlBuilder.rsql().<Sexe>enumeration("name").nin(Sexe.MAN, Sexe.WOMAN).query()).isEqualTo("name=out=('MAN','WOMAN')");
        softAssertions.assertAll();
    }

    @Test
    public void testGroupRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").eq("gaby").and().openGroup().intNum("age").gt(20).or().intNum("age").lte(40).closeGroup().query())
                .isEqualTo("name=='gaby';(age=gt=20,age=le=40)");
        softAssertions.assertThat(
                RsqlBuilder.rsql().or(RsqlBuilder.rsql().string("name").eq("gaby"), RsqlBuilder.rsql().string("name").eq("sandra")).and().openGroup().intNum("age").gt(20).or().intNum("age").lte(40)
                        .closeGroup().query()).isEqualTo("((name=='gaby'),(name=='sandra'));(age=gt=20,age=le=40)");
        softAssertions.assertThat(RsqlBuilder.rsql().and(RsqlBuilder.rsql().string("name").eq("gaby"), RsqlBuilder.rsql().intNum("age").gt(20).or().intNum("age").lte(40)).query())
                .isEqualTo("((name=='gaby');(age=gt=20,age=le=40))");
        softAssertions.assertThat(RsqlBuilder.rsql().string("name").eq("gaby").and().openGroup().openGroup().intNum("age").gt(20).or().intNum("age").lte(40).closeGroup().and().temporal("birthday")
                .after(LocalDate.parse("1970-01-01"), true).and().temporal("birthday").before(LocalDate.parse("1990-05-10"), true).closeGroup().query())
                .isEqualTo("name=='gaby';((age=gt=20,age=le=40);birthday=ge='1970-01-01';birthday=le='1990-05-10')");
        softAssertions.assertAll();
    }

    @Test
    public void testTemporalRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().temporal("date").after(LocalDate.parse("2017-02-21"), true).query()).isEqualTo("date=ge='2017-02-21'");
        softAssertions.assertThat(RsqlBuilder.rsql().temporal("date").before(LocalDateTime.parse("2017-02-21T13:19:45.311"), false).query()).isEqualTo("date=lt='2017-02-21T13:19:45.311'");
        softAssertions.assertThat(RsqlBuilder.rsql().temporal("date").before(LocalTime.parse("13:19:45.311"), true).query()).isEqualTo("date=le='13:19:45.311'");
        softAssertions.assertThat(RsqlBuilder.rsql().temporal("date").after(Instant.parse("2017-02-21T12:19:45.311Z"), false).query()).isEqualTo("date=gt='2017-02-21T12:19:45.311Z'");
        softAssertions.assertAll();
    }

    @Test
    public void testDirectAndOrRsqlBuilder() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RsqlBuilder.rsql().or(RsqlBuilder.rsql().string("name").eq("gaby"), RsqlBuilder.rsql().string("name").eq("sandra")).query())
                .isEqualTo("((name=='gaby'),(name=='sandra'))");
        softAssertions
                .assertThat(RsqlBuilder.rsql().or(RsqlBuilder.rsql().string("name").eq("gaby"), RsqlBuilder.rsql().string("name").eq("sandra"), RsqlBuilder.rsql().string("name").eq("nico")).query())
                .isEqualTo("((name=='gaby'),(name=='sandra'),(name=='nico'))");
        softAssertions
                .assertThat(RsqlBuilder.rsql().and(RsqlBuilder.rsql().string("name").eq("gaby"), RsqlBuilder.rsql().string("name").eq("sandra"), RsqlBuilder.rsql().string("name").eq("nico")).query())
                .isEqualTo("((name=='gaby');(name=='sandra');(name=='nico'))");
        softAssertions.assertAll();
    }
}
