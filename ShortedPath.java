package DijkstraAlgorithm;

public class ShortedPath {
	// ����� ������ ����������� ���������
	public int minDistance(int dist[], Boolean b[]) {
		int min = Integer.MAX_VALUE, index = -1;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == false && dist[i] <= min) {// ���� ������� ��� �� �������� � ��������� ������ ��� ����� min
				min = dist[i];
				index = i;
				
			}
			
			
		}
		return index;
		
		
	}
	
	public void printGraph(int dist[], int x) {
		System.out.println("Distance from source to Destination is");
		for (int i = 0; i < dist.length; i++) {
			System.out.println(i+ "---" + dist[i]);
		}
	}
	
	// ��� ����� ��������
	// �� ���� ��� ���� � ������� � ������� ���������� �����  
	public void dijkstra(int graph[][], int scr) {
		int vertex = graph.length;
		System.out.println(vertex);
		// ������ ��� �������� ����� ����
		int dist[] = new int[vertex];
		
		// ���� �������� ������� ��� ���
		Boolean b[] = new Boolean[vertex];
		for (int i = 0; i < b.length; i++) {// ���� ������ ������� ������������ ����� ����� � ��� �� ���� ������� �� ���� ��������
			dist[i] = Integer.MAX_VALUE;// �������� �������� ���� ��� ������������ (���� + �������������)
			b[i] = false;
			
		}
		
		dist[scr] = 0;
		// ���� ���� ������� ����������� ���������
		for (int count = 0; count < vertex; count++) {
			int u = minDistance(dist, b);
			b[u] = true;
			for (int x= 0; x < b.length; x++) {
				if(!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][x] < dist[x]) {
					dist[x] = dist[u] + graph[u][x];
				}
			}
			//
			printGraph(dist, vertex);
		}
		
		
	}

	public static void main(String[] args) {
		// ������������� ������ �����, ����� ��. ������� (������ � �������)
		int graphDijkstra[][] = new int[][] {{0, 4, 0, 0, 7},
			{4, 0, 1, 2, 0},
			{0, 1, 0, 6, 0},
			{0, 2, 6, 0, 0},
			{7, 0, 0, 0, 0}
			
		};

	// ��������� ������ ������
	ShortedPath p = new ShortedPath();
	p.dijkstra(graphDijkstra, 3);
	
	}
	
	

}
