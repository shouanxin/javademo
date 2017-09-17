package annotation;

public class Test {
    private String name;
    private int id;
    private String like;
    private int age;

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != test.id) return false;
        if (age != test.age) return false;
        if (!name.equals(test.name)) return false;
        return like.equals(test.like);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id;
        result = 31 * result + like.hashCode();
        result = 31 * result + age;
        return result;
    }
}
