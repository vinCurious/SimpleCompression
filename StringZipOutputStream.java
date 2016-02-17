/* 
 * StringZipOutputStream.java 
 * 
 * 
 */

import java.io.IOException;
import java.io.OutputStream;

/**
 * This StringZipOutputStream class responsible for compression of the file.
 * 
 * @author Vinay Vasant More
 *
 */
public class StringZipOutputStream{

	OutputStream CompressedData;
	int EmptyLineCount=0;
	int count=0;
	
	// Creates a new output stream with a default buffer size.
	public StringZipOutputStream(OutputStream out)	{
		      CompressedData=out;
	}
	
	byte[] compress(String txt){
		int length = txt.length();
		byte compressed[]=new byte[(int)(7.0*Math.ceil(length/8.0))];
		char str[]=new char[length];
		txt.getChars(0,length,str,0);
		String tempString;
		String binString = new String("");
		for (int i = 0;i<length; i++){
			tempString = Integer.toBinaryString(toValue(str[i]));
			while(tempString.length()%7 != 0){
				tempString="0"+tempString;
			}
			binString=binString+tempString;
		}
		while(binString.length()%8 != 0){
		   binString=binString+"0";
		}
		Integer tempInt =new Integer(0);
		for(int i=0 ; i<binString.length();i=i+8){
			tempInt = tempInt.valueOf(binString.substring(i,i+8),2);
			compressed[i/8]=tempInt.byteValue();
		}
		return compressed;
	}
	
	int toValue(char ch){
		int chaVal = 0;
		switch(ch){
			case' ':chaVal=0;break; 
			case'a':chaVal=1;break;
			case'b':chaVal=2;break; 
			case'c':chaVal=3;break;
			case'd':chaVal=4;break; 
			case'e':chaVal=5;break;
			case'f':chaVal=6;break; 
			case'g':chaVal=7;break;
			case'h':chaVal=8;break; 
			case'i':chaVal=9;break;
			case'j':chaVal=10;break; 
			case'k':chaVal=11;break;
			case'l':chaVal=12;break; 
			case'm':chaVal=13;break;
			case'n':chaVal=14;break; 
			case'o':chaVal=15;break;
			case'p':chaVal=16;break; 
			case'q':chaVal=17;break;
			case'r':chaVal=18;break; 
			case's':chaVal=19;break;
			case't':chaVal=20;break; 
			case'u':chaVal=21;break;
			case'v':chaVal=22;break; 
			case'w':chaVal=23;break;
			case'x':chaVal=24;break; 
			case'y':chaVal=25;break;
			case'z':chaVal=26;break; 
			case'A':chaVal=27;break; 
			case'B':chaVal=28;break;
			case'C':chaVal=29;break; 
			case'D':chaVal=30;break;
			case'E':chaVal=31;break; 
			case'F':chaVal=32;break;
			case'G':chaVal=33;break; 
			case'H':chaVal=34;break;
			case'I':chaVal=35;break; 
			case'J':chaVal=36;break;
			case'K':chaVal=37;break; 
			case'L':chaVal=38;break;
			case'M':chaVal=39;break; 
			case'N':chaVal=40;break;
			case'O':chaVal=41;break; 
			case'P':chaVal=42;break;
			case'Q':chaVal=43;break; 
			case'R':chaVal=44;break;
			case'S':chaVal=45;break; 
			case'T':chaVal=46;break;
			case'U':chaVal=47;break; 
			case'V':chaVal=48;break;
			case'W':chaVal=49;break;
			case'X':chaVal=50;break; 
			case'Y':chaVal=51;break;
			case'Z':chaVal=52;break;

			case'.':chaVal=53;break;
			case',':chaVal=54;break;
			case';':chaVal=55;break;
			case'/':chaVal=56;break;
			case'!':chaVal=57;break;
			case'@':chaVal=58;break;
			case'#':chaVal=59;break;
			case'$':chaVal=60;break;
			case'%':chaVal=61;break;
			case'^':chaVal=62;break;
			case'&':chaVal=63;break;
			case'(':chaVal=64;break;
			case')':chaVal=65;break;
			case'-':chaVal=66;break;
			case'_':chaVal=67;break;
			case'+':chaVal=68;break;
			case'=':chaVal=69;break;
			case'*':chaVal=70;break;
			case'{':chaVal=71;break;
			case'}':chaVal=72;break;
			case'[':chaVal=73;break;
			case']':chaVal=74;break;
			case'|':chaVal=75;break;
			case':':chaVal=76;break;
			case'"':chaVal=77;break;
			case'?':chaVal=78;break;
			case'>':chaVal=79;break;
			case'<':chaVal=80;break;
			case'~':chaVal=81;break;
			case'`':chaVal=82;break;

			case'0':chaVal=83;break;
			case'1':chaVal=84;break;
			case'2':chaVal=85;break; 
			case'3':chaVal=86;break;
			case'4':chaVal=87;break;
			case'5':chaVal=88;break;
			case'6':chaVal=89;break;
			case'7':chaVal=90;break;
			case'8':chaVal=91;break;
			case'9':chaVal=92;break;
			default:chaVal=93;
		}		
		return chaVal;
	}
	
	// Writes aStrign compressed output stream. This method will block until all data is written.
	public void write(String aString) throws IOException {

		if(aString.isEmpty())
		{
			EmptyLineCount=EmptyLineCount+1;
		}
		else
		{
			CompressedData.write(compress(aString));
		}
		CompressedData.write("\n".getBytes());
		count=count+1;
		//System.out.println("Empty Lines count: "+EmptyLineCount+" Total Lines Count: "+count);
	}
	// Writes remaining data to the output stream and closes the underlying stream.
	public void close() throws IOException {
		CompressedData.close();
	}
} 
