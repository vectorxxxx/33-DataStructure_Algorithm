package xyz.funnyboy.a_datastructure.f_tree.e_huffmancode;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-21 17:25:39
 */
public class HuffmanDemo
{
	public static void main(String[] args) {
		// final String s = "i like like like java do you like a java";
		//
		// final byte[] bytes = s.getBytes();
		// System.out.println("压缩前：" + bytes.length); // 40
		//
		// final Map<Byte, String> huffmanCodes = HuffmanCode.getHuffmanCodes(bytes);
		// System.out.println(huffmanCodes); // {32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
		//
		// final byte[] encode = HuffmanCode.encode(bytes, huffmanCodes);
		// System.out.println("压缩后：" + encode.length);  // 17
		//
		// final byte[] decode = HuffmanCode.decode(huffmanCodes, encode);
		// System.out.println("解压：" + new String(decode));
		
		final String srcFile = "C:\\Users\\uxiah\\Downloads\\test.xml";
		final String dstFile = "C:\\Users\\uxiah\\Downloads\\test.zip";
		HuffmanZip.zipFile(srcFile, dstFile);
		System.out.println("压缩完成~");

		final String zipFile = "C:\\Users\\uxiah\\Downloads\\test.zip";
		final String dstFile2 = "C:\\Users\\uxiah\\Downloads\\test2.xml";
		HuffmanZip.unZipFile(zipFile, dstFile2);
		System.out.println("解压完成~");
	}
}
