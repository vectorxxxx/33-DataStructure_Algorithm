package xyz.funnyboy.a_datastructure.f_tree.e_huffmancode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-21 16:57:59
 */
public class HuffmanZip
{
	/**
	 * 压缩文件
	 *
	 * @param srcFile 源文件
	 * @param dstFile 目标文件
	 */
	public static void zipFile(String srcFile, String dstFile) {
		try (final FileInputStream fis = new FileInputStream(srcFile);
		     final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dstFile))) {
			byte[] bytes = new byte[fis.available()];
			//noinspection ResultOfMethodCallIgnored
			fis.read(bytes);
			final Map<Byte, String> huffmanCodes = HuffmanCode.getHuffmanCodes(bytes);
			final byte[] huffmanBytes = HuffmanCode.encode(bytes, huffmanCodes);
			oos.writeObject(huffmanBytes);
			oos.writeObject(huffmanCodes);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解压文件
	 *
	 * @param zipFile zip 文件
	 * @param dstFile DST 文件
	 */
	public static void unZipFile(String zipFile, String dstFile) {
		try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(zipFile));
		     final OutputStream fos = new FileOutputStream(dstFile)) {
			final byte[] huffmanBytes = (byte[]) ois.readObject();
			final Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
			final byte[] bytes = HuffmanCode.decode(huffmanCodes, huffmanBytes);
			fos.write(bytes);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
