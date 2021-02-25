import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static double[] ages;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int numLines = Integer.parseInt(br.readLine());
		String[] lines = new String[numLines];
		for (int i = 0; i < lines.length; i++) {
			String line = br.readLine();
			if(line!=null) {
				lines[i] = line;
			}
		}
		br.close();
		int k = 0;
		while(k<lines.length) {
			double average = convertLines(lines[k]);
			String message = "";
			for (int i = 0; i < ages.length; i++) {
				if(i == ages.length-1) {
					message += ages[i];
				}else if(i != ages.length-1){
					message += ages[i]+" ";
				}
			}
			bw.write(average+"-"+message+"\n");
			k++;
		}
		bw.flush();
		bw.close();
	}
	
	public static double convertLines(String line) throws IOException{
		String copyOfLine = line;
		String[] parts = copyOfLine.split(" ");
		ages = new double[parts.length];
		for(int j = 0;j<parts.length;j++) {
			ages[j] = Double.parseDouble(parts[j]);
		}
		double average = bubbleSortingOfAges();
		return average;
	}
	
	public static double bubbleSortingOfAges() throws IOException {
		double swaps = 0, numReplays = 0;
		for(int i=1;i<ages.length;i++) {
			for(int j=0;j<ages.length-i;j++) {
				if(ages[j]>ages[j+1]) {
					double temp = ages[j];
					ages[j] = ages[j+1];
					ages[j+1] = temp;
					swaps++;
				}
			}
			numReplays += 1;
		}
		
		double average = swaps/numReplays;
		average = average * 100.0;
		average = (int) average;
		average = average/100.0;
		return average;
	}

}
