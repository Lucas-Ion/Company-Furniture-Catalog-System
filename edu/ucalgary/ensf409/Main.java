package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;

/**
 * @author Colton Giesbrecht <a href=
 *         "mailto:colton.giesbrecht1@ucalgary.ca">colton.giesbrecht@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

public class Main {
	
	static File outFile;
    static FileWriter fw;
    static PrintWriter pw;

	public static void main(String[] args) {

		StringBuilder output = new StringBuilder();

		Scanner scan = new Scanner(System.in);

		outFile = new File("output.txt");

        try {
            fw = new FileWriter(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pw = new PrintWriter(fw);

		FileIO fileIO = new FileIO();

		pw.print(fileIO.formatOutput());
		pw.close();

	}
	
}
