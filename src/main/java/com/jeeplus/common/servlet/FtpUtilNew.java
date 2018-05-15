package com.jeeplus.common.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * FTP 上传下载
 * 兼容jdk 1.6和1.7问题
 * @author hubowei
 * 2014-4-17 16:08:34
 *
 */
public class FtpUtilNew {
	private FTPClient ftp;
	private String ip = "";
	private String username = "";
	private String password = "";
	private int port = -1;
	private static String encoding = System.getProperty("file.encoding");
	private static final String separator=File.separator; 

	public FtpUtilNew(String serverIP, String username, String password) {
		this.ip = serverIP;
		this.username = username;
		this.password = password;
	}

	public FtpUtilNew(String serverIP, int port, String username,
			String password) {
		this.ip = serverIP;
		this.username = username;
		this.password = password;
		this.port = port;
	}
	/**
	 * 连接ftp服务器
	 * 
	 * @throws IOException
	 */
	public boolean connectServer() {
		boolean result = true;
		ftp = new FTPClient();
		try {
			ftp.connect(ip, port);// 连接FTP服务器
			ftp.login(username, password);// 登陆FTP服务器
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				System.out.println("未连接到FTP，用户名或密码错误。");
				result = false;
				ftp.disconnect();
			} else {
				System.out.println("FTP连接成功。");
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.out.println("FTP的IP地址可能错误，请正确配置。");
			result = false;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("FTP的端口错误,请正确配置。");
			result = false;
		}
		return result;
	}

	/**
	 * 
	 * @param is 传送到远程FTP的文件流
	 * @param newname 文件名 TShareFile表的ID+文件后缀名
	 * @param filePath //44352/587445711/2014/3 上传到FTP的路径
	 * @return
	 */
	public boolean uploadFileToInput(InputStream is, String  filePath) {
		boolean result = false;
		try {
			upload(is, filePath);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * 上传文件到FTP服务器
	 * 
	 * @param InputStream
	 *            本地文件名称上传的文件流
	 * @param remote
	 *            远程文件路径,支持多级目录嵌套，支持递归创建不存在的目录结构
	 * @throws IOException
	 */
	public void upload(InputStream is, String remote) throws IOException {
		// 设置PassiveMode传输
		ftp.enterLocalPassiveMode();
		// 设置以二进制流的方式传输
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		// 对远程目录的处理
		String remoteFileName = remote;
		if (remote.contains(separator)) {
			remoteFileName = remote.substring(remote.lastIndexOf(separator) + 1);
			// 创建服务器远程目录结构，创建失败直接返回
			if (!CreateDirecroty(remote)) {
				return;
			}
		}
		uploadFile(is, remoteFileName);
	}

	/**
	 * 上传文件到FTP服务器
	 * 
	 * @param local
	 *            本地文件名称，绝对路径
	 * @param remote
	 *            远程文件路径,支持多级目录嵌套，支持递归创建不存在的目录结构
	 * @throws IOException
	 */
	public void upload(String local, String remote) throws IOException {
		// 设置PassiveMode传输
		ftp.enterLocalPassiveMode();
		// 设置以二进制流的方式传输
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		// 对远程目录的处理
		String remoteFileName = remote;
		if (remote.contains(separator)) {
			remoteFileName = remote.substring(remote.lastIndexOf(separator) + 1);
			// 创建服务器远程目录结构，创建失败直接返回
			if (!CreateDirecroty(remote)) {
				return;
			}
		}
		File f = new File(local);
		uploadFile(remoteFileName, f);
	}
	
	/**
	 * 
	 * @param in 存放在FTP的文件流
	 * @param remote  远程文件路径
	 * @throws IOException
	 */
	public void uploadFile(InputStream in, String remote) throws IOException {
		ftp.storeFile(remote, in);
		in.close();
	}
	/**
	 * @param remoteFile 远程文件路径
	 * @param localFile  本地文件
	 * @throws IOException
	 */
	public void uploadFile(String remoteFile, File localFile)
			throws IOException {
		InputStream in = new FileInputStream(localFile);
		ftp.storeFile(remoteFile, in);
		in.close();
	}

	/** 
	/**
	 * 递归创建远程服务器目录
	 * 
	 * @param remote
	 *            远程服务器文件绝对路径
	 * @return 目录创建是否成功
	 * @throws IOException
	 */
	public boolean CreateDirecroty(String remote) throws IOException {
		boolean success = true;
		String directory = remote.substring(0, remote.lastIndexOf(separator) + 1);
		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase(separator)&& !ftp.changeWorkingDirectory(new String(directory))) {
			int start = 0;
			int end = 0;
			if (directory.startsWith(separator)) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf(separator, start);
			while (true) {
				String subDirectory = new String(remote.substring(start, end));
				if (!ftp.changeWorkingDirectory(subDirectory)) {
					if (ftp.makeDirectory(subDirectory)) {
						ftp.changeWorkingDirectory(subDirectory);
						System.out.println("创建目录:" + subDirectory);
					} else {
						System.out.println("创建目录失败");
						success = false;
						return success;
					}
				}
				start = end + 1;
				end = directory.indexOf(separator, start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}
	/**
	 * @退出关闭服务器链接
	 */
	public void closeServer() {
		if (null != this.ftp && this.ftp.isConnected()) {
			try {
				boolean reuslt = this.ftp.logout();// 退出FTP服务器
				if (reuslt) {
					System.out.println("成功退出服务器");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					this.ftp.disconnect();// 关闭FTP服务器的连接
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * Description: 从FTP服务器下载文件
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名 （1、不传参数则在localPath=\\aa\\bb\\x.txt，传参数\\aa\\bb）
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public boolean downloadFile(String remotePath,String localPath) {
		boolean result = false;
		localPath = localPath.replace("\\", "/");//支持unix和lunix系统
		System.out.println(remotePath.lastIndexOf(separator));
		if(remotePath.lastIndexOf(separator)==-1){
			remotePath = remotePath.substring(0, remotePath.lastIndexOf("/"));// 获取路径为\\44321\\88744\\25012\\3  不能是\\44321\\88744\\25012\\3\\xxx.jpg
		}else{
			remotePath = remotePath.substring(0, remotePath.lastIndexOf(separator));// 获取路径为\\44321\\88744\\25012\\3  不能是\\44321\\88744\\25012\\3\\xxx.jpg
		}
		int iName = localPath.lastIndexOf("/");
		String fileName = localPath.substring(iName + 1);
		try {
			createFile(localPath);//创建文件夹
			ftp.setControlEncoding("GBK");
			//ftp.setControlEncoding(encoding);
			// 设置文件传输类型为二进制
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 转移到FTP服务器目录至指定的目录下
			ftp.changeWorkingDirectory(new String(remotePath.getBytes(encoding), "iso-8859-1"));
			ftp.enterLocalPassiveMode();//新添加
			// 获取文件列表
			FTPFile[] fs = ftp.listFiles();
			for (FTPFile ff : fs) {
				//System.out.println(ff.getName());
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath);
					OutputStream is = new FileOutputStream(localFile);
					ftp.retrieveFile(ff.getName(), is);
					is.close();
				}
			}
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static boolean createFile(String path) throws IOException {
		File file=new File(path);
		if(! file.exists()) {
			makeDir(file.getParentFile());
		}
		return file.createNewFile();
	}
	public static void makeDir(File dir) {
		if(! dir.getParentFile().exists()) {
			makeDir(dir.getParentFile());
		}
		dir.mkdir();
	}
	public static void main(String[] args) throws FileNotFoundException{
		 FileInputStream in = new FileInputStream(new File("E:/oracle.txt"));
//		FtpUtilNew ftp = new FtpUtilNew("192.9.207.5", 21, "administrator","123");
		FtpUtilNew ftp = new FtpUtilNew("192.9.207.84", 21, "admin","123");
		ftp.connectServer();
//		ftp.uploadFileToInput(in,  "\\ddd11\\2101312111\\51871271\\tex1t1.txt");
		System.out.println("11");
		
		
		ftp.downloadFile("\\ddd11\\2101312111\\51871271", "E://FILEDOWNLOAD//2014//04//xx.txt");
		ftp.closeServer();
		// ftp.upload("bb/cc", "text.txt", in);
		// ftp.upload("E:/contact.txt",
		// "/xxxx111/ddd11/2101312111/51871271/tex1t1.txt");
		// InputStream in = new FileInputStream("E:/contact.txt");
		
		String file="\440600\005887544\2014\7\20140724144319105.gif";
		
	}

}