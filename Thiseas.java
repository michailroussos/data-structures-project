import java.io.*;
import java.util.StringTokenizer;

public class Thiseas {
	// lines and columns of the (array) labyrinth
	int numlines = 0;
	int numcolumns = 0;
	// coordinates of the entrance
	int entranceline = 0;
	int entrancecolumn = 0;
	boolean correctformat = true;
	char[][] labyrinth;

	public Thiseas() {
	}

	public void print() {
		System.out.println(numlines + " " + numcolumns);
		System.out.println(entranceline + " " + entrancecolumn);
		for (int k = 0; k < numlines; k++) {
			for (int j = 0; j < numcolumns; j++) {

				System.out.print(labyrinth[k][j]);
			}
			System.out.print("\n");
		}

	}

	public void loadFile(String data) {
		// boolean numlb=false;
		// boolean numcb=false;
		int Entrance = 0;
		boolean extrael = false;
		boolean lessel = false;
		int counter = 0;
		// File f = null;
		BufferedReader reader = null;
		String line = " ";
		StringTokenizer tok;
		// try {
		// //f = new File(data);
		// } catch (NullPointerException e) {
		// System.err.println("Error opening file!");
		// }

		try {
			reader = new BufferedReader(new FileReader(data));

		} catch (FileNotFoundException e) {
			System.err.println("Error opening file!");
		}

		try {

			line = reader.readLine();
			while (line != null) {
				tok = new StringTokenizer(line);
				if (counter == 0) {
					numlines = Integer.parseInt(tok.nextToken());
					numcolumns = Integer.parseInt(tok.nextToken());
					labyrinth = new char[numlines][numcolumns];
				} else if (counter == 1) {
					entranceline = Integer.parseInt(tok.nextToken());
					entrancecolumn = Integer.parseInt(tok.nextToken());

				} else {

					for (int i = 0; i < numcolumns; i++) {
						// in the else case the counter starts with the value of
						// 2. so we need to subtract 2 to get to column 0 of the
						// array.
						if (tok.hasMoreTokens()) {
							labyrinth[counter - 2][i] = tok.nextToken().charAt(
									0);
							if (labyrinth[counter - 2][i] == 'E') {
								Entrance++;
							}
							if (labyrinth[counter - 2][i] != '0'
									&& labyrinth[counter - 2][i] != '1'
									&& labyrinth[counter - 2][i] != 'E') {
								correctformat = false;
								System.out.println("Wrong File Format!");
								return;
							}
						}

					}
					if ((int) labyrinth[counter - 2][numcolumns - 1] == 0) {
						lessel = true;
						break;
					}

					if (tok.hasMoreTokens()) {
						extrael = true;
						break;

					}

				}
				line = reader.readLine();
				counter++;
				if ((counter == numlines + 2) && (line != null)) {
					extrael = true;
					System.out.print(line);
					break;
				}

			}
			if ((int) labyrinth[numlines - 1][0] == 0) {
				lessel = true;
			}

		} catch (IOException e) {
			System.out.println("Error reading line " + counter + ".");
		}
		if (extrael || lessel || Entrance != 1) {
			System.out.println("The file's structure is not right.");
			correctformat = false;
			return;
		}
	}

	public void findExits() {
		StringStackImpl<String> currentplace = new StringStackImpl<>();
		int prevline = entranceline;
		int prevcol = entrancecolumn;
		boolean continue1 = true;
		StringTokenizer tok;
		int paths;
		int line=entranceline;
		int	column=entrancecolumn;
		while (continue1) {
			paths=0;
			if (prevline!= 0) {/////panw
				if(labyrinth[prevline-1][prevcol]=='0'/*&& wherecantIgo[0]!=true*/){
						line--;
						labyrinth[prevline-1][prevcol]='X';
						paths++;
						System.out.println("panw");
				}
			}
			if (prevline!= numlines - 1) {///////katw
				if(labyrinth[prevline+1][prevcol]=='0'/*&& wherecantIgo[1]!=true*/){
					System.out.println("katw");
					if (paths==0){
						line++;
						labyrinth[prevline+1][prevcol]='X';
						paths++;
					}else if(paths>0){
						paths++;
					}
				}
			}
			if (prevcol != 0) {////////////aristera
				if(labyrinth[prevline][prevcol-1]=='0'){
					System.out.println("aristera");
					if (paths==0){
						column--;
						labyrinth[prevline][prevcol-1]='X';
						paths++;
						
					}
					else if(paths>0){
						paths++;
						
						
					}
					
				}
			}
			if (prevcol != numcolumns - 1) {//////de3ia
				if(labyrinth[prevline][prevcol+1]=='0'){
					System.out.println("DEXIA");
					if (paths==0){
						column++;
						labyrinth[prevline][prevcol+1]='X';
						paths++;
						
					}
					else if(paths>0){
						paths++;
						System.out.println("de3ia>1");
					}
				}
			}
			//////////////////telowwwwwwws
			
			if (paths==0){
				if (currentplace.isEmpty()){
					System.out.println("There is no exit!");
					break;
				}
				tok=new StringTokenizer(currentplace.pop());
				line=Integer.parseInt(tok.nextToken(","));
				column=Integer.parseInt(tok.nextToken(","));
				System.out.println(line+" "+column);
			}else if(paths>1){
				currentplace.push(prevline +"," +prevcol);
				System.out.println(currentplace.peek());
			}
			
			System.out.println("("+line+","+column+")");
			prevline=line;
			prevcol=column;
			if(((line==numlines-1) || (column==numcolumns-1) || (line==0) || (column==0))){
				
				 continue1=false;
			 }
		}
		if (continue1==false){
			System.out.println("The exit is: ("+line+","+column+")");
		}
	}

	public static void main(String[] args) {
		Thiseas th = new Thiseas();
		th.loadFile("C:/Users/Konstantina/Desktop/javamixalh/Labyrinth.txt");
		if (th.correctformat) {
			th.print();
			th.findExits();
		}

	}

}
