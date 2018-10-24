package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import util.ChessSize;
import view.WuZiQiView;


 

/**
 * 棋子类
 * @author lyj80
 *
 */
public class Chess extends JPanel{
	
	public static boolean lostOrWinFlag=false;
	public static final int BLACK=1;//高度有20个格子
	public static final int WHITE=2;//高度有20个格子
	
	public static final int PC=1;//人机对战
	public static final int PP=2;//人人对战
	
	public static int LAST_STEP=BLACK;//轮到谁走了
	public static int STEP=BLACK;//轮到谁走了

	public static int lastChess_x;
	public static int lastChess_y;
	
	public static int PC_Chess_x;
	public static int PC_Chess_y;
	
	public static LinkedList<Point> last_chess_white=new LinkedList<Point>();
	public static LinkedList<Point> last_chess_black=new LinkedList<Point>();
	
	public static int war=PC;//战争类型，初始化为人机对战
	public static int finish=0;
	/**
	 * 定义棋盘
	 */
	public static int[][] chessAll=new int[ChessSize.WIDTH][ChessSize.HEIGHT];
	public static int[][] weight=new int[ChessSize.WIDTH][ChessSize.HEIGHT];
	public static String[][] str=new String[ChessSize.WIDTH][ChessSize.HEIGHT];
	public static Point[] point=new Point[ChessSize.WIDTH*ChessSize.HEIGHT];
	
	public static int point_num=0;
	/**
	 * 电脑思考,随机下
	 */
	public Point PC_Calculation_1() {//电脑是白棋，而且是黑棋先下
		
		Random random=new Random();//随机产生
		int x=random.nextInt(ChessSize.WIDTH);
		int y=random.nextInt(ChessSize.HEIGHT);
		
		while(true) {
			if(chessAll[x][y]!=0) {
				x=random.nextInt(ChessSize.WIDTH);
				y=random.nextInt(ChessSize.HEIGHT);
			}else break;
		}
			
		Chess.PC_Chess_x=x;
		Chess.PC_Chess_y=y;
		return new Point(x,y);
	}
	
	public void setValue(int x,int y,String s1,int num_select,int value) {
		num_select=num_select-1;
		
		if(s1=="上") {
			if(weight[x][y-num_select]<value)	weight[x][y-num_select]=value;//如果之前的权值比较小，并且这个点没有棋子
		}else if(s1=="下") {
			if(weight[x][y+num_select]<value) 	weight[x][y+num_select]=value;
		}else if(s1=="左") {
			if(weight[x-num_select][y]<value)	weight[x-num_select][y]=value;
		}else if(s1=="右") {
			if(weight[x+num_select][y]<value)	weight[x+num_select][y]=value;
		}else if(s1=="左上") {
			if(weight[x-num_select][y-num_select]<value)	weight[x-num_select][y-num_select]=value;
		}else if(s1=="左下") {
			if(weight[x-num_select][y+num_select]<value)	weight[x-num_select][y+num_select]=value;
		}else if(s1=="右上") {
			if(weight[x+num_select][y-num_select]<value)	weight[x+num_select][y-num_select]=value;
		}else if(s1=="右下") {
			if(weight[x+num_select][y+num_select]<value)	weight[x+num_select][y+num_select]=value;
		}
	}
	
	public boolean search(int x,int y,String s1,String s) {
		/**
		 * BLACK:1,WHITE:2,没有棋子:0
		 */
		
		if(s1=="上") {//010111---2
			if(y-s.length()>=0) {
				int num=0;
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*')	{num++;continue;}
					else if(chessAll[x][y-i]!=Integer.valueOf(s.charAt(i)+"")) break;
					else num++;
				}
				if(num==s.length()) {	
					return true;
				}				
			}
		}else if(s1=="下") {
			if(y+s.length()<=ChessSize.HEIGHT-1) {
				int num=0;
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*')	{num++;continue;}
					else if(chessAll[x][y+i]!=Integer.valueOf(s.charAt(i)+"")) break;
					else num++;
				}
				if(num==s.length()) {
					return true;
				}	
			}
		}else if(s1=="左") {
			if(x-s.length()>=0) {
				int num=0;
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*')	{num++;continue;}
					else if(chessAll[x-i][y]!=Integer.valueOf(s.charAt(i)+"")) break;
					else num++;
				}
				if(num==s.length()) {
					return true;
				}	
			}
		}else if(s1=="右") {
			if(x+s.length()<=ChessSize.WIDTH-1) {
				int num=0;
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*')	{num++;continue;}
					else if(chessAll[x+i][y]!=Integer.valueOf(s.charAt(i)+"")) break;
					else num++;
				}
				if(num==s.length()) {
					return true;
				}	
			}
		}else if(s1=="左上") {
			if(x-s.length()>=0 && y-s.length()>=0) {
				int num=0;
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*')	{num++;continue;}
					else if(chessAll[x-i][y-i]!=Integer.valueOf(s.charAt(i)+"")) break;
					else num++;
				}
				if(num==s.length()) {
					return true;
				}	
			}
		}else if(s1=="左下") {
			if(x-s.length()>=0 && y+s.length()<=ChessSize.HEIGHT-1) {
				int num=0;
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*')	{num++;continue;}
					else if(chessAll[x-i][y+i]!=Integer.valueOf(s.charAt(i)+"")) break;
					else num++;
				}
				if(num==s.length()) {
					return true;
				}
			}
		}else if(s1=="右上") {
			if(x+s.length()<=ChessSize.WIDTH-1 && y-s.length()>=0) {
				int num=0;
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*')	{num++;continue;}
					else if(chessAll[x+i][y-i]!=Integer.valueOf(s.charAt(i)+"")) break;
					else num++;
				}
				if(num==s.length()) {
					return true;
				}
			}
		}else if(s1=="右下") {
			if(x+s.length()<=ChessSize.WIDTH-1 && y+s.length()<=ChessSize.HEIGHT-1) {
				int num=0;
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='*')	{num++;continue;}
					else if(chessAll[x+i][y+i]!=Integer.valueOf(s.charAt(i)+"")) break;
					else num++;
				}
				if(num==s.length()) {
					return true;
				}
			}
		}
		
		return false;
		
	}

	public void account_value(int x,int y,String s1,int num_select,int value) {
		num_select=num_select-1;
		
		if(s1=="上") {
			if(y-num_select>=0){
				weight[x][y-num_select]+=value;
				str[x][y-num_select]+="+"+String.valueOf(value);
			}
		}else if(s1=="下") {
			if(y+num_select<ChessSize.HEIGHT) {
				weight[x][y+num_select]+=value;
				str[x][y+num_select]+="+"+String.valueOf(value);
			}
		}else if(s1=="左") {
			if(x-num_select>=0) {
				weight[x-num_select][y]+=value;
				str[x-num_select][y]+="+"+String.valueOf(value);
			}
		}else if(s1=="右") {
			if(x+num_select<ChessSize.WIDTH) {
				weight[x+num_select][y]+=value;
				str[x+num_select][y]+="+"+String.valueOf(value);
			}
		}else if(s1=="左上") {
			if(x-num_select>=0&&y-num_select>=0) {
				weight[x-num_select][y-num_select]+=value;
				str[x-num_select][y-num_select]+="+"+String.valueOf(value);
			}
		}else if(s1=="左下") {
			if(x-num_select>=0&& y+num_select<ChessSize.HEIGHT) {
				weight[x-num_select][y+num_select]+=value;
				str[x-num_select][y+num_select]+="+"+String.valueOf(value);
			}
		}else if(s1=="右上") {
			if(x+num_select>ChessSize.WIDTH && y-num_select>=0) {
				weight[x+num_select][y-num_select]+=value;	
				str[x+num_select][y-num_select]+="+"+String.valueOf(value);
			}
		}else if(s1=="右下") {
			if(x+num_select<ChessSize.WIDTH && y+num_select<ChessSize.HEIGHT) {
				weight[x+num_select][y+num_select]+=value;
				str[x+num_select][y+num_select]+="+"+String.valueOf(value);
			}
		}
	}
	
	
	/**
	 * 电脑思考，算法
	 */
	public Point PC_Calculation() {//电脑是白棋，而且是黑棋先下

		String[] arr= {"上","下","左","右","左上","左下","右上","右下"};
		
		//int var=500;
		int n=0;
		int chengwu=80000;
		int huosi=14000;
		int sisi=10500;
		int huosan=4500;
		int sisan=3000;
		int huoer=2500;
		int sier=1500;
		int danzi=1000;
		
		for(int y=0;y<ChessSize.HEIGHT;y++) {//权值初始化
			for(int x=0;x<ChessSize.WIDTH;x++) {
					weight[x][y]=0;			
			}
		}
		
		for(int y=0;y<ChessSize.HEIGHT;y++) {//字符串数组初始化
			for(int x=0;x<ChessSize.WIDTH;x++) {
					str[x][y]="";			
			}
		}
		
		for(int y=0;y<ChessSize.HEIGHT;y++) {
			for(int x=0;x<ChessSize.WIDTH;x++) {
				for(String s:arr) {//前面要加0，最后面结尾是0则不用加

						 if(search(x,y,s,"022220"))	account_value(x,y,s,1,chengwu+n);		//成5
					else if(search(x,y,s,"*202220"))	account_value(x,y,s,3,chengwu+n);		//成5
					else if(search(x,y,s,"*220220"))	account_value(x,y,s,4,chengwu+n);		//成5
					else if(search(x,y,s,"*222020"))	account_value(x,y,s,5,chengwu+n);		//成5
					else if(search(x,y,s,"002220"))	{account_value(x,y,s,2,huosi+n);account_value(x,y,s,1,huosi-200+n);}		//活4
					else if(search(x,y,s,"020220"))	{account_value(x,y,s,3,huosi+n);account_value(x,y,s,1,huosi-200+n);}		//活4
					else if(search(x,y,s,"022020"))	{account_value(x,y,s,4,huosi+n);account_value(x,y,s,1,huosi-200+n);}		//活4
					else if(search(x,y,s,"022210"))	account_value(x,y,s,1,sisi+n);		//死4
					else if(search(x,y,s,"0202210"))	{account_value(x,y,s,1,sisi+200+n);account_value(x,y,s,3,sisi+n);}		//死4
					else if(search(x,y,s,"0220210"))	{account_value(x,y,s,1,sisi+400+n);account_value(x,y,s,4,sisi+n);}		//死4
					else if(search(x,y,s,"0220"))	{account_value(x,y,s,1,huosan+n);}		//活3
					else if(search(x,y,s,"02020"))	{account_value(x,y,s,1,huosan-200+n);account_value(x,y,s,3,huosan+n);}		//活3
					else if(search(x,y,s,"02020"))	{account_value(x,y,s,1,huosan-200+n);account_value(x,y,s,3,huosan+n);}		//活3
					else if(search(x,y,s,"02210"))	account_value(x,y,s,1,sisan+n);		//死3
					else if(search(x,y,s,"020210"))	{account_value(x,y,s,1,sisan+200+n);account_value(x,y,s,1,sisan+n);}		//死3
					else if(search(x,y,s,"020"))	{account_value(x,y,s,1,huoer+n);}		//活2
					else if(search(x,y,s,"0210"))	account_value(x,y,s,1,sier+n);		//死2
					else if(search(x,y,s,"02010"))	{account_value(x,y,s,1,sier+200+n);account_value(x,y,s,3,sier+n);}		//死2

					
						 if(search(x,y,s,"0111120"))	account_value(x,y,s,1,chengwu);		//成5
					else if(search(x,y,s,"01011120"))	account_value(x,y,s,3,chengwu+200);		//成5
					else if(search(x,y,s,"01101120"))	account_value(x,y,s,4,chengwu+200);		//成5
					else if(search(x,y,s,"01110120"))	account_value(x,y,s,5,chengwu+200);		//成5
					else if(search(x,y,s,"01110"))	{account_value(x,y,s,1,huosi);}		//活4
					else if(search(x,y,s,"010110"))	{account_value(x,y,s,1,huosi-200);account_value(x,y,s,3,huosi);}		//活4
					else if(search(x,y,s,"011010"))	{account_value(x,y,s,1,huosi-200);account_value(x,y,s,4,huosi);}		//活4
					else if(search(x,y,s,"011120"))	account_value(x,y,s,1,sisi);		//死4
					else if(search(x,y,s,"0101120"))	{account_value(x,y,s,1,sisi);account_value(x,y,s,3,sisi+200);}		//死4
					else if(search(x,y,s,"0110"))	{account_value(x,y,s,1,huosan);}		//活3
					else if(search(x,y,s,"01010"))	{account_value(x,y,s,1,huosan-200);account_value(x,y,s,1,huosan);}		//活3
					else if(search(x,y,s,"01120"))	account_value(x,y,s,1,sisan);		//死3
					else if(search(x,y,s,"010120"))	{account_value(x,y,s,1,sisan-200);account_value(x,y,s,3,sisan);}		//死3
					else if(search(x,y,s,"011020"))	{account_value(x,y,s,1,sisan);account_value(x,y,s,2,sisan);}		//死3 
					else if(search(x,y,s,"0110"))	{account_value(x,y,s,2,huoer);}		//活2
					else if(search(x,y,s,"01010"))	{account_value(x,y,s,1,huoer-200);account_value(x,y,s,3,huoer);}		//活2
					else if(search(x,y,s,"0120"))	account_value(x,y,s,1,sier);		//死2
					else if(search(x,y,s,"01020"))	account_value(x,y,s,3,sier+200);		//死2
					else if(search(x,y,s,"010"))	{account_value(x,y,s,1,danzi);}		//单子
						 
				}
				
			}//第一个for循环结束
		}//第二个for循环结束
		
//		for(int y=0;y<ChessSize.HEIGHT;y++) {//权值初始化
//			for(int x=0;x<ChessSize.WIDTH;x++) {
//				if(chessAll[x][y]!=0) {
//					weight[x][y]=0;	
//				}				
//			}
//		}
		int MAX_x=0,MAX_y=0;
		int value=weight[0][0];
		
		for(int y=0;y<ChessSize.HEIGHT;y++) {//找权重的最大值
			for(int x=0;x<ChessSize.WIDTH;x++) {
				if(chessAll[x][y]==0) {						
					if(weight[x][y]>value) {
						value=weight[x][y];
						MAX_x=x;
						MAX_y=y;
					}	
				}
				if(Chess.point_num==1) {
					MAX_x=Chess.point[0].x+1;
					MAX_y=Chess.point[0].y;
				}
			}
		}
		
		for(int y=0;y<ChessSize.HEIGHT;y++) {
			for(int x=0;x<ChessSize.WIDTH;x++) {
//				if(weight[x][y]>=10000) {
//					System.out.print(weight[x][y]+" ");
//				}else if(weight[x][y]>=1000) {
//					System.out.print(weight[x][y]+"  ");
//				}else if(weight[x][y]>=100) {
//					System.out.print(weight[x][y]+"   ");
//				}else if(weight[x][y]>=10) { 
//					System.out.print(weight[x][y]+"    ");
//				}else if(weight[x][y]>=0) {
//					System.out.print(weight[x][y]+"     ");
//				}
				if(weight[x][y]!=0) {
					System.out.println("["+(x+1)+","+(y+1)+"]="+str[x][y]+"="+weight[x][y]);	
				}

			}

		}
		System.out.println();
		

		Chess.PC_Chess_x=MAX_x;
		Chess.PC_Chess_y=MAX_y;
		weight[MAX_x][MAX_y]=0;
		System.out.println("x="+MAX_x+",y="+MAX_y);
		return new Point(MAX_x,MAX_y);
	}

	
	/**
	 * 下棋
	 * @param x
	 * @param y
	 */
	public void add(int x,int y) {
		if(x<=ChessSize.WIDTH-1 && y<=ChessSize.HEIGHT-1) {
			if(chessAll[x][y]==0) {
				if(STEP==BLACK) {
					chessAll[x][y]=BLACK;
					Chess.STEP=Chess.WHITE;
					Chess.LAST_STEP=Chess.BLACK;
					WuZiQiView.textArea.setText("白方下");
					Chess.last_chess_black.add(new Point(x,y));
					Chess.point[Chess.point_num]=new Point(x,y);
					Chess.point_num++;
				}else if(STEP==WHITE){
					chessAll[x][y]=WHITE;
					Chess.STEP=Chess.BLACK;
					Chess.LAST_STEP=Chess.WHITE;
					WuZiQiView.textArea.setText("黑方下");
					Chess.last_chess_white.add(new Point(x,y));
					Chess.point[Chess.point_num]=new Point(x,y);
					Chess.point_num++;
				}
			}
		}	
		
		/*for(int m=0;m<ChessSize.HEIGHT;m++) {//打印棋子
			for(int n=0;n<ChessSize.WIDTH;n++) {
				if(chessAll[n][m]>=100) {
					System.out.print(chessAll[n][m]+" ");
				}else if(chessAll[m][n]>=10) {
					System.out.print(chessAll[n][m]+"  ");
				}else if(chessAll[m][n]>=0) {
					System.out.print(chessAll[n][m]+"   ");
				}
			}
			System.out.println();
		}*/
	}
	
	
	public void drawChess(Graphics g) {
		for(int x=0;x<ChessSize.WIDTH;x++) {
			for(int y=0;y<ChessSize.HEIGHT;y++) {
				if(Chess.chessAll[x][y]==Chess.BLACK) {
					g.setColor(Color.BLACK);
					g.fillArc(x*ChessSize.SIZE+2, y*ChessSize.SIZE+2,ChessSize.SIZE-4,ChessSize.SIZE-4, 0, 360);//画圆
				}else if(Chess.chessAll[x][y]==Chess.WHITE) {
					g.setColor(Color.WHITE);
					g.fillArc(x*ChessSize.SIZE+2, y*ChessSize.SIZE+2,ChessSize.SIZE-4,ChessSize.SIZE-4, 0, 360);//画圆
				}
			}
		}
		
		for(int i=0;i<Chess.point_num;i++) {
			if(i%2==0) {
				g.setColor(Color.WHITE);
			}else {
				g.setColor(Color.BLACK);
			}
			if(i<10) {
				g.drawString(String.valueOf(i),Chess.point[i].x*ChessSize.SIZE+ChessSize.SIZE/2-3,Chess.point[i].y*ChessSize.SIZE+ChessSize.SIZE/2+4);	
			}else {
				g.drawString(String.valueOf(i),Chess.point[i].x*ChessSize.SIZE+ChessSize.SIZE/2-7,Chess.point[i].y*ChessSize.SIZE+ChessSize.SIZE/2+4);
			}
			
		}
	}
	

	public int lostOrWin() {
		int flag=0;//win
		int num=0;
		
		for(int x=0;x<ChessSize.WIDTH;x++) {
			for(int y=0;y<ChessSize.HEIGHT;y++) {
				if(chessAll[x][y]!=0) {
					
					if(chessAll[x][y]==BLACK) {		
						//---------------------------------------------------
						for(int i=0;i<5;i++) {//判断下
							if(y+i<=ChessSize.HEIGHT-1) {
								if(chessAll[x][y+i]==BLACK)	num++;
								else {
									num=0;
									break;
								}
							}else {
								num=0;
								break;
							}
						}
						if(num==5)	flag=10;
						else num=0;
						//----------------------------------------------------
						for(int i=0;i>-5;i--) {//判断上
							if(y+i>=0) {
								if(chessAll[x][y+i]==BLACK)	num++;
								else {
									num=0;
									break;
								}
							}else {
								num=0;
								break;
							}
						}
						if(num==5)	flag=10;
						else num=0;
						//---------------------------------------------------
						for(int i=0;i<5;i++) {//判断右
							if(x+i<=ChessSize.WIDTH-1) {
								if(chessAll[x+i][y]==BLACK)	num++;
								else {
									num=0;
									break;
								}
							}else {
								num=0;
								break;
							}
						}
						if(num==5)	flag=10;
						else num=0;
						//----------------------------------------------------
						for(int i=0;i>-5;i--) {//判断左
							if(x+i>=0) {
								if(chessAll[x+i][y]==BLACK)	num++;
								else {
									num=0;
									break;
								}
							}else {
								num=0;
								break;
							}
						}
						if(num==5)	flag=10;
						else num=0;
						//---------------------------------------------------
						for(int i=0;i<5;i++) {//判断右下
							if(x+i<=ChessSize.WIDTH-1 && y+i<=ChessSize.HEIGHT-1) {
								if(chessAll[x+i][y+i]==BLACK)	num++;
								else {
									num=0;
									break;
								}
							}else {
								num=0;
								break;
							}	
						}
						if(num==5)	flag=10;
						else num=0;
						//---------------------------------------------------
						for(int i=0;i<5;i++) {//判断左下
							if(x-i>=0 && y+i<=ChessSize.HEIGHT-1) {
								if(chessAll[x-i][y+i]==BLACK)	num++;
								else {
									num=0;
									break;
								}
							}else {
								num=0;
								break;
							}							
						}
						if(num==5)	flag=10;
						else num=0;
						//---------------------------------------------------
						for(int i=0;i<5;i++) {//判断右上
							if(x+i<=ChessSize.WIDTH-1 && y-i>=0) {
								if(chessAll[x+i][y-i]==BLACK)	num++;
								else {
									num=0;
									break;
								}
							}else {
								num=0;
								break;
							}
									
						}
						if(num==5)	flag=10;
						else num=0;
						//---------------------------------------------------
						for(int i=0;i<5;i++) {//判断左上
							if(x-i>=0 && y-i>=0) {
								if(chessAll[x-i][y-i]==BLACK)	num++;
								else {
									num=0;
									break;
								}
							}else {
								num=0;
								break;
							}
								
						}
						if(num==5)	flag=10;
						else num=0;
						
						if(flag==10) {
							flag=BLACK;
						}
					}
					//****************************************************************************************************
					else if(chessAll[x][y]==WHITE) {
						if(flag!=BLACK) {
							//---------------------------------------------------
							for(int i=0;i<5;i++) {//判断下
								if(y+i<=ChessSize.HEIGHT-1) {
									if(chessAll[x][y+i]==WHITE)	num++;
									else {
										num=0;
										break;
									}
								}else {
									num=0;
									break;
								}
							}
							if(num==5)	flag=10;
							else num=0;
							//----------------------------------------------------
							for(int i=0;i>-5;i--) {//判断上
								if(y+i>=0) {
									if(chessAll[x][y+i]==WHITE)	num++;
									else {
										num=0;
										break;
									}
								}else {
									num=0;
									break;
								}
							}
							if(num==5)	flag=10;
							else num=0;
							//---------------------------------------------------
							for(int i=0;i<5;i++) {//判断右
								if(x+i<=ChessSize.WIDTH-1) {
									if(chessAll[x+i][y]==WHITE)	num++;
									else {
										num=0;
										break;
									}
								}else {
									num=0;
									break;
								}
							}
							if(num==5)	flag=10;
							else num=0;
							//----------------------------------------------------
							for(int i=0;i>-5;i--) {//判断左
								if(x+i>=0) {
									if(chessAll[x+i][y]==WHITE)	num++;
									else {
										num=0;
										break;
									}
								}else {
									num=0;
									break;
								}
							}
							if(num==5)	flag=10;
							else num=0;
							//---------------------------------------------------
							for(int i=0;i<5;i++) {//判断右下
								if(x+i<=ChessSize.WIDTH-1 && y+i<=ChessSize.HEIGHT-1) {
									if(chessAll[x+i][y+i]==WHITE)	num++;
									else {
										num=0;
										break;
									}
								}else {
									num=0;
									break;
								}	
							}
							if(num==5)	flag=10;
							else num=0;
							//---------------------------------------------------
							for(int i=0;i<5;i++) {//判断左下
								if(x-i>=0 && y+i<=ChessSize.HEIGHT-1) {
									if(chessAll[x-i][y+i]==BLACK)	num++;
									else {
										num=0;
										break;
									}
								}else {
									num=0;
									break;
								}							
							}
							if(num==5)	flag=10;
							else num=0;
							//---------------------------------------------------
							for(int i=0;i<5;i++) {//判断右上
								if(x+i<=ChessSize.WIDTH-1 && y-i>=0) {
									if(chessAll[x+i][y-i]==WHITE)	num++;
									else {
										num=0;
										break;
									}
								}else {
									num=0;
									break;
								}
										
							}
							if(num==5)	flag=10;
							else num=0;
							//---------------------------------------------------
							for(int i=0;i<5;i++) {//判断左上
								if(x-i>=0 && y-i>=0) {
									if(chessAll[x-i][y-i]==WHITE)	num++;
									else {
										num=0;
										break;
									}
								}else {
									num=0;
									break;
								}
									
							}
							if(num==5)	flag=10;
							else num=0;
							
							if(flag==10) {
								flag=WHITE;
							}
						}						
					}
					


				}	
				
				if(flag==WHITE || flag==BLACK)	break;
				else flag=0;
				
			}//一个for循环结束
		}//两个for循环结束
		
		return flag;
			
	}
	
}
