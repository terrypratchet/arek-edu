package com.arek.inner.classes;

public class Method {
	private int x;
	int z;
	private void test(){
		final int w=3;

		abstract class Wrench{}; // only abstract or final
		class Spanner{
			private int  y;
			Spanner(){
				int z =0;
				int x =0;
				System.out.println(x + y + z +w);
			
				int a = Method.this.x;
			}

			private void m(){
				int z =0;
				System.out.println(x + y + z);
			}
		}

		new Spanner();
	}

	public static void main(String[] args) {


	}

}
