package www.qijianguo.com.bean;

/**
 * Description:
 * <p>
 * User: Administrator
 * Date: 2019-01-04
 * Time: 16:46
 */
public class Person {

    private String pic;

    private String name;

    private int age;

    public Person(String pic, String name, int age) {
        this.pic = pic;
        this.name = name;
        this.age = age;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
