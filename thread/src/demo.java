public class demo {
	public static void main(String[] args) {
		person p1 = new person();
		p1.setIs(false);
		System.out.println(p1);
		person p2 = new person();
		System.out.println(p2);

	}
}
class person{
	String name;
	String age;
	boolean is;
	int sex;

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public boolean isIs() {
		return is;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setIs(boolean is) {
		this.is = is;
	}

	@Override
	public String toString() {
		return "person{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				", is=" + is +
				", sex=" + sex +
				'}';
	}
}