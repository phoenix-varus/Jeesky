package org.iskycode.jeesky.cms;

public class Test {
    private String name;
    private String age;

    private Test(TestBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    class TestBuilder {
        private String name = "";
        private String age = "";

        public TestBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public TestBuilder setAge(String age) {
            this.age = age;
            return this;
        }

        public Test build() {
            return new Test(this);
        }
    }
}
