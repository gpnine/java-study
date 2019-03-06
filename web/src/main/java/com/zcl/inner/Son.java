package com.zcl.inner;

/**
 * Son.
 *
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-11.
 */
public class Son {
	public int getStrong() {
		return new Father_1().strong();
	}

	public int getKind() {
		return new Mother_1().kind();
	}

	class Father_1 extends Father {
		public int strong() {
			return super.strong() + 1;
		}
	}

	class Mother_1 extends Mother {
		public int kind() {
			return super.kind() - 2;
		}
	}

}
