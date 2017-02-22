# Rsql Builder

Build a Rsql (Fiql) query.

Use with [rsql-parser](https://github.com/jirutka/rsql-parser) 

```xml
<dependencies>
    <dependency>
        <groupId>com.talanlabs</groupId>
        <artifactId>rsql-builder</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

## Usage

Simple :

```java
RsqlBuilder.newBuilder().string("name").eq("gaby").query();
// name=='gaby'
RsqlBuilder.newBuilder().string("name").contains("gaby").query();
// name=='*gaby*'
RsqlBuilder.newBuilder().string("name").neq("t'es là").query();
// name!='t\'es là'
RsqlBuilder.newBuilder().bool("name").isTrue().query();
// name==true
RsqlBuilder.newBuilder().intNum("age").gt(10).query();
// age=gt=10
RsqlBuilder.newBuilder().<Sexe>enumeration("sexe").eq(Sexe.MAN).query();
// sexe=MAN
RsqlBuilder.newBuilder().string("name").in("gaby","sandra").query();
// name=in=('gaby','sandra')
```

Group :

```java
RsqlBuilder.newBuilder().string("name").eq("gaby").and().openGroup().intNum("age").gt(20).or().intNum("age").lte(40).closeGroup().query();
// name=='gaby';(age=gt=20,age=le=40)
RsqlBuilder.rsql().string("name").eq("gaby").and().openGroup().openGroup().intNum("age").gt(20).or().intNum("age").lte(40).closeGroup().and().temporal("birthday")
                .after(LocalDate.parse("1970-01-01"), true).and().temporal("birthday").before(LocalDate.parse("1990-05-10"), true).closeGroup().query();
// name=='gaby';((age=gt=20,age=le=40);birthday=gt='1970-01-01';birthday=lt='1990-05-10')
```

