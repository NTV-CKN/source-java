package thunghiem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test   {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer("Laptop,Mouse,Keyboard", "," + '"');
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}
}
