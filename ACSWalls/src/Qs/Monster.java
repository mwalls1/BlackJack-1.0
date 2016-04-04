package Qs;

public class Monster implements Comparable<Monster> {
	int ht1, wt1, age1;

	public Monster() {
		ht1 = 0;
		wt1 = 0;
		age1 = 0;
	}

	public Monster(int ht) {
		setHeight(ht);
	}

	public Monster(int ht, int wt) {
		setHeight(ht);
		setWeight(wt);
	}

	public Monster(int ht, int wt, int age) {
		setHeight(ht);
		setWeight(wt);
		setAge(age);
	}

	public void setWeight(int wt) {
		wt1 = wt;
	}

	public void setHeight(int ht) {
		ht1 = ht;
	}

	public void setAge(int age) {
		age1 = age;
	}

	public Object clone() {
		return new Monster(this.getHeight(), this.getWeight(), this.getAge());
	}

	public int getWeight() {
		return wt1;
	}

	public int getHeight() {
		return ht1;
	}

	public int getAge() {
		return age1;
	}

	public boolean equals(Object o) {
		if (o instanceof Monster && this.ht1 == ((Monster) o).ht1)
			if (this.wt1 == ((Monster) o).wt1)
				if (this.age1 == ((Monster) o).age1)
					return true;
		return false;
	}

	public int compareTo(Monster rhs) {
		if (rhs instanceof Monster && this.ht1 == ((Monster) rhs).ht1) {
			if (this.wt1 == ((Monster) rhs).wt1) {
				if (this.age1 > ((Monster) rhs).age1)
					return 1;
				else if (this.age1 == ((Monster) rhs).age1)
					return 0;
			} else if (this.wt1 > ((Monster) rhs).wt1) {
				return 1;
			}
		} else if (rhs instanceof Monster && this.ht1 > ((Monster) rhs).ht1) {
			return 1;
		}
		return -1;
	}

	public String toString() {
		return ht1 + " " + wt1 + " " + age1;
	}
}