package test;

public class calculation {
	//the result of calculating linear set 
	private static String explain="";
	private static String[] ename;
	
	public static String getexplain() {
		return explain;
	}
	public static String[] getename() {
		return ename;
	}
	public static void fillinfo(String[] a,float[][] b,float[] c, int n) {
		String[] str=new String[n];
		for(int i=0;i<n;i++) {
			str=a[i].split(" ");
			for(int j=0;j<n;j++) {
				b[i][j]=Float.valueOf(str[j]);
			}
		}
		str=a[n].split(" ");
		for(int i=0;i<n;i++) {
			c[i]=Float.valueOf(str[i]);
		}
		
	}
	public static void fillinfo2(String[] a,float[][] b,float[] c,int n) {
		String[] str=new String[n+1];
		ename=new String[n];
		for(int i=0;i<n;i++) {
			ename[i]="x"+(i+1);
		}
		for(int i=0;i<n;i++) {
			str=a[i].split(" ");
			for(int j=0;j<n;j++) {
				b[i][j]=Float.valueOf(str[j]);
			}
			c[i]=Float.valueOf(str[n]);
		}
	}
	public static float[] ResultofEqution(float[][] a,float[] b) {
		int num=a.length;
		float t1,t2;
		float r[]=new float[num];
		for(int i=0;i<num-1;i++) {
			for(int j=i+1;j<num;j++) {
				t1=a[j][i]/a[i][i];
				for(int k=i+1;k<num;k++) {
					a[j][k]=a[j][k]-t1*a[i][k];
				}
				b[j]=b[j]-t1*b[i];
				a[j][i]=0;
			}
		}
		for(int i=num-1;i>0;i--) {
			for(int j=i-1;j>-1;j--) {
				t2=a[j][i]/a[i][i];
				b[j]=b[j]-t2*b[i];
				a[j][i]=0;
			}
		}
		
		for(int i=0;i<num;i++) {
			r[i]=b[i]/a[i][i];
		}
		return r;
	}
	public static String GetResult(float[][] a,float[] b) {
		int num=a.length;
		float t1,t2;
		String str="";
		int num2;
		for(int i=0;i<num;i++) {
			num2=a[i].length;
			if(num!=num2) return "缺少数据，请重新输入";
		}
		for(int i=0;i<num-1;i++) {
			explain=explain+"第"+(i+1)+"次行变换结果:"+"\n";
			for(int j=i+1;j<num;j++) {
				t1=a[j][i]/a[i][i];
				for(int k=i+1;k<num;k++) {
					a[j][k]=a[j][k]-t1*a[i][k];
				}
				b[j]=b[j]-t1*b[i];
				a[j][i]=0;
			}
			for(int p=0;p<num;p++) {
				for(int q=0;q<num;q++) {
					if(a[p][q]<0||q==0)
						explain=explain+a[p][q]+ename[q];
					else
						explain=explain+"+"+a[p][q]+ename[q];
				}
				explain=explain+"="+b[p]+"\n";
			}
		}
		for(int i=num-1;i>0;i--) {
			explain=explain+"第"+(2*num-i-1)+"次行变换结果:"+"\n";
			for(int j=i-1;j>-1;j--) {
				t2=a[j][i]/a[i][i];
				b[j]=b[j]-t2*b[i];
				a[j][i]=0;
			}
			for(int p=0;p<num;p++) {
				for(int q=0;q<num;q++) {
					if(a[p][q]<0)
						explain=explain+a[p][q]+ename[q];
					else
						explain=explain+"+"+a[p][q]+ename[q];
				}
				explain=explain+"="+b[p]+"\n";
			}
		}
		for(int i=0;i<num;i++) {
			if(a[i][i]==0) return "输入错误，请重新输入";
		}
		for(int i=0;i<num;i++) {
			str=str+ename[i]+"="+b[i]/a[i][i]+"  ";
		}
		return str;
	}
}
