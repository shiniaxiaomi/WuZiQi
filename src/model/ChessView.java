package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import util.ChessSize;
import view.WuZiQiView;





public class ChessView extends JPanel implements MouseListener{
	
	public Chess chess=new Chess();//设置棋子
	/**
	 * 重写画图的方法
	 */
	public void paint(Graphics g) {
		if(Chess.war==Chess.PC) {//人机对战
			PC_paint(g);
		}else if(Chess.war==Chess.PP) {//人人对战
			PP_paint(g);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		if(Chess.war==Chess.PC) {//人机对战
			PC_mousePressed(e);
		}else if(Chess.war==Chess.PP) {//人人对战
			PP_mousePressed(e);
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	
	
	/**
	 * 开始游戏
	 */
	public void reset() {
		if(WuZiQiView.pcWar.isSelected()) {
			Chess.war=Chess.PC;
		}else {
			Chess.war=Chess.PP;
		}
		
		if(Chess.war==Chess.PC) {//人机对战
			PC_reset();
		}else if(Chess.war==Chess.PP) {//人人对战
			PP_reset();
		}	
		Chess.point_num=0;
	}
	
	/**
	 * 悔棋
	 */
	public void remorse() {
		if(Chess.war==Chess.PC) {//人机对战
			PC_remorse();
		}else if(Chess.war==Chess.PP) {//人人对战
			PP_remorse();
		}
	}
	
	
	//悔棋
	public void PC_remorse() {
		if(Chess.last_chess_black.peekLast()!=null) {
			Chess.chessAll[Chess.last_chess_black.getLast().x][Chess.last_chess_black.getLast().y]=0;
			Chess.last_chess_black.removeLast();
			Chess.chessAll[Chess.last_chess_white.getLast().x][Chess.last_chess_white.getLast().y]=0;
			Chess.last_chess_white.removeLast();
			Chess.point_num=Chess.point_num-2;
			this.repaint();//重绘
		}
		
		Chess.lostOrWinFlag=false;
	}
	public void PP_remorse() {
		 
			if(Chess.LAST_STEP==Chess.WHITE) {
				if(Chess.last_chess_white.peekLast()!=null) {
					Chess.chessAll[Chess.last_chess_white.getLast().x][Chess.last_chess_white.getLast().y]=0;
					Chess.last_chess_white.removeLast();
					Chess.STEP=Chess.WHITE;
					Chess.LAST_STEP=Chess.BLACK;
					WuZiQiView.textArea.setText("白方下");
				}	
			}else if(Chess.LAST_STEP==Chess.BLACK){
				if(Chess.last_chess_black.peekLast()!=null) {
					Chess.chessAll[Chess.last_chess_black.getLast().x][Chess.last_chess_black.getLast().y]=0;
					Chess.last_chess_black.removeLast();
					Chess.STEP=Chess.BLACK;
					Chess.LAST_STEP=Chess.WHITE;
					WuZiQiView.textArea.setText("黑方下");
				}
				
			}
			Chess.point_num--;
			Chess.lostOrWinFlag=false;
			this.repaint();//重绘
	}

	//开始游戏
	public void PC_reset() {
		for(int x=0;x<ChessSize.WIDTH;x++) {
			for(int y=0;y<ChessSize.HEIGHT;y++) {
				Chess.chessAll[x][y]=0;
			}
		}
		for(int x=0;x<ChessSize.WIDTH;x++) {//吧已经有的棋的位置权值设置为0
			for(int y=0;y<ChessSize.HEIGHT;y++) {
				Chess.weight[x][y]=0;
			}
		}
		Chess.last_chess_black.clear();
		Chess.last_chess_white.clear();
		
		Chess.STEP=Chess.BLACK;
		this.repaint();//重绘
		WuZiQiView.textArea.setText("黑方下");
		WuZiQiView.textArea_1.setText("现在是：人机对战");
	}
	public void PP_reset() {
		for(int x=0;x<ChessSize.WIDTH;x++) {
			for(int y=0;y<ChessSize.HEIGHT;y++) {
				Chess.chessAll[x][y]=0;
			}
		}
		Chess.last_chess_black.clear();
		Chess.last_chess_white.clear();
		Chess.STEP=Chess.BLACK;
		this.repaint();//重绘
		WuZiQiView.textArea.setText("黑方下");
		WuZiQiView.textArea_1.setText("现在是：人人对战");
	}
	
	//鼠标按下
	public void PC_mousePressed(MouseEvent e) {
		if(Chess.lostOrWinFlag!=true) {

			int x=e.getX()/ChessSize.SIZE;
			int y=e.getY()/ChessSize.SIZE;
			if(Chess.chessAll[x][y]==0) {
				chess.add(x,y);//人下棋
				this.repaint();//重绘
				if(chess.lostOrWin()==Chess.WHITE) {
					Chess.lostOrWinFlag=true;
					JOptionPane.showMessageDialog(null,"白棋胜");
					//System.out.println("白棋胜");
				}
				else if(chess.lostOrWin()==Chess.BLACK) {
					Chess.lostOrWinFlag=true;
					JOptionPane.showMessageDialog(null,"黑棋胜");
					//System.out.println("黑棋胜");
				}
				
				if(Chess.lostOrWinFlag!=true) {
					Point p=chess.PC_Calculation();
					chess.add(p.x, p.y);//电脑下棋
					this.repaint();//重绘
					if(chess.lostOrWin()==Chess.WHITE) {
						Chess.lostOrWinFlag=true;
						JOptionPane.showMessageDialog(null,"白棋胜");
						//System.out.println("白棋胜");
					}
					else if(chess.lostOrWin()==Chess.BLACK) {
						Chess.lostOrWinFlag=true;
						JOptionPane.showMessageDialog(null,"黑棋胜");
						//System.out.println("黑棋胜");
					}
				}
				
			}
			//System.out.println("x="+x+",y="+y);
		}
	}
	public void PP_mousePressed(MouseEvent e) {
		if(Chess.lostOrWinFlag!=true) {
			int x=e.getX()/ChessSize.SIZE;
			int y=e.getY()/ChessSize.SIZE;
			chess.add(x,y);//添加棋子

			this.repaint();//重绘
			if(chess.lostOrWin()==Chess.WHITE) {
				Chess.lostOrWinFlag=true;
				JOptionPane.showMessageDialog(null,"白棋胜");
				//System.out.println("白棋胜");
			}
			else if(chess.lostOrWin()==Chess.BLACK) {
				Chess.lostOrWinFlag=true;
				JOptionPane.showMessageDialog(null,"黑棋胜");
				//System.out.println("黑棋胜");
			}
			
			//System.out.println("x="+x+",y="+y);
		}
	}
	
	//重绘
	public void PC_paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, ChessSize.WIDTH*ChessSize.SIZE,ChessSize.HEIGHT*ChessSize.SIZE);
		g.setColor(Color.BLACK);
		
		//画出棋盘
		for(int i=0;i<=ChessSize.HEIGHT*ChessSize.SIZE;i=i+ChessSize.SIZE) {
			g.drawRect(0, i, ChessSize.HEIGHT*ChessSize.SIZE, 1);	
		}
		for(int i=0;i<=ChessSize.WIDTH*ChessSize.SIZE;i=i+ChessSize.SIZE) {
			g.drawRect(i, 0, 1, ChessSize.WIDTH*ChessSize.SIZE);		
		}

		chess.drawChess(g);//画出棋子
		
		
			
	}
	public void PP_paint(Graphics g) {
		//g.fillRect(0, 0, ChessSize.WIDTH*ChessSize.SIZE,ChessSize.HEIGHT*ChessSize.SIZE);//先清屏
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, ChessSize.WIDTH*ChessSize.SIZE,ChessSize.HEIGHT*ChessSize.SIZE);
		
		
		g.setColor(Color.BLACK);
		
		//画出棋盘
		for(int i=0;i<=ChessSize.HEIGHT*ChessSize.SIZE;i=i+ChessSize.SIZE) {
			g.drawRect(0, i, ChessSize.HEIGHT*ChessSize.SIZE, 1);	
		}
		for(int i=0;i<=ChessSize.WIDTH*ChessSize.SIZE;i=i+ChessSize.SIZE) {
			g.drawRect(i, 0, 1, ChessSize.WIDTH*ChessSize.SIZE);		
		}

		
		chess.drawChess(g);//画出棋子

	}
}



