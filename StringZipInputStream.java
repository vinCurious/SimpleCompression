/* 
 * StringZipInputStream.java 
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;


/**
 * This StringZipInputStream class responsible for decompression of the file.
 * 
 * @author Vinay Vasant More
 *
 */
public class StringZipInputStream {

	String str;
	BufferedReader input;
	byte[] uncompressed;

	// Creates a new input stream with a default buffer size.
	public StringZipInputStream(InputStream out) throws FileNotFoundException {
		input = new BufferedReader(new FileReader("words.compress"));
	}

	String unCompress(byte[] compressed) {
		String strTemp = new String("");
		String strBinary = new String("");
		String strText = new String("");
		Integer tempInt = new Integer(0);
		int intVal = 0;
		for (int i = 0; i < compressed.length; i++) {
			if (compressed[i] < 0) {
				intVal = (int) compressed[i] + 256;
			} else
				intVal = (int) compressed[i];
			strTemp = Integer.toBinaryString(intVal);
			while (strTemp.length() % 8 != 0) {
				strTemp = "0" + strTemp;
			}
			strBinary = strBinary + strTemp;
		}
		for (int i = 0; i <strBinary.length()-6; i = i + 7) {
			tempInt = tempInt.valueOf(strBinary.substring(i, i + 7), 2);
			strText = strText + toChar(tempInt.intValue());
		}
		return strText+"\n";
	}

	char toChar(int val) {
		char ch = ' ';
		switch (val) {
		case 0:	 ch = ' '; break;
		case 1:	 ch = 'a'; break;
		case 2:  ch = 'b'; break;
		case 3:  ch = 'c'; break;
		case 4:  ch = 'd'; break;
		case 5:  ch = 'e'; break;
		case 6:  ch = 'f'; break;
		case 7:  ch = 'g'; break;
		case 8:  ch = 'h'; break;
		case 9:  ch = 'i'; break;
		case 10: ch = 'j'; break;
		case 11: ch = 'k'; break;
		case 12: ch = 'l'; break;
		case 13: ch = 'm'; break;
		case 14: ch = 'n'; break;
		case 15: ch = 'o'; break;
		case 16: ch = 'p'; break;
		case 17: ch = 'q'; break;
		case 18: ch = 'r'; break;
		case 19: ch = 's'; break;
		case 20: ch = 't'; break;
		case 21: ch = 'u'; break;
		case 22: ch = 'v'; break;
		case 23: ch = 'w'; break;
		case 24: ch = 'x'; break;
		case 25: ch = 'y'; break;
		case 26: ch = 'z'; break;
		case 27: ch = 'A'; break;
		case 28: ch = 'B'; break;
		case 29: ch = 'C'; break;
		case 30: ch = 'D'; break;
		case 31: ch = 'E'; break;
		case 32: ch = 'F'; break;
		case 33: ch = 'G'; break;
		case 34: ch = 'H'; break;
		case 35: ch = 'I'; break;
		case 36: ch = 'J'; break;
		case 37: ch = 'K'; break;
		case 38: ch = 'L'; break;
		case 39: ch = 'M'; break;
		case 40: ch = 'N'; break;
		case 41: ch = 'O'; break;
		case 42: ch = 'P'; break;
		case 43: ch = 'Q'; break;
		case 44: ch = 'R'; break;
		case 45: ch = 'S'; break;
		case 46: ch = 'T'; break;
		case 47: ch = 'U'; break;
		case 48: ch = 'V'; break;
		case 49: ch = 'W'; break;
		case 50: ch = 'X'; break;
		case 51: ch = 'Y'; break;
		case 52: ch = 'Z'; break;
    	case 53: ch = '.'; break;
		case 54: ch = ','; break;
		case 55:
			ch = ';';
			break;
		case 56:
			ch = '/';
			break;
		case 57:
			ch = '!';
			break;
		case 58:
			ch = '@';
			break;
		case 59:
			ch = '#';
			break;
		case 60:
			ch = '$';
			break;
		case 61:
			ch = '%';
			break;
		case 62:
			ch = '^';
			break;
		case 63:
			ch = '&';
			break;
		case 64:
			ch = '(';
			break;
		case 65:
			ch = ')';
			break;
		case 66:
			ch = '-';
			break;
		case 67:
			ch = '_';
			break;
		case 68:
			ch = '+';
			break;
		case 69:
			ch = '=';
			break;
		case 70:
			ch = '*';
			break;
		case 71:
			ch = '{';
			break;
		case 72:
			ch = '}';
			break;
		case 73:
			ch = '[';
			break;
		case 74:
			ch = ']';
			break;
		case 75:
			ch = '|';
			break;
		case 76:
			ch = ':';
			break;
		case 77:
			ch = '"';
			break;
		case 78:
			ch = '?';
			break;
		case 79:
			ch = '>';
			break;
		case 80:
			ch = '<';
			break;
		case 81:
			ch = '~';
			break;
		case 82:
			ch = '`';
			break;

		case 83:
			ch = '0';
			break;
		case 84:
			ch = '1';
			break;
		case 85:
			ch = '2';
			break;
		case 86:
			ch = '3';
			break;
		case 87:
			ch = '4';
			break;
		case 88:
			ch = '5';
			break;
		case 89:
			ch = '6';
			break;
		case 90:
			ch = '7';
			break;
		case 91:
			ch = '8';
			break;
		case 92:
			ch = '9';
			break;
		case 93:
			ch = ' ';
			break;
		default: ch = ' ';
		}
		return ch;
	}
	// Reads data into a string. the method will block until some input can be
	// read; otherwise, no bytes are read and null is returned.
	public String read() throws IOException {
		String str = input.readLine();
		if (str==null)
				return null;
		else{
		uncompressed = str.getBytes();
		return unCompress(uncompressed);
		}
		}

	// Closes this input stream and releases any system resources associated
	// with the stream.
	public void close() throws IOException {
		input.close();
	}
}
