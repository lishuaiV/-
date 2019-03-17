import java.util.*;
import java.io.*;
public class Map {
	private ArrayList<Cross> crosses=new ArrayList<Cross>();  //用于存放路口数据，用于对路口类的引用
	private ArrayList<Road> roads=new ArrayList<Road>();      //用于存放道路数据，用于对道路类的引用
	private ArrayList<Car> cars=new ArrayList<Car>();         //用于存放车的数据，用于对车类的引用
	private int[][] map;
	private int[][] weight;       //存放两个路口间连接的道路号
	
	
	//接受文件输入
	public void input(String filePath,int n) {
		try {
			File file=new File(filePath);
			FileInputStream f=new FileInputStream(file);
			InputStreamReader i=new InputStreamReader(f);
			BufferedReader bf=new BufferedReader(i);
			String line="";
			while((line=bf.readLine())!=null) {
				if(n==0) {
					collectCar(line);
				}
				else if(n==1) {
					collectRoad(line);
				}
				else {
					collectCross(line);
				}
			}
			bf.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//对车的信息进行处理
	public void collectCar(String message) {
		Car car=new Car(message);
		cars.add(car);
	}
	//对道路信息进行处理
	public void collectRoad(String message) {
		Road road=new Road(message);
		roads.add(road);
	}
	//对路口信息进行处理
	public void collectCross(String message) {
		Cross cross=new Cross(message);
		crosses.add(cross);
	}
	//创建地图
	public void createMap() {
		int size=crosses.size();
		map=new int[size][size];
		weight=new int[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[i][j]=0;
				weight[i][j]=0;
			}
		}
		for(int m=0;m<size;m++) {
			for(int n=0;n<size;n++) {
				Road r=new Road(roads.get(n));
				int begin=r.getOrigin();
				int end=r.getEnd();
				boolean isd=r.getDual();
				int weightNum=r.getId();
				if(isd==true) {                    //判断是否是双向道路
					map[begin-1][end-1]=1;
					map[end-1][begin-1]=1;
				}
				else {
					map[begin-1][end-1]=1;
				}
				weight[begin-1][end-1]=weightNum;
				weight[end-1][begin-1]=weightNum;
			}
		}
	}
}
