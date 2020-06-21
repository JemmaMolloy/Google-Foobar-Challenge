//prepare-the-bunnies-escape
public class Solution {
    final static int d[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static int solution(int[][] map) {
        // Your code here
    
        int h = map.length;
		int w = map[0].length;
		Point source = new Point(0,0);
		Point dest = new Point(h-1,w-1);
		int smallest = Integer.MAX_VALUE;
		int[][]maze=map;
		
		for (int i = 0; i < h; i++) 
		{
			for (int j = 0; j < w; j++) 
			{
				if(maze[i][j]==1)
				{
				    maze[i][j]=0;
				    int dist = bfs(maze, source, dest);
				    maze[i][j]=1;
				    if(dist<smallest)
    				{
    				    smallest = dist;
    				    if(smallest==h+w-1)
        				{
        				    return smallest;
        				}
    				}
				}
				int dist = bfs(maze, source, dest);
				if(dist<smallest)
				{
				    smallest = dist;
				    if(smallest==h+w-1)
    				{
    				    return smallest;
    				}
				}
			}
		}
		
		return smallest;
    }	
	public static int bfs(int[][] map, Point src, Point dest) 
	{
		int minDist = Integer.MAX_VALUE;

		int h = map.length;
		int w = map[0].length;
		boolean[][] visited = new boolean[h][w];
		for (int i = 0; i < h; i++) 
		{
			for (int j = 0; j < w; j++) 
			{
				visited[i][j] = false;
			}
		}

		Queue q = new Queue(1000);
		Node s = new Node(src, 1);
		q.insert(s);

		while (!q.isEmpty()) {
			Node current = q.remove();
			Point pt = current.pt;
			if (pt.x == dest.x && pt.y == dest.y)
			{
			    return current.dist;
			}
				
			for (int i = 0; i < 4; i++) 
			{
				int row = pt.x + d[i][0];
				int col = pt.y + d[i][1];
				if (isValid(h, w, row, col)&& map[row][col] ==0 && !visited[row][col]) 
				{
					visited[row][col] = true;
					Node adj = new Node(new Point(row, col), current.dist + 1);
					q.insert(adj);
				}
			}
		}
		return minDist;
	}

	private static boolean isValid( int width, int height, int row, int col) 
	{
		return (row >= 0 && row < width && col >= 0 && col < height);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Node {
		Point pt;
		int dist;

		public Node(Point pt, int dist) {
			this.pt = pt;
			this.dist = dist;
		}
	}
	static class Queue
    {
        int maxSize;
        Node[] queArray;
        int front;
        int rear;
        int nItems;
        
        public Queue(int s)
        {
            maxSize=s;
            queArray=new Node[maxSize];
            front=0;
            rear=-1;
            nItems=0;
        }
        public void insert(Node j)
        {
            if(rear ==maxSize-1)
            {
                rear=-1;
            }
            queArray[++rear]=j;
            nItems++;
        }
        public Node remove()
        {
            Node temp = queArray[front++];
            if(front==maxSize)
            {
                front=0;
            }
            nItems--;
            return temp;
        }
        public boolean isEmpty()
        {
            return (nItems==0);
        }
        public int size()
        {
            return nItems;
        }
    }
}
