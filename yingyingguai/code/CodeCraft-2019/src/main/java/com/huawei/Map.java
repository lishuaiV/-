import java.util.*;
import java.io.*;
public class Map {
	private ArrayList<Cross> crosses=new ArrayList<Cross>();  //���ڴ��·�����ݣ����ڶ�·���������
	private ArrayList<Road> roads=new ArrayList<Road>();      //���ڴ�ŵ�·���ݣ����ڶԵ�·�������
	private ArrayList<Car> cars=new ArrayList<Car>();         //���ڴ�ų������ݣ����ڶԳ��������
	private int[][] map;
	private int[][] weight;       //�������·�ڼ����ӵĵ�·��
	
	
	//�����ļ�����
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
	//�Գ�����Ϣ���д���
	public void collectCar(String message) {
		Car car=new Car(message);
		cars.add(car);
	}
	//�Ե�·��Ϣ���д���
	public void collectRoad(String message) {
		Road road=new Road(message);
		roads.add(road);
	}
	//��·����Ϣ���д���
	public void collectCross(String message) {
		Cross cross=new Cross(message);
		crosses.add(cross);
	}
	//������ͼ
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
				if(isd==true) {                    //�ж��Ƿ���˫���·
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
